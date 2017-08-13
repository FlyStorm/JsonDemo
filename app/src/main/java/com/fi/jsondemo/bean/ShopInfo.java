package com.fi.jsondemo.bean;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/8/12 0012 12:24
 * 作用	      ${TODO}
 * <p/>
 * 版本       $$Rev$$
 * 更新者     $$Author$$
 * 更新时间   $$Date$$
 * 更新描述   ${TODO}
 */
public class ShopInfo {
    private int id;
    private String imagePath;
    private String name;
    private double price;

    public ShopInfo(int id, String imagePath, String name, double price) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
