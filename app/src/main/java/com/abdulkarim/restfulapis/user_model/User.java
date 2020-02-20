package com.abdulkarim.restfulapis.user_model;

public class User {
   private String id;
   private String name;
   private String username;
   private String email;
   private Address address;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
