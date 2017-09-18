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
public class Funcionario extends Pessoa{
    int cod_func;
    String matricula;
    String cargo;
    String setor;
   

    public Funcionario(int cod_func, String matricula, String cargo, String setor, int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        super(cpf, telefone, nome, data_nasc, rg, email);
        this.cod_func = cod_func;
        this.matricula = matricula;
        this.cargo = cargo;
        this.setor = setor;
      
    }
    
    public Funcionario(){}

    public int getCod_func() {
        return cod_func;
    }

    public void setCod_func(int cod_func) {
        this.cod_func = cod_func;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }   
    
}
