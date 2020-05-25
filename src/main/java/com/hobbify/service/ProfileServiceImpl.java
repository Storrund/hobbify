package com.hobbify.service;

import com.hobbify.model.Hobby;
import com.hobbify.model.Profile;
import com.hobbify.model.ProfileFriend;
import com.hobbify.repository.ProfileFriendJPARepository;
import com.hobbify.repository.ProfileJPARepository;
import com.hobbify.repository.ProfilePageRequester;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileDTOMapper;
import com.hobbify.service.dto.ProfileUpdateDTO;
import com.hobbify.service.vo.HobbyVo;
import com.hobbify.service.vo.ProfileVo;
import com.hobbify.service.vo.ProfileVoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileJPARepository profileJPARepository;
    private final ProfileDTOMapper profileDTOMapper;
    private final ProfileVoMapper profileVoMapper;

    private final HobbyService hobbyService;

    private final ProfileFriendJPARepository profileFriendJPARepository;

    public ProfileServiceImpl(
            ProfileJPARepository profileJPARepository,
            ProfileDTOMapper profileDTOMapper,
            ProfileVoMapper profileVoMapper,
            HobbyService hobbyService,
            ProfileFriendJPARepository profileFriendJPARepository){
        this.profileJPARepository = profileJPARepository;
        this.profileDTOMapper = profileDTOMapper;
        this.profileVoMapper = profileVoMapper;
        this.hobbyService = hobbyService;
        this.profileFriendJPARepository = profileFriendJPARepository;
    }

    @Transactional
    @Override
    public ProfileVo save(ProfileDTO profileDTO){
        Profile profile = profileDTOMapper.getEntityFromDto(profileDTO);
        profileJPARepository.save(profile);

        return profileVoMapper.getVoFromEntity(profile);
    }

    @Transactional
    @Override
    public ProfileVo updateProfile(ProfileUpdateDTO profileUpdateDTO){
        Profile profile = profileJPARepository.findByUuid(profileUpdateDTO.getUuid());

        if(profileUpdateDTO.getDescription() != null && !profileUpdateDTO.getDescription().isEmpty()){
            profile.setDescription(profileUpdateDTO.getDescription());
        }

        if(profileUpdateDTO.getFirstName() != null && !profileUpdateDTO.getFirstName().isEmpty()){
            profile.setFirstName(profileUpdateDTO.getFirstName());
        }

        if(profileUpdateDTO.getLastName() != null && !profileUpdateDTO.getLastName().isEmpty()){
            profile.setLastName(profileUpdateDTO.getLastName());
        }

        if(profileUpdateDTO.getHobbies() != null && !profileUpdateDTO.getHobbies().isEmpty()){
            Set<Hobby> hobbySet = new HashSet<>();
            for(HobbyVo hobbyVo: profileUpdateDTO.getHobbies()){
                hobbySet.add(this.hobbyService.getHobbyByUuid(hobbyVo.getUuid()));
            }
            profile.setHobbies(hobbySet);
            
        }

        profileJPARepository.save(profile);

        return profileVoMapper.getVoFromEntity(profile);
    }


    @Override
    public ProfileVo getByUserUuid(String userUuid){
        Profile profile = profileJPARepository.findByCustomUserUuid(userUuid);

        if(profile == null){
            return null;
        }

        return profileVoMapper.getVoFromEntity(profile);
    }


    @Override
    public List<ProfileVo> getAllByName(String profileUuid, String name, int limit, int offset){
        List<String> searchName = Arrays.asList(name.split(" "));

        List<ProfileVo> profileVoList;
        if(searchName.size() > 1){
            profileVoList = this.getAllByFirstNameOrLastName(profileUuid, searchName.get(0), searchName.get(1), limit, offset);
        }else{
            profileVoList = this.getAllByFirstNameOrLastName(profileUuid, searchName.get(0), "", limit, offset);
        }

        if(profileVoList.isEmpty()){
            if(searchName.size() > 1){
                profileVoList = this.getAllByFirstNameOrLastName(profileUuid, searchName.get(1), searchName.get(0), limit, offset);
            }else{
                profileVoList = this.getAllByFirstNameOrLastName(profileUuid, "", searchName.get(0), limit, offset);
            }
        }

        return profileVoList;
    }

    private List<ProfileVo> getAllByFirstNameOrLastName(String profileUuid, String firstName, String lastName, int limit, int offset){
        Pageable pageable = new ProfilePageRequester(limit, offset);

        Slice<Profile> profileSlice = profileJPARepository.findByFirstNameLikeOrLastNameLike(firstName, lastName, pageable);

        List<ProfileVo> profileVoList = profileSlice
                .getContent()
                .stream()
                .map(profileVoMapper::getVoFromEntity)
                .collect(Collectors.toList());

        List<ProfileVo> resultProfileList = new ArrayList<>();
        for(ProfileVo profileVo: profileVoList){
            ProfileFriend profileFriend = this.profileFriendJPARepository.findByFirstProfileUuidAndSecondProfileUuidAndAccepted(profileUuid, profileVo.getUuid(), true);
            ProfileFriend inverseProfileFriend = this.profileFriendJPARepository.findByFirstProfileUuidAndSecondProfileUuidAndAccepted(profileVo.getUuid(), profileUuid, true);

            if(profileFriend == null && inverseProfileFriend == null){
                resultProfileList.add(profileVo);
            }
        }

        return resultProfileList;
    }


    @Override
    public Profile getByUuid(String uuid){
        Profile profile = profileJPARepository.findByUuid(uuid);

        if(profile == null){
            return null;
        }

        return profile;
    }


}
