package org.alexandraavendano.printerstore.models;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return Objects.equals(getId(), image.getId()) && Objects.equals(getContent(), image.getContent()) && Objects.equals(getName(), image.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getName());
    }
}
