/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author biank
 */
public class Pessoa {
    int cpf;
    int telefone;
    String nome;
    Date data_nasc;
    int rg;
    String email;

    public Pessoa(int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.rg = rg;
        this.email = email;
    }
    public Pessoa(){}

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
