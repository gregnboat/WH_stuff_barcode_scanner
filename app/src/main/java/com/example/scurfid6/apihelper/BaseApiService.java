package com.example.scurfid6.apihelper;

import com.example.scurfid6.ResponseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login/")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @GET("retreive.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("register/")
    Call<ResponseModel> ardCreateData(
            @Field("fullname") String name,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("user_id") int id
    );

    @FormUrlEncoded
    @POST("get.php")
    Call<ResponseModel> ardGetData(
            @Field("user_id") int id
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdateData(
            @Field("user_id") int id,
            @Field("fullname") String name,
            @Field("username") String username,
            @Field("password") String password
    );
}
