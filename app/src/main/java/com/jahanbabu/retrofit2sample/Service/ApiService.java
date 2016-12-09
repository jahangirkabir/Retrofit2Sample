package com.jahanbabu.retrofit2sample.Service;

import com.jahanbabu.retrofit2sample.Model.PrayerTime;
import com.jahanbabu.retrofit2sample.Model.User;
import com.jahanbabu.retrofit2sample.Utils.Constants;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jahangirkabir on 2/7/16.
 */

public interface ApiService {
    @GET("dhaka.json")
    Call<PrayerTime> getPrayerTime();

    @GET("{cName}/weekly.json")
    Call<PrayerTime> getPrayerTime(@Path("cName") String path, @Query("key") String key);

    @FormUrlEncoded
    @POST("api/register")
    Call<User> updateUser(@Field("msisdn") String msisdn, @Field("userName") String userName);

    @Multipart
    @POST("api/send-comments/")
    Call<ResponseBody> postImage(@Part MultipartBody.Part image, @Part("comment") RequestBody comment);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build();

    Retrofit postRetrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL_POST) // Using this because base url is different for post
            .build();
}
