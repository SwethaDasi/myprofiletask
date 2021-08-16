package com.kgisl.myprofiletask.controller;

import java.util.List;

import com.kgisl.myprofiletask.entity.Myprofile;
import com.kgisl.myprofiletask.repository.MyprofileRepository;

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
public class MyprofileController {

    @Autowired
    private MyprofileRepository myprofileRepository;

    @GetMapping("/get")
    public @ResponseBody ResponseEntity<List<Myprofile>> all() {
        return new ResponseEntity<>(myprofileRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody Myprofile myprofile, UriComponentsBuilder ucBuilder) {
        myprofileRepository.save(myprofile);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(myprofile.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }
    
}
