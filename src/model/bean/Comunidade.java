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
public class Comunidade extends Pessoa{
    int cod_comunidade;
    String endereco;

    public Comunidade(int cod_comunidade, String endereco, int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        super(cpf, telefone, nome, data_nasc, rg, email);
        this.cod_comunidade = cod_comunidade;
        this.endereco = endereco;
    }
  
    public Comunidade(){}
    public int getCod_comunidade() {
        return cod_comunidade;
    }

    public void setCod_comunidade(int cod_comunidade) {
        this.cod_comunidade = cod_comunidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
