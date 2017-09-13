/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author biank
 */
public class Reserva {
    int cod_reserva;
    Date data;
    Time hora;
    Date data_evento;
    int cpf;
    int numero;

    public Reserva(int cod_reserva, Date data, Time hora, Date data_evento, int cpf, int numero) {
        this.cod_reserva = cod_reserva;
        this.data = data;
        this.hora = hora;
        this.data_evento = data_evento;
        this.cpf = cpf;
        this.numero = numero;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getData_evento() {
        return data_evento;
    }

    public void setData_evento(Date data_evento) {
        this.data_evento = data_evento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
