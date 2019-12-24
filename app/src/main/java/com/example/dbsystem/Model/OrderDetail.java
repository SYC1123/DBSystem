package com.example.dbsystem.Model;

public class OrderDetail {
    private int palceId;//场地号
    private String orderDate;//定场日期
    private int timeId;//时间段
    private float price;//价格
    private String name;//姓名
    private int statue;//预定状态

    public OrderDetail(int palceId, String orderDate, int timeId,float price,String name) {
        this.orderDate = orderDate;
        this.palceId = palceId;
        this.timeId = timeId;
        this.price=price;
        this.name=name;
    }

    public int getPalceId() {
        return palceId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getTimeId() {
        return timeId;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStatue() {
        return statue;
    }
}
