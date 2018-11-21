package com.endurobee.enduro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.endurobee.enduro.rest.RetrofitConfig;
import com.endurobee.enduro.rest.dados.Dados;
import com.endurobee.enduro.rest.dados.DadosListAdapter;
import com.endurobee.enduro.rest.dados.DadosService;
import com.endurobee.enduro.rest.dados.Equipe;

import java.util.ArrayList;
import java.util.Collections;

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

    @Override
    protected void onStart() {
        super.onStart();
        atualizar();
    }

    private void repreencherLista(){
        Shared s = Shared.getInstance();

        ArrayList<Equipe> e = s.getEquipes();
        Collections.sort(e);

        equipesArray.clear();
        equipesArray.addAll(e);
        dadosAdapter.notifyDataSetChanged();

        Log.i("Debug", "repreencherLista: executado");
    }
    private void atualizar(){
        RetrofitConfig retrofitConfig = new RetrofitConfig();
        final DadosService serviceA = retrofitConfig.getDadosService();
        Call<Dados> request = serviceA.getDados();
        Toast.makeText(MainActivity.this,"Carregando lista", Toast.LENGTH_SHORT).show();
        request.enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {// executado quando resposta for recebida
                Dados resultados = response.body();
                if(resultados == null) Toast.makeText(MainActivity.this,"Ocorreu um erro",Toast.LENGTH_SHORT).show();
                else {
                    Shared s = Shared.getInstance();
                    s.setEquipes(resultados.getEquipes());
                    DadosListAdapter.setMax(resultados.getTotalCheckpoints());

                    repreencherLista();
                }
            }
            @Override
            public void onFailure(Call<Dados> call, Throwable t) {//executado quando houver erros
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"Erro de rede",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void atualizar(View view) {
        atualizar();
    }

    public void mostraAjuda(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder
                .setTitle("Ajuda")
                .setMessage("Este aplicativo permite visualizar em tempo real o estado das equipes no enduro.\n" +
                            "A barra de progresso mostra o estado da equipe em quantos checkpoints ela passou, os pontos dependem dos checkpoints mas também do cumprimento do tempo.\n" +
                            "Você pode ordenar por a maior pontuação primeiro ou o maior progresso primeiro.")
                .setPositiveButton("Entendi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        alertBuilder.create().show();
    }

    public void mudarOrdem(View view) {
        Shared s = Shared.getInstance();
        boolean ordem;
        boolean atualizar;

        //TODO diálogo
        if(s.getOrdem()) ordem=false;
        else ordem=true;
        ///////////////

        if(ordem!=s.getOrdem()) atualizar = true;
        else atualizar = false;

        Log.i("Debug", "mudarOrdem: antes era " + s.getOrdem() + " agora é " + ordem);
        s.setOrdem(ordem);

        if(atualizar && s.getCarregado()) repreencherLista();
    }
}
