package com.mohsintech.mohsin.photos_clone;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/")
    public String helloworld(){
        return "Hello World!";
    }

    //Returning all photos
    @GetMapping("/photos")
    public Iterable<Photo> get(){
        return photoService.getPhotos();
    }

    //Return one photo by id
    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable Integer id){
        return photoService.getPhoto(id);
    }

    //Delete a photo
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id){
        photoService.deletePhoto(id);
    }

    //Add a photo
    @PostMapping("/photo")
    public void post(@RequestPart("data") MultipartFile file) throws IOException {
        photoService.savePhoto(file.getOriginalFilename(),file.getContentType(),file.getBytes());
    }


}
