package com.mohsintech.mohsin.photos_clone;

public class Photo {

    private Integer id;

    private String fileName;

    public Photo(){

    }

    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
