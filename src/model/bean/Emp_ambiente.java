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
public class Emp_ambiente {
    int cod_emp_amb;
    Date data;
    int matricula;
    int cod_func_com;
    int numero;

    public Emp_ambiente(int cod_emp_amb, Date data, int matricula, int cod_func_com, int numero) {
        this.cod_emp_amb = cod_emp_amb;
        this.data = data;
        this.matricula = matricula;
        this.cod_func_com = cod_func_com;
        this.numero = numero;
    }
    public Emp_ambiente(){}
    public int getCod_emp_amb() {
        return cod_emp_amb;
    }

    public void setCod_emp_amb(int cod_emp_amb) {
        this.cod_emp_amb = cod_emp_amb;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCod_func_com() {
        return cod_func_com;
    }

    public void setCod_func_com(int cod_func_com) {
        this.cod_func_com = cod_func_com;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
