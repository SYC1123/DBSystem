package com.example.dbsystem.Model;

public class Collection {
    private int palceId;//场地号
    private String collectionDate;//收藏日期
    private String imageURL;

    public Collection(int id, String date, String url) {
        this.collectionDate = date;
        this.imageURL = url;
        this.palceId = id;
    }

    public void setPalceId(int palceId) {
        this.palceId = palceId;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPalceId() {
        return palceId;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public String getImageURL() {
        return imageURL;
    }
}
