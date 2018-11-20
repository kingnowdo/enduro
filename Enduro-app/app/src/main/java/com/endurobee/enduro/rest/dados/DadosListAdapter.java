package com.endurobee.enduro.rest.dados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.endurobee.enduro.R;

import java.util.ArrayList;

public class DadosListAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Equipe> equipes;
    public static int max = 0;

    public DadosListAdapter(Context context, ArrayList<Equipe> arrayList){
        this.context = context;
        this.equipes = arrayList;
    }

    public static void setMax(int max) {
        DadosListAdapter.max = max;
    }

    @Override
    public int getCount() {
        return equipes.size();
    }
    @Override
    public Equipe getItem(int i) {
        return equipes.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Equipe dadosEquipes = (Equipe) this.getItem(i);

        View itemListView = LayoutInflater.from(this.context).inflate(R.layout.listview_adapter, viewGroup, false);

        TextView texto = itemListView.findViewById(R.id.item_list);
        ProgressBar barra = itemListView.findViewById(R.id.barraprogresso);

        texto.setText("   " + dadosEquipes.getNome() + " - " + dadosEquipes.getPontos() + " pontos");
        barra.setMax(max);
        barra.setProgress(dadosEquipes.getCheckpoints());

        return itemListView;
    }

}
