package com.mycompany.peluqueriacanina.logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Duenio implements Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        private int id;
        private String nombre;
        private String direccion;
        private String celular;
        @OneToOne
        @JoinColumn(name = "MASCOTA_ID")
        private Mascota mascota;

    public Duenio() {
    }

    public Duenio(int id, String nombre, String direccion, String celular, Mascota mascota) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.mascota = mascota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
       
        
}
