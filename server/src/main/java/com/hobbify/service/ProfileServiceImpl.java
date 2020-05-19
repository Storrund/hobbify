package com.hobbify.service;

import com.hobbify.model.Profile;
import com.hobbify.repository.ProfileJPARepository;
import com.hobbify.repository.ProfilePageRequester;
import com.hobbify.service.dto.ProfileDTO;
import com.hobbify.service.dto.ProfileDTOMapper;
import com.hobbify.service.vo.ProfileVo;
import com.hobbify.service.vo.ProfileVoMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileJPARepository profileJPARepository;
    private final ProfileDTOMapper profileDTOMapper;
    private final ProfileVoMapper profileVoMapper;

    public ProfileServiceImpl(
            ProfileJPARepository profileJPARepository,
            ProfileDTOMapper profileDTOMapper,
            ProfileVoMapper profileVoMapper){
        this.profileJPARepository = profileJPARepository;
        this.profileDTOMapper = profileDTOMapper;
        this.profileVoMapper = profileVoMapper;
    }

    @Transactional
    @Override
    public ProfileVo save(ProfileDTO profileDTO){
        Profile profile = profileDTOMapper.getEntityFromDto(profileDTO);
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
    public List<ProfileVo> getAllByName(String name, int limit, int offset){
        List<String> searchName = Arrays.asList(name.split(" "));

        List<ProfileVo> profileVoList;
        if(searchName.size() > 1){
            profileVoList = this.getAllByFirstNameOrLastName(searchName.get(0), searchName.get(1), limit, offset);
        }else{
            profileVoList = this.getAllByFirstNameOrLastName(searchName.get(0), "", limit, offset);
        }

        if(profileVoList.isEmpty()){
            if(searchName.size() > 1){
                profileVoList = this.getAllByFirstNameOrLastName(searchName.get(1), searchName.get(0), limit, offset);
            }else{
                profileVoList = this.getAllByFirstNameOrLastName("", searchName.get(0), limit, offset);
            }
        }

        return profileVoList;
    }

    private List<ProfileVo> getAllByFirstNameOrLastName(String firstName, String lastName, int limit, int offset){
        Pageable pageable = new ProfilePageRequester(limit, offset);

        Slice<Profile> profileSlice = profileJPARepository.findByFirstNameLikeOrLastNameLike(firstName, lastName, pageable);

        List<ProfileVo> profileVoList = profileSlice
                .getContent()
                .stream()
                .map(profileVoMapper::getVoFromEntity)
                .collect(Collectors.toList());

        return profileVoList;
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
