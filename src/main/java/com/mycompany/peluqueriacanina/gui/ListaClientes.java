package com.mycompany.peluqueriacanina.gui;

import com.mycompany.peluqueriacanina.logic.ControladoraLogica;
import com.mycompany.peluqueriacanina.logic.Duenio;
import com.mycompany.peluqueriacanina.logic.Mascota;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaClientes extends javax.swing.JFrame {
    ControladoraLogica control = null;
    public ListaClientes() {
        control = new ControladoraLogica();
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JToggleButton();
        btnEliminar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tablaClientes.getRowCount() > 0){
           if(tablaClientes.getSelectedRow() != -1){
               int id_duenio = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
                ActualizarData screenActualizarData = new ActualizarData(id_duenio);
                screenActualizarData.setVisible(true);
                screenActualizarData.setLocationRelativeTo(null);
                this.dispose();
           }else{
                       mostrarOptionPane("No se selecciono un registro para borrar", "error", "Fallo de eliminacion");

           }
       }else{
                   mostrarOptionPane("No hay registros para eliminar", "error", "Fallo de eliminacion");

       }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       if(tablaClientes.getRowCount() > 0){
           if(tablaClientes.getSelectedRow() != -1){
               int id_duenio = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
                int id_mascota = Integer.parseInt(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 4)));
               control.borrarDuenio(id_duenio);
               control.borrarMascota(id_mascota);
               mostrarOptionPane("Eliminacion exitosa", "info", "Eliminacion de registro");
               cargarTabla();
           }else{
                       mostrarOptionPane("No se selecciono un registro para borrar", "error", "Fallo de eliminacion");

           }
       }else{
                   mostrarOptionPane("No hay registros para eliminar", "error", "Fallo de eliminacion");

       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void cargarTabla(){
        //defino el modelo que quiero que tenga la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            //fila y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        //nombres de las columnas
        String titulos[] = {"id", "nombre", "contacto", "nombre_mascota", "id_mascota", "raza", "color","es alergico", "trat. especial"};
        modeloTabla.setColumnIdentifiers(titulos);
        
        //cargar mascotas
        List<Mascota> listaMascotas = control.traerMascotas();
        List<Duenio> listaDuenios = control.traerDuenios();
        /*if(listaMascotas != null){
            for(Mascota mascota : listaMascotas){
                Object[] object =  {mascota.getId(), mascota.getNombre(), mascota.getRaza(), 
                    mascota.getColor(),mascota.getAlergico(), mascota.getAtencion_especial()};
                
                modeloTabla.addRow(object);
            }
        } */
        if(listaDuenios != null){
            for(Duenio  duenio : listaDuenios){
                Object[] object =  {duenio.getId(), duenio.getNombre(), duenio.getCelular(),duenio.getMascota().getNombre(), duenio.getMascota().getId(),
                    duenio.getMascota().getRaza(),duenio.getMascota().getColor(),duenio.getMascota().getAlergico(), duenio.getMascota().getAtencion_especial()};
                
                modeloTabla.addRow(object);
            }
        }
         
        tablaClientes.setModel(modeloTabla);

                
    }
    public void mostrarOptionPane(String message, String type, String title){
        JOptionPane optionPane = new JOptionPane(message);
        if(type.equals("info")){
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if(type.equals("error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
