package com.example.logonpf.fipe;

/**
 * Created by logonrm on 18/05/2017.
 */

public class Veiculo {

    private int codigo;
    private String nome;

    public Veiculo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
