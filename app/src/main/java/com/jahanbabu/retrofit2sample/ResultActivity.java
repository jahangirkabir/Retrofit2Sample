package com.jahanbabu.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.jahanbabu.retrofit2sample.Adapter.PrayerAdapter;
import com.jahanbabu.retrofit2sample.Model.Item;
import com.jahanbabu.retrofit2sample.Model.PrayerTime;
import com.jahanbabu.retrofit2sample.Model.User;
import com.jahanbabu.retrofit2sample.Service.ApiService;
import com.jahanbabu.retrofit2sample.Utils.Constants;
import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jahangirkabir on 2/7/16.
 */

public class ResultActivity extends AppCompatActivity {
    TextView titleTextView;
    RecyclerView recyclerView;
    String requestType = "", message = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            requestType = intent.getStringExtra("type");
        }

        switch (requestType){
            case "getNormal":
                getRequestNormal();
                break;
            case "getWithQuery":
                getRequestWithQuery(Constants.CITY, Constants.API_KEY);
                break;
            case "postNormal":
                postRequestNormal(Constants.MSISDN, Constants.userName);
                break;
            case "postMultipart":
                postRequestMultipart(Constants.Image, Constants.comment);
                break;
        }
    }

    private void getRequestNormal() {
        ApiService service = ApiService.retrofit.create(ApiService.class);

        final Call<PrayerTime> prayerTimeCall = service.getPrayerTime();

        prayerTimeCall.enqueue(new Callback<PrayerTime>() {
            @Override
            public void onResponse(Call<PrayerTime> call, Response<PrayerTime> response) {
                message = response.body().getPrayerMethodName();
                Log.i(Constants.TAG, message);
                titleTextView.setText(message);

                recyclerView.setNestedScrollingEnabled(false);
                PrayerAdapter productsAdapter = new PrayerAdapter((ArrayList<Item>) response.body().getItems());
                recyclerView.setLayoutManager(new LinearLayoutManager(ResultActivity.this));
                recyclerView.setAdapter(productsAdapter);
            }

            @Override
            public void onFailure(Call<PrayerTime> call, Throwable t) {
                Log.e(Constants.TAG, "onFailure ---> " + t.toString());
            }
        });
    }

    private void getRequestWithQuery(String city, String apiKey) {
        ApiService service = ApiService.retrofit.create(ApiService.class);

        final Call<PrayerTime> prayerTimeCall = service.getPrayerTime(city, apiKey);

        prayerTimeCall.enqueue(new Callback<PrayerTime>() {
            @Override
            public void onResponse(Call<PrayerTime> call, Response<PrayerTime> response) {
                message = response.body().getPrayerMethodName();
                Log.i(Constants.TAG, message);
                Log.i(Constants.TAG, response.body().getItems().toString());
                titleTextView.setText(message);

                recyclerView.setNestedScrollingEnabled(false);
                PrayerAdapter productsAdapter = new PrayerAdapter((ArrayList<Item>) response.body().getItems());
                recyclerView.setLayoutManager(new LinearLayoutManager(ResultActivity.this));
                recyclerView.setAdapter(productsAdapter);

            }

            @Override
            public void onFailure(Call<PrayerTime> call, Throwable t) {
                Log.e(Constants.TAG, "onFailure ---> " + t.toString());
            }
        });
    }

    private void postRequestNormal(String msisdn, String userName) {
        ApiService service = ApiService.postRetrofit.create(ApiService.class);

        final Call<User> registerCall = service.updateUser(msisdn, userName);

        registerCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                message = "Message : " + response.body().getMessage() + "\n\nToken : " + response.body().getAccessToken();
                Log.i(Constants.TAG, message);
                titleTextView.setText(message);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(Constants.TAG, "onFailure ---> " + t.toString());
            }
        });
    }

    private void postRequestMultipart(String image, String userComment) {

        ApiService service = ApiService.postRetrofit.create(ApiService.class);

        File file = new File(Constants.Image); // Your File path

        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("image", file.getName(), reqFile);
        RequestBody comment = RequestBody.create(MediaType.parse("text/plain"), userComment);

        retrofit2.Call<okhttp3.ResponseBody> req = service.postImage(body, comment);
        req.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i(Constants.TAG, response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
