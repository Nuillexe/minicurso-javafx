package com.example.interface_de_clientes.Models;

public class Cliente {

    private String telefone;
    private String nome;
    private int idade;

    public Cliente(String nome,String telefone, int idade) {
        this.telefone = telefone;
        this.nome = nome;
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return " Nome: " + nome + " | Idade: " + idade + " | Telefone: "+telefone+"\n";
    }
}
