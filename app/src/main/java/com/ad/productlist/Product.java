package com.ad.productlist;

/**
 * Created by Administrator on 2015/7/29.
 */
public class Product {
    private Long id;
    private String name;
    private Integer price;


    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
