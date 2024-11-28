
package com.mycompany.licoreria.igu;

import com.mycompany.logica.ControladoraLogica;
import com.mycompany.logica.Licoreria;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Registro extends javax.swing.JFrame {
    
    ControladoraLogica controlLog = new ControladoraLogica();


    public Registro() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicores = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Bebidas");

        tablaLicores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaLicores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLicores);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        
        
        if(tablaLicores.getRowCount() > 0){
            
            if(tablaLicores.getSelectedRow() != -1){
                
                int idLicores = (int) tablaLicores.getValueAt(tablaLicores.getSelectedRow(), 0);
                controlLog.borrarCargado(idLicores);
                
                mostrarMensaje("Se ha borrado el registro correctamente","Info","Borrado Exitoso");
                cargarBebidas();
           
            }else{
                mostrarMensaje("No se selecciono ningun registro", "Error","Error al eliminar");
            }
            
        }else{
            mostrarMensaje("No se encuentran registros","Error","Error al eliminar");
        }
        
        
        
        
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        cargarBebidas();
    }//GEN-LAST:event_formWindowOpened

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
        if(tablaLicores.getRowCount() > 0){
            
            if(tablaLicores.getSelectedRow() != -1){
                
         
                int idLicorModf = (int) tablaLicores.getValueAt(tablaLicores.getSelectedRow(), 0);
                Modificar modLicores = new Modificar(idLicorModf);
                
                modLicores.setVisible(true);
                modLicores.setLocationRelativeTo(null);
                this.dispose();
                
                
                
              
            }
        }
        
        
    }//GEN-LAST:event_btnModificarActionPerformed
    
    
    
    public void mostrarMensaje (String mensaje, String tipo, String titulo) {
       JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
   
   }  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLicores;
    // End of variables declaration//GEN-END:variables

    
    //Uso tabla default. Hago que no sea editable, armo titulos para agregarlos y se lo encajo a la tabla que arme primero.
    private void cargarBebidas() {
        
        DefaultTableModel modeloTabla = new DefaultTableModel(){
        
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
                  
        };
        
        String tabla[] = {"Id","Tipo","Marca","Cantidad","Gondola"};
        modeloTabla.setColumnIdentifiers(tabla);
        
   
        
        //Puedo usar List porque son todos obetos
        List<Licoreria> listaLicores = controlLog.traerLicores();
        
        if(listaLicores != null){
            for(Licoreria licorsitos:listaLicores){
                
                //Uso Object[] porque debo desglosar diferentes tipos de datos del objeto, como int y String.
                Object[] objetos = {licorsitos.getId(),licorsitos.getTipo(),licorsitos.getMarca(),licorsitos.getCantidad(),licorsitos.getGondola()};
                modeloTabla.addRow(objetos);
            }
            
        }
        
        
        tablaLicores.setModel(modeloTabla);
        
             
        
    }
    
    
}