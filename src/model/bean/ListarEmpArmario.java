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
public class ListarEmpArmario {
    public Pessoa pessoa;
    public Aluno aluno ;
    public Armario armario;
    public Emp_armario emp_armario;

    public ListarEmpArmario(Pessoa pessoa, Aluno aluno, Armario armario, Emp_armario emp_armario) {
        this.pessoa = pessoa;
        this.aluno = aluno;
        this.armario = armario;
        this.emp_armario = emp_armario;
    }
   

    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Armario getArmario() {
        return armario;
    }

    public void setArmario(Armario armario) {
        this.armario = armario;
    }

    public Emp_armario getEmp_armario() {
        return emp_armario;
    }

    public void setEmp_armario(Emp_armario emp_armario) {
        this.emp_armario = emp_armario;
    }
    
    
    
}
