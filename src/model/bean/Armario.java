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
public class Armario {
    int cod_armario;
    int num_chave;
    int num_armario;
    int status;

   /* public Armario(int cod_armario, int num_chave, int num_armario, int status) {
        this.cod_armario = cod_armario;
        this.num_chave = num_chave;
        this.num_armario = num_armario;
        this.status = status;
    }*/

    public int getCod_armario() {
        return cod_armario;
    }

    public void setCod_armario(int cod_armario) {
        this.cod_armario = cod_armario;
    }

    public int getNum_chave() {
        return num_chave;
    }

    public void setNum_chave(int num_chave) {
        this.num_chave = num_chave;
    }

    public int getNum_armario() {
        return num_armario;
    }

    public void setNum_armario(int num_armario) {
        this.num_armario = num_armario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
