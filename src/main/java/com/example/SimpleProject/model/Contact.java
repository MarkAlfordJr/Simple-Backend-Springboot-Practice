package com.example.SimpleProject.model;

// 1 CREATE MODEL FOR API JSON DATA
public class Contact {
    // fields for data model from API
    private Integer id;
    private String name;
    private String phoneNumber;

    public Contact(){}

    // getter and setter for each field
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
