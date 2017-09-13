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
public class Aluno extends Pessoa{
   int matricula;
   String curso;
   int semestre;
   String turno;
   

    public Aluno(int matricula, String curso, int semestre, String turno, int cpf, int telefone, String nome, Date data_nasc, int rg, String email) {
        super(cpf, telefone, nome, data_nasc, rg, email);
        this.matricula = matricula;
        this.curso = curso;
        this.semestre = semestre;
        this.turno = turno;  
    }
    public Aluno(){}
    

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
