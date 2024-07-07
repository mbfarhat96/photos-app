package com.mohsintech.mohsin.photos_clone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOS")
public class Photo {

    @Id
    private Integer id;

    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public Photo(){
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    //Validation the data before creating the photo object
    public void validatePhoto(){
        if (this.fileName.isBlank())
            throw new RuntimeException("Filename Can't be Null");

        if (this.id == null)
            throw new RuntimeException("The ID can't be Null");
    }


}
