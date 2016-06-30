package com.springmvc.entity;

/**
 * Created by Administrator on 2016/6/28.
 */
//身份证
public class IdCard {
    private String id ; //身份证号码
    private String address ; //地址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
