package com.practicespring.printerstore.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    private String content;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
