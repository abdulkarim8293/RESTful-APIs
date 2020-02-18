package com.abdulkarim.restfulapis.user_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User1 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("winning_rate")
    @Expose
    private String winning_rate;

    public String getName() {
        return name;
    }

    public String getWinning_rate() {
        return winning_rate;
    }
}
