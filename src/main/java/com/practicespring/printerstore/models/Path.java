package com.practicespring.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Path {
    @Id
    private int id;
    private String path;
    private String httpMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
}
