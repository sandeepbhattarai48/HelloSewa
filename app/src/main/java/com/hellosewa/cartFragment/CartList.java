package com.hellosewa.cartFragment;

public class CartList {
    String image, imageTitle, imagePrice;

    public  CartList()
    {
    }
    public CartList(String image, String imageTitle, String imagePrice){
        this.image= image;
        this.imagePrice = imageTitle;
        this.imagePrice = imagePrice;

    }

    public String getImage() {
        return image;

    }

    public void setImage(String image){
        this.image= image;
    }
    public String getImageTitle() {
        return imageTitle;

    }

    public void setImageTitle(String imageTitle){
        this.imageTitle= imageTitle;
    }

    public String getImagePrice() {
        return imagePrice;

    }

    public void setImagePrice(String imagePrice){
        this.imagePrice= imagePrice;
    }



}

