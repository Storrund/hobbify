package com.hobbify.rest;

import com.hobbify.service.PostService;
import com.hobbify.service.dto.PostDTO;
import com.hobbify.service.vo.PostVo;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/post", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    private static final Logger logger = Logger.getLogger(PostController.class);

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> savePost(@RequestBody PostDTO postDTO) {
        PostVo profileDtoSaved = postService.save(postDTO);
        return new ResponseEntity<>(profileDtoSaved, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{hobbyUuid}/{profileUuid}/{limit}/{offset}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public @ResponseBody
    ResponseEntity<?> getLastByHobbyUuidAndProfileUuid(@PathVariable String hobbyUuid, @PathVariable String profileUuid, @PathVariable int limit, @PathVariable int offset) {
        List<PostVo> postVoList = this.postService.getLastByHobbyUuidAndProfileUuid(hobbyUuid, profileUuid, limit, offset);
        return new ResponseEntity<>(postVoList, HttpStatus.OK);
    }

}
