package com.mohsintech.mohsin.photos_clone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhotoControllerGetUnitTest {

    PhotoController photoController;
    Photo photo;

    @BeforeEach
    void beforeEach(){
        photoController = new PhotoController();
    }
    //Testing POST controller method
    @Test
    @DisplayName("Should Create A Photo Object")
    void shouldCreateAPhotoObject(){
        Photo Photo = new Photo(1,"Test", new int[]{1, 2, 12});
        photoController.post(Photo);
        assertFalse(photoController.get().isEmpty());
        assertEquals(1,photoController.get().size());
    }

    //Testing GET controller method
    @Test
    void shouldReturnAPhotoObject(){
        photo = new Photo(1,"test.jpeg");
        photoController.post(photo);
        System.out.println(photoController.get(photo.getId()));
    }

    @Test
    void shouldThrowRuntimeExceptionForInvalidFileName(){
        assertThrows(RuntimeException.class, () ->{
            photo = new Photo(1,null);
        });
    }

    @Test
    void shouldThrowRuntimeExceptionForInvalidId(){
        assertThrows(RuntimeException.class, () ->{
            photo = new Photo(null,"test.jpeg");
        });
    }

    @Test
    void shouldDeletePhotoBasedOfId(){
        photo = new Photo(15,"test.jpeg");
        photoController.post(photo);
        System.out.println(photo.getId());
        assertFalse(photoController.get().isEmpty());
        photoController.delete(15);
        assertNull(photoController.get(15));
    }


}