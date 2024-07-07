package com.mohsintech.mohsin.photos_clone;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> getPhotos(){
        return photoRepository.findAll();
    }

    public Photo getPhoto(Integer id){
        return photoRepository.findById(id).orElse(null);
    }

    public void savePhoto(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        photoRepository.save(photo);
    }

    public void deletePhoto(Integer id){
        photoRepository.deleteById(id);
    }
}
