/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author biank
 */
public class ListarEmp_Amb {
    public Emp_ambiente emp_ambiente;
    public Aluno aluno;
    public Func_comum f;
    public Ambiente ambiente;

    public ListarEmp_Amb(Emp_ambiente emp_ambiente, Aluno aluno, Ambiente ambiente, Func_comum f) {
        this.emp_ambiente = emp_ambiente;
        this.aluno = aluno;
        this.ambiente = ambiente;
        this.f = f;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Func_comum getF() {
        return f;
    }

    public void setF(Func_comum f) {
        this.f = f;
    }
    
     public ListarEmp_Amb(){}

    public Emp_ambiente getEmp_ambiente() {
        return emp_ambiente;
    }

    public void setEmp_ambiente(Emp_ambiente emp_ambiente) {
        this.emp_ambiente = emp_ambiente;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
     
     
    
}
