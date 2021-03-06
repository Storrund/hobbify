package com.hobbify.rest;


import com.hobbify.service.HobbyCategoryService;
import com.hobbify.service.HobbyService;
import com.hobbify.service.vo.HobbyCategoryVo;
import com.hobbify.service.vo.HobbyMetadataVo;
import com.hobbify.service.vo.HobbyVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/hobby/metadata", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyMetadataController {


    private HobbyService hobbyService;
    private HobbyCategoryService hobbyCategoryService;

    public HobbyMetadataController(HobbyService hobbyService,
                                   HobbyCategoryService hobbyCategoryService){
        this.hobbyService = hobbyService;
        this.hobbyCategoryService = hobbyCategoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getHobbiesMetadata() {
        List<HobbyVo> hobbyVoList = this.hobbyService.getAll();
        List<HobbyCategoryVo> hobbyCategoryVoList = this.hobbyCategoryService.getAll();
        Map<String, List<HobbyVo>> categoryToHobbiesMap = hobbyVoList.stream().collect(Collectors.groupingBy(HobbyVo::getHobbyCategoryUuid));

        HobbyMetadataVo hobbyMetadataVo = new HobbyMetadataVo();
        hobbyMetadataVo.setHobbyCategories(hobbyCategoryVoList);
        hobbyMetadataVo.setHobbies(categoryToHobbiesMap);

        return new ResponseEntity<>(hobbyMetadataVo, HttpStatus.CREATED);
    }
}
