
package com.endurobee.enduro.rest.dados;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dados {

    @SerializedName("versao")
    @Expose
    private String versao;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("tempo")
    @Expose
    private String tempo;
    @SerializedName("iniciou")
    @Expose
    private String iniciou;
    @SerializedName("acabou")
    @Expose
    private String acabou;
    @SerializedName("equipes")
    @Expose
    private ArrayList<Equipe> equipes = null;

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getIniciou() {
        return iniciou;
    }

    public void setIniciou(String iniciou) {
        this.iniciou = iniciou;
    }

    public String getAcabou() {
        return acabou;
    }

    public void setAcabou(String acabou) {
        this.acabou = acabou;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }

}
