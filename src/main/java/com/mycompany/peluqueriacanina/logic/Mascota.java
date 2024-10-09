package com.mycompany.peluqueriacanina.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String raza;
    private String color;
    private Boolean alergico;
    private Boolean atencion_especial;
    private String observaciones;

    public Mascota(int id, String nombre, String raza, String color, Boolean alergico, Boolean atencion_especial, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
    }

    public Mascota() {
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getAlergico() {
        return alergico;
    }

    public void setAlergico(Boolean alergico) {
        this.alergico = alergico;
    }

    public Boolean getAtencion_especial() {
        return atencion_especial;
    }

    public void setAtencion_especial(Boolean atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
     }
