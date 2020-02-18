package com.abdulkarim.restfulapis;

import com.abdulkarim.restfulapis.user_model.Participant;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("participant.json")
    Call<Participant> getAllUsers();
}
