package com.kgisl.myprofiletask.controller;

import java.util.List;
import com.kgisl.myprofiletask.entity.MyProfile;
import com.kgisl.myprofiletask.repository.MyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/myprofiles")
public class MyProfileController {
    @Autowired
    private MyProfileRepository myProfileRepository; 
    
    @GetMapping("/get")
    public @ResponseBody ResponseEntity<List<MyProfile>> all() {
        return new ResponseEntity<>(myProfileRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody MyProfile myProfile, UriComponentsBuilder ucBuilder) {
        myProfileRepository.save(myProfile);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(myProfile.getProfileid()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}