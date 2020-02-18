package com.abdulkarim.restfulapis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.abdulkarim.restfulapis.user_model.Participant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private WebServices webServices;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        retrofit = RetrofitInstance.getInstance();

        webServices = retrofit.create(WebServices.class);

        Call<Participant> call = webServices.getAllUsers();

        call.enqueue(new Callback<Participant>() {
            @Override
            public void onResponse(Call<Participant> call, Response<Participant> response) {
                if (response.isSuccessful()){

                    textView.setText("Positin: 1.\nName: "+response.body().getUser1().getName()+"\nPoint: "+response.body().getUser1().getWinning_rate()
                            +"\n\nPosition: 2.\nName: " +response.body().getUser2().getName()+"\nPoint: "+response.body().getUser2().getWinning_rate()
                            +"\n\nPosition: 3.\nName: " +response.body().getUser3().getName()+"\nPoint: "+response.body().getUser3().getWinning_rate()
                            +"\n\nPosition: 4.\nName: " +response.body().getUser4().getName()+"\nPoint: "+response.body().getUser4().getWinning_rate()
                            +"\n\nPosition: 5.\nName: " +response.body().getUser5().getName()+"\nPoint: "+response.body().getUser5().getWinning_rate()
                            +"\n\nPosition: 6.\nName: " +response.body().getUser6().getName()+"\nPoint: "+response.body().getUser6().getWinning_rate()
                            +"\n\nPosition: 7.\nName: " +response.body().getUser7().getName()+"\nPoint: "+response.body().getUser7().getWinning_rate()
                            +"\n\nPosition: 8.\nName: " +response.body().getUser8().getName()+"\nPoint: "+response.body().getUser8().getWinning_rate());
                }
            }

            @Override
            public void onFailure(Call<Participant> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
