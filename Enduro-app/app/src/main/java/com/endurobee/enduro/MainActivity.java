package com.endurobee.enduro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.endurobee.enduro.rest.RetrofitConfig;
import com.endurobee.enduro.rest.dados.Dados;
import com.endurobee.enduro.rest.dados.DadosListAdapter;
import com.endurobee.enduro.rest.dados.DadosService;
import com.endurobee.enduro.rest.dados.Equipe;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private ArrayList<Equipe> equipesArray = new ArrayList<>();
    private DadosListAdapter dadosAdapter = new DadosListAdapter(this,equipesArray);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView cidadesList = findViewById(R.id.lista);
        cidadesList.setAdapter(dadosAdapter);
    }

    public void atualizar(View view) {
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        final DadosService serviceA = retrofitConfig.getDadosService();
        Call<Dados> request = serviceA.getDados();
        Toast.makeText(MainActivity.this,"Carregando lista", Toast.LENGTH_SHORT).show();
        request.enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {// executado quando resposta for recebida
                Dados resultados = response.body();
                equipesArray.clear();
                equipesArray.addAll(resultados.getEquipes());
                dadosAdapter.notifyDataSetChanged();
                if(resultados == null) Toast.makeText(MainActivity.this,"Ocorreu um erro",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Dados> call, Throwable t) {//executado quando houver erros
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"Erro de rede",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
