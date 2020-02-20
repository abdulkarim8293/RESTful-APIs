package com.abdulkarim.restfulapis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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
