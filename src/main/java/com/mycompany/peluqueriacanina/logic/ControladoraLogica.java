package com.mycompany.peluqueriacanina.logic;

import com.mycompany.peluqueriacanina.persistence.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    ControladoraPersistencia control = new ControladoraPersistencia();
    
    public void crearDuenio(Duenio duenio){
        control.crearDuenio(duenio);
    }
    public void crearMascota(Mascota mascota){
        control.crearMascota(mascota);
    }
    public void updateDuenio(Duenio duenio){
        control.editDuenio(duenio);
    }

    public List<Mascota> traerMascotas() {
        return control.allMascotas();
    }

    public List<Duenio> traerDuenios() {
        return control.allDuenios();
    }
    public Duenio traerDuenio(int id){
        return control.findDuenio(id);
    }

    public void borrarDuenio(int id) {
        control.borrarDuenio(id);
    }

    public void borrarMascota(int id_mascota) {
        control.borrarMascota(id_mascota);
    }
}
    