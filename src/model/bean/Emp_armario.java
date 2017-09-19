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
public class Emp_armario {
    int cod_emprestimo;
    Date entrega;
    Date devolucao;
    int matricula;
    int cod_armario;

    public Emp_armario(int cod_emprestimo, Date entrega, Date devolucao, int matricula, int cod_armario) {
        this.cod_emprestimo = cod_emprestimo;
        this.entrega = entrega;
        this.devolucao = devolucao;
        this.matricula = matricula;
        this.cod_armario = cod_armario;
    }
    public Emp_armario(){}
    public int getCod_emprestimo() {
        return cod_emprestimo;
    }

    public void setCod_emprestimo(int cod_emprestimo) {
        this.cod_emprestimo = cod_emprestimo;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCod_armario() {
        return cod_armario;
    }

    public void setCod_armario(int cod_armario) {
        this.cod_armario = cod_armario;
    }
    
    
}
