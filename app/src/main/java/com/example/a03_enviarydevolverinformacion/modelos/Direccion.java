package com.example.a03_enviarydevolverinformacion.modelos;

import java.io.Serializable;

public class Direccion implements Serializable {
    private String calle;
    private String ciudad;
    private int numero;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, int numero) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numero=" + numero +
                '}';
    }
}
