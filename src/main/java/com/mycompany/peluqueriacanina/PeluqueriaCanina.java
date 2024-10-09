package com.mycompany.peluqueriacanina;

import com.mycompany.peluqueriacanina.gui.Bienvenida;
import com.mycompany.peluqueriacanina.logic.ControladoraLogica;
import com.mycompany.peluqueriacanina.logic.Duenio;
import com.mycompany.peluqueriacanina.logic.Mascota;

public class PeluqueriaCanina {

    public static void main(String[] args) {
       Bienvenida screenStartApp = new Bienvenida();
       screenStartApp.setVisible(true);
       screenStartApp.setLocationRelativeTo(null);
    }
}
