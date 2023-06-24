package kh.edu.rupp.ite.onlineshop.api.model;

import com.google.gson.annotations.SerializedName;

public class ProductModel {

    private int id;

    private String sku;

    private String name;

    private String description;

    private int price;

    @SerializedName("image-url")
    private String imageUrl;

    private float rating;

    // setter and getter
    public void setId(int id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getRating() {
        return rating;
    }
}
