package com.endurobee.enduro;

import android.util.Log;

import com.endurobee.enduro.rest.dados.Equipe;

import java.util.ArrayList;

public class Shared {

    private static Shared instance = new Shared();

    private ArrayList<Equipe> equipes;
    private boolean ordem = true;
    private boolean carregado = false;

    private Shared(){}

    public static Shared getInstance() {
        return instance;
    }

    public ArrayList<Equipe> getEquipes() {
        if(equipes == null || equipes.size()<=0) Log.w("Debug","getEquipes: Retornando array vazio");
        return equipes;
    }
    public void setEquipes(ArrayList<Equipe> equipes) {
        if(equipes!=null) {
            this.equipes = equipes;
            this.carregado = true;
        }
        else Log.w("debug", "setEquipes: array vazio, não setado");
    }

    /**
     * Ordem
     * @return true pontos mais importante, false checkpoint mais importante
     */
    public boolean getOrdem() {
        return ordem;
    }
    /**
     * Ordem
     * @param ordem true pontos mais importante, false checkpoint mais importante
     */
    public void setOrdem(boolean ordem) {
        this.ordem = ordem;
    }

    public boolean getCarregado(){
        return this.carregado;
    }
}
