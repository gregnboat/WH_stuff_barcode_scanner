package com.example.scurfid6;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer2 {
    private static final String baseURL = "http://portal.scu.co.id:1881/greg/";
    private static Retrofit retro2;

    public static Retrofit connectRetrofit() {
        if (retro2 == null){
            retro2 = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retro2;
    }
}