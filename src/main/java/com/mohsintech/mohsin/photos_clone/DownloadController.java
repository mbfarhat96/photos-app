package com.mohsintech.mohsin.photos_clone;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class DownloadController {

   private PhotoService photoService;

   public DownloadController(PhotoService photoService){
       this.photoService = photoService;
   }

   @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
       Photo photo = photoService.getPhoto(id);
       if (photo == null)
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);

       byte[] data = photo.getData();
       HttpHeaders headers = new HttpHeaders();
       ContentDisposition builder = ContentDisposition
               .builder("attachment")
               .filename(photo.getFileName())
               .build();
       headers.setContentDisposition(builder);

       return new ResponseEntity<byte[]>(data,headers,HttpStatus.OK);
   }






}
