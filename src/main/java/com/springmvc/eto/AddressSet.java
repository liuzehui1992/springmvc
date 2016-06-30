package com.springmvc.eto;

import com.springmvc.entity.Address;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/29.
 */
//使用set绑定时，必须实例化对象，否则汇报异常
public class AddressSet {
    private Set<Address> addressSet = new HashSet<Address>();

    /***
     * 实例化三个对象
     * 否则会报InvalidPropertyException异常
     */
    public AddressSet(){
        addressSet.add(new Address());
        addressSet.add(new Address());
        addressSet.add(new Address());
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    @Override
    public String toString() {
        return "AddressSet{" +
                "addressSet=" + addressSet +
                '}';
    }
}
