/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.PacienteData;
import AccesoADatos.SeguimientoData;
import Entidades.Paciente;
import Entidades.Seguimiento;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author ACER
 */
public class SeguimientoVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAtencion
     */
    public SeguimientoVista() {
       
        initComponents();
        
        cargarCombo();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jcPacientes = new javax.swing.JComboBox<>();
        jtPeso = new javax.swing.JTextField();
        jtCintura = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtCadera = new javax.swing.JTextField();
        jtPecho = new javax.swing.JTextField();
        jdFechaSeguimiento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(62, 168, 132));
        setMaximumSize(new java.awt.Dimension(1144, 768));
        setMinimumSize(new java.awt.Dimension(1144, 768));
        setPreferredSize(new java.awt.Dimension(1144, 768));

        jPanel1.setBackground(new java.awt.Color(62, 168, 132));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Seguimiento de consulta");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Paciente");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Peso");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Medidas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Fecha");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jcPacientes.setMaximumSize(new java.awt.Dimension(202, 25));
        jcPacientes.setMinimumSize(new java.awt.Dimension(202, 25));
        jcPacientes.setPreferredSize(new java.awt.Dimension(202, 25));

        jtPeso.setMaximumSize(new java.awt.Dimension(202, 25));
        jtPeso.setMinimumSize(new java.awt.Dimension(202, 25));
        jtPeso.setPreferredSize(new java.awt.Dimension(202, 25));
        jtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoActionPerformed(evt);
            }
        });

        jtCintura.setMaximumSize(new java.awt.Dimension(202, 25));
        jtCintura.setMinimumSize(new java.awt.Dimension(202, 25));
        jtCintura.setPreferredSize(new java.awt.Dimension(202, 25));

        jLabel6.setText("Cintura");

        jLabel7.setText("Cadera");

        jLabel8.setText("pecho");

        jtCadera.setMaximumSize(new java.awt.Dimension(202, 25));
        jtCadera.setMinimumSize(new java.awt.Dimension(202, 25));
        jtCadera.setPreferredSize(new java.awt.Dimension(202, 25));

        jtPecho.setMaximumSize(new java.awt.Dimension(202, 25));
        jtPecho.setMinimumSize(new java.awt.Dimension(202, 25));
        jtPecho.setPreferredSize(new java.awt.Dimension(202, 25));

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbBorrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(61, 61, 61))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtCadera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtPecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtCintura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jtPeso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdFechaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(224, 224, 224))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtCintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jtCadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jtPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdFechaSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(132, 132, 132)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jbModificar)
                    .addComponent(jbBorrar)
                    .addComponent(jButton1))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        guardarDatos();
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
      
        modificarSeguimiento();
        
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
   
        BorrarSeguimiento();
        
    }//GEN-LAST:event_jbBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<Paciente> jcPacientes;
    private com.toedter.calendar.JDateChooser jdFechaSeguimiento;
    private javax.swing.JTextField jtCadera;
    private javax.swing.JTextField jtCintura;
    private javax.swing.JTextField jtPecho;
    private javax.swing.JTextField jtPeso;
    // End of variables declaration//GEN-END:variables


 private void cargarCombo(){
        
        PacienteData pacienteData  = new PacienteData ();
        
        
           
           jcPacientes.addItem(null);
        for(Paciente pac:pacienteData.ListarPacientes()){
            jcPacientes.addItem(pac);
        }


 }
 
 
 
 private void guardarDatos(){
     
     if(jcPacientes.getSelectedIndex()>=0){
         
         Paciente p = (Paciente) jcPacientes.getSelectedItem();
         
         Double Peso= Double.parseDouble(jtPeso.getText());
         Double Cintura= Double.parseDouble(jtCintura.getText());
         Double pecho= Double.parseDouble(jtPecho.getText());
         Double cadera= Double.parseDouble(jtCadera.getText());
         LocalDate fecha= jdFechaSeguimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         
         
         Seguimiento seguimiento = new Seguimiento(p,fecha,pecho,Cintura,cadera,Peso);
         
         SeguimientoData seguimientoData= new SeguimientoData();
         
         seguimientoData.AgregarSeguimiento(seguimiento);
         
     }
     
     
 }
 
 
 private void modificarSeguimiento(){
     
      if(jcPacientes.getSelectedIndex()>=0){
         
         Paciente p = (Paciente) jcPacientes.getSelectedItem();
         
         int idPaciente= p.getIdPaciente();
         
         Double Peso= Double.parseDouble(jtPeso.getText());
         Double Cintura= Double.parseDouble(jtCintura.getText());
         Double pecho= Double.parseDouble(jtPecho.getText());
         Double cadera= Double.parseDouble(jtCadera.getText());
         LocalDate fecha= jdFechaSeguimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      
      
       Seguimiento seguimiento = new Seguimiento(p,fecha,pecho,Cintura,cadera,Peso);
         
         SeguimientoData seguimientoData= new SeguimientoData();
         
         seguimientoData.modificarSeguimiento( idPaciente , seguimiento);
      
      
      }
     
     
 }
 
 private void BorrarSeguimiento(){
     
     if(jcPacientes.getSelectedIndex()>=0){
         
         Paciente p = (Paciente) jcPacientes.getSelectedItem();
     
         
         int idPaciente= p.getIdPaciente();
         
         
         
         Double Peso= Double.parseDouble(jtPeso.getText());
         Double Cintura= Double.parseDouble(jtCintura.getText());
         Double pecho= Double.parseDouble(jtPecho.getText());
         Double cadera= Double.parseDouble(jtCadera.getText());
         LocalDate fecha= jdFechaSeguimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      
      
       Seguimiento seguimiento = new Seguimiento(p,fecha,pecho,Cintura,cadera,Peso);
         
       int IdSeguimiento= seguimiento.getIdSeguimiento();
       
         
       SeguimientoData seguimientoData= new SeguimientoData();
         
         
         
         seguimientoData.eliminarSeguimientoPorId(IdSeguimiento);
     
     }
 }
 
}
