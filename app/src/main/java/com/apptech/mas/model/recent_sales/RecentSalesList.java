package com.apptech.mas.model.recent_sales;

public class RecentSalesList {
    String name;
    String qty;
    String amt;
    String img;

    public RecentSalesList(String name, String qty, String amt, String img) {
        this.name = name;
        this.qty = qty;
        this.amt = amt;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public String getAmt() {
        return amt;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "RecentSalesList{" +
                "name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", amt='" + amt + '\'' +
                ", img='" + img + '\'' +
                '}';
    }





}
