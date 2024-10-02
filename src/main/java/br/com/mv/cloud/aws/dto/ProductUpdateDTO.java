package br.com.mv.cloud.aws.dto;

import br.com.mv.cloud.aws.enums.ColorEnum;

import java.math.BigDecimal;

public class ProductUpdateDTO {
    private String productName;

    private String username;
    private String model;
    private BigDecimal price;
    private ColorEnum color;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String name, String username, String model, BigDecimal price, ColorEnum color) {
        this.productName = name;
        this.username = username;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public String getProductName() {
        return productName;
    }

    public String getUsername() {
        return username;
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

    public void setProductName(String productName) {
        this.productName = productName;
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

