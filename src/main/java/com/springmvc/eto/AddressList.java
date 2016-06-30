package com.springmvc.eto;

import com.springmvc.entity.Address;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */

/**
 * 因为Springmvc不支持在方法中传List，所以用对象包装一下
 */
public class AddressList {

    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "AddressList{" +
                "addressList=" + addressList +
                '}';
    }
}
