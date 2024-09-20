package com.negi.springapp.photos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.In;

@Table("PHOTOS")
public class photo {

    @Id
    private Integer id;
    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;

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

    public photo(){}

    public String getFileName() {
        return fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
