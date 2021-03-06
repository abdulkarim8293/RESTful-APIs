package com.abdulkarim.restfulapis;

import com.abdulkarim.restfulapis.user_model.Albums;
import com.abdulkarim.restfulapis.user_model.Comment;
import com.abdulkarim.restfulapis.user_model.Post;
import com.abdulkarim.restfulapis.user_model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("users")
    Call<List<User>> getAllUsers();

    @GET("posts")
    Call<List<Post>> getAllPosts();

    @GET("comments")
    Call<List<Comment>> getAllComments();

    @GET("albums")
    Call<List<Albums>> getAllAlbums();

}
