package com.springmvc.entity;

/**
 * Created by Administrator on 2016/6/29.
 */
public class Address {
    private String number ; //门牌号
    private String street ; //街道

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
