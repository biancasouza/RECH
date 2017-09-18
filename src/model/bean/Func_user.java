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
public class Func_user extends Funcionario{
    int cod_user_func;
    String login;
    String senha;

    public Func_user(int cod_user_func, String login, String senha, int cod_func, String matricula, String cargo, String setor, int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        super(cod_func, matricula, cargo, setor, cpf, telefone, nome, data_nasc, rg, email);
        this.cod_user_func = cod_user_func;
        this.login = login;
        this.senha = senha;
    }
     public Func_user(){}
   
    public int getCod_user_func() {
        return cod_user_func;
    }

    public void setCod_user_func(int cod_user_func) {
        this.cod_user_func = cod_user_func;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
   
}
