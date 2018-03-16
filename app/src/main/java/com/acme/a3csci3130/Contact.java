package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    //Variables declared that will be used to store business data
    public String uid;
    public String name;
    public int number;
    public String business;
    public String address;
    public String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Method that creates a new Contact object
     *
     * @param uid
     * @param name
     * @param number
     * @param business
     * @param address
     * @param province
     */
    public Contact(String uid, String name, int number, String business, String address, String province){
        this.uid = uid;
        this.name = name;
        this.number = number;
        this.business = business;
        this.address = address;
        this.province = province;
    }

    /**
     * Method that populates a HashMap view with each contacts individual info and returns
     * populated view
     *
     * @return result populated HashMap view
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number", number);
        result.put("business", business);
        result.put("address", address);
        result.put("province", province);


        return result;
    }
}
