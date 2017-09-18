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
public class Func_comum extends Funcionario{
    int cod_func_com;
    String tipo;

    public Func_comum(int cod_func_com, String tipo, int cod_func, String matricula, String cargo, String setor, int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        super(cod_func, matricula, cargo, setor, cpf, telefone, nome, data_nasc, rg, email);
        this.cod_func_com = cod_func_com;
        this.tipo = tipo;
    }
    public Func_comum(){}
    public int getCod_func_com() {
        return cod_func_com;
    }

    public void setCod_func_com(int cod_func_com) {
        this.cod_func_com = cod_func_com;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
