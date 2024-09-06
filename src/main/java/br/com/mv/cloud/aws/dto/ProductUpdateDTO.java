package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.model.Manufacturer;
import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;

public class ProductUpdateDTO {
    private String name;
    private String model;
    private BigDecimal price;
    private ColorEnum color;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String name, String model, BigDecimal price, ColorEnum color) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public ColorEnum getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}

