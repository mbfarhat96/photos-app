package com.mohsintech.mohsin.photos_clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PhotoController {

    private Map<Integer,Photo> db = new HashMap<>(){{
        put(1, new Photo(1,"test.jpg"));
    }};

    @GetMapping("/")
    public String helloworld(){
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
        return db.values();
    }


}
