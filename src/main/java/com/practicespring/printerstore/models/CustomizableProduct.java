package com.practicespring.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CustomizableProduct extends Product {

    @OneToMany
    private List<RawProduct> customizable;

    public CustomizableProduct() {

    }

    public CustomizableProduct(List<RawProduct> customizable) {
        this.customizable = customizable;
    }

    public List<RawProduct> getCustomizable() {
        return customizable;
    }

    public void setCustomizable(List<RawProduct> customizable) {
        this.customizable = customizable;
    }
}
