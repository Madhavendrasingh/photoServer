package com.negi.springapp.photos.controllers;

import com.negi.springapp.photos.models.photo;
import com.negi.springapp.photos.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class downloadController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
        byte[] data;
        photo photo = photoService.getById(id);
        data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);
        return  new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
