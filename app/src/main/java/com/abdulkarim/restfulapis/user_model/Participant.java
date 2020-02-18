package com.abdulkarim.restfulapis.user_model;

import com.google.gson.annotations.SerializedName;

public class Participant {


    @SerializedName("1")
    private User1 user1;

    @SerializedName("2")
    private User2 user2;

    @SerializedName("3")
    private User3 user3;

    @SerializedName("4")
    private User4 user4;

    @SerializedName("5")
    private User5 user5;

    @SerializedName("6")
    private User6 user6;

    @SerializedName("7")
    private User7 user7;

    @SerializedName("8")
    private User8 user8;

    public User1 getUser1() {
        return user1;
    }

    public User2 getUser2() {
        return user2;
    }

    public User3 getUser3() {
        return user3;
    }

    public User4 getUser4() {
        return user4;
    }

    public User5 getUser5() {
        return user5;
    }

    public User6 getUser6() {
        return user6;
    }

    public User7 getUser7() {
        return user7;
    }

    public User8 getUser8() {
        return user8;
    }
}
