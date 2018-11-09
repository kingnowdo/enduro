package com.endurobee.enduro.rest.dados;

import retrofit2.Call;
import retrofit2.http.GET;

import com.endurobee.enduro.rest.RetrofitConfig;

public interface DadosService {
    @GET("kingnowdo/enduro/master/dados.json")
    public Call<Dados> getDados();

}