package com.example.scurfid6.apihelper;

public class UtilsAPI {

    public static final String BASE_URL_API = "http://portal.scu.co.id:1881/greg/";

    // Declaring Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
