/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Duenio;
import com.mycompany.peluqueriacanina.logic.Mascota;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loow3
 */
public class ControladoraPersistencia {
    MascotaJpaController mascotaJpa = new MascotaJpaController();
    DuenioJpaController duenioJpa = new DuenioJpaController();
    
    public void crearDuenio(Duenio duenio){
        duenioJpa.create(duenio);
    }
    
    public void borrarDuenio(int id){
        try {
            duenioJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editDuenio(Duenio duenio){
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Duenio> allDuenios(){
        List<Duenio> list = duenioJpa.findDuenioEntities();
        ArrayList<Duenio> arraylist = new ArrayList<Duenio>(list);
        return arraylist;
    }
    
    public Duenio findDuenio(int id){
        return duenioJpa.findDuenio(id);
    }
    
    public void crearMascota(Mascota mascota){
        mascotaJpa.create(mascota);
    }
    
    public void borrarMascota(int id){
        try {
            mascotaJpa.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editMascota(Mascota mascota){
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Mascota> allMascotas(){
        List<Mascota> list = mascotaJpa.findMascotaEntities();
        ArrayList<Mascota> arraylist = new ArrayList<Mascota>(list);
        return arraylist;
    }
    
    public Mascota findMascota(int id){
        return mascotaJpa.findMascota(id);
    }
}
