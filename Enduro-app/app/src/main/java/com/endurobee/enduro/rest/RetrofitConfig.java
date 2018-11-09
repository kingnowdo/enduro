package com.endurobee.enduro.rest;

import com.endurobee.enduro.rest.dados.DadosService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    //public static final String TOKEN = ""; //Uma constante de TOKEN
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public DadosService getDadosService() {
        return this.retrofit.create(DadosService.class);
    }

}
