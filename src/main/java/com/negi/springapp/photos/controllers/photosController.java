package com.negi.springapp.photos.controllers;

import com.negi.springapp.photos.models.photo;
import com.negi.springapp.photos.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
//photos controller
@RestController
public class photosController {

    private final PhotoService photoService;

    public photosController (PhotoService photoService){
        this.photoService = photoService;
    }// constructor injection

    // also a possiblity for injection of the service
    @Autowired
    private PhotoService photoService1;

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<photo> getPhotos(){
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public photo getPhoto(@PathVariable Integer id){
        photo photo = photoService.getById(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return  photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id){
        photoService.remove(id);
        //if ( photo == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        //return "Deleted id "+id;
    }

    @PostMapping("/photos")
    public photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        photo photo = photoService1.save(file.getOriginalFilename(),file.getBytes(), file.getContentType());
        return photo;
    }
}
