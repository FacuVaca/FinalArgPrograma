/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author ACER
 */
public class Seguimiento {

    private int idSeguimiento;
    private Paciente paciente;
    private LocalDate fecha;
    private double medidaPecho, medidaCintura, medidaCadera;
    private double peso;
    private int idDieta;
    public Seguimiento() {
    }

    public Seguimiento(Paciente paciente, LocalDate fecha, double medidaPecho, double medidaCintura, double medidaCadera, double peso) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.medidaPecho = medidaPecho;
        this.medidaCintura = medidaCintura;
        this.medidaCadera = medidaCadera;
        this.peso = peso;
    }
    public Seguimiento(Paciente paciente, LocalDate fecha, double medidaPecho, double medidaCintura, double medidaCadera, double peso,int idDieta) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.medidaPecho = medidaPecho;
        this.medidaCintura = medidaCintura;
        this.medidaCadera = medidaCadera;
        this.peso = peso;
        this.idDieta=idDieta;
    }
    public Seguimiento(int idSeguimiento, Paciente paciente, LocalDate fecha, double medidaPecho, double medidaCintura, double medidaCadera, double peso) {
        this.idSeguimiento = idSeguimiento;
        this.paciente = paciente;
        this.fecha = fecha;
        this.medidaPecho = medidaPecho;
        this.medidaCintura = medidaCintura;
        this.medidaCadera = medidaCadera;
        this.peso = peso;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMedidaPecho() {
        return medidaPecho;
    }

    public void setMedidaPecho(double medidaPecho) {
        this.medidaPecho = medidaPecho;
    }

    public double getMedidaCintura() {
        return medidaCintura;
    }
    public void setMedidaCintura(double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public double getMedidaCadera() {
        return medidaCadera;
    }
    public void setMedidaCadera(double medidaCadera) {
        this.medidaCadera = medidaCadera;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public int getIdDieta(){
        return idDieta;
    }
    public void setIdDieta(int idDieta){
    this.idDieta=idDieta;
    }
    @Override
    public String toString() {
        return idSeguimiento + ", " + paciente;
    }

}
