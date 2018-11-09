package com.endurobee.enduro.rest.dados;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipe {

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

}
