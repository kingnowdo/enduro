package com.endurobee.enduro.rest.dados;

import com.endurobee.enduro.Shared;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipe implements Comparable<Equipe>{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("checkpoints")
    @Expose
    private Integer checkpoints;
    @SerializedName("pontos")
    @Expose
    private Integer pontos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(Integer checkpoints) {
        this.checkpoints = checkpoints;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }



    // Sortamento /////////////////////////////////////////////////
    @Override
    public int compareTo(Equipe o) {
        Shared s = Shared.getInstance();
        if(s.getOrdem()) return compareP(o,true);
        else return compareC(o,true);
    }
    private int compareP(Equipe o, boolean e){
        if(this.getPontos() > o.getPontos()) return -1;
        else if(this.getPontos() < o.getPontos()) return 1;
        else {
            if(e){
                return compareC(o,false);
            }
        }
        return 0;
    }
    private int compareC(Equipe o, boolean e){
        if(this.getCheckpoints() > o.getCheckpoints()) return -1;
        else if(this.getCheckpoints() < o.getCheckpoints()) return 1;
        else {
            if(e){
                return compareP(o,false);
            }
        }
        return 0;
    }

}
