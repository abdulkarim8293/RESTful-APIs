package com.abdulkarim.restfulapis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.abdulkarim.restfulapis.user_model.Albums;
import com.abdulkarim.restfulapis.user_model.Comment;
import com.abdulkarim.restfulapis.user_model.Post;
import com.abdulkarim.restfulapis.user_model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private WebServices webServices;

    private TextView textView;
    private List<User> userList;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        userList = new ArrayList<>();

        retrofit = RetrofitInstance.getInstance();

        webServices = retrofit.create(WebServices.class);


        //getAllUsersInfo();
        //getAllPosts();
        //getAllPostComments();
        getAllAlbums();

    }

    private void getAllAlbums() {
        webServices.getAllAlbums().enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {

                if (response.isSuccessful()){
                    //Toast.makeText(MainActivity.this, ""+response.body().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllPostComments() {
        webServices.getAllComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, ""+response.body().get(0).getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getAllPosts() {
        webServices.getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Id : "+response.body().get(1).getId()
                            +"\nUser Id : "+response.body().get(1).getUserId()+"\nTitle : "+response.body().get(1).getTitle()+"\nBody : "+response.body().get(1).getBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllUsersInfo() {

        webServices.getAllUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){


                    userList = response.body();

                    Toast.makeText(MainActivity.this, ""+userList.size(), Toast.LENGTH_SHORT).show();

                    myAdapter = new MyAdapter(response.body(),MainActivity.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(myAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerViewId);
    }
}
