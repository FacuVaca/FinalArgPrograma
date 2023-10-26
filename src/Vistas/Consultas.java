
package Vistas;

import AccesoADatos.DietaComidaData;
import AccesoADatos.DietaData;
import AccesoADatos.PacienteData;
import AccesoADatos.SeguimientoData;
import Entidades.Comida;
import Entidades.Dieta;
import Entidades.Paciente;
import Entidades.Seguimiento;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Consultas extends javax.swing.JInternalFrame {

    
    private DefaultTableModel tablaModelo = new DefaultTableModel();
    private DefaultTableModel tablaComidaModelo = new DefaultTableModel();
    public boolean isCellEditable(int f, int c) {
        return true;
    }
    
    
    public Consultas() {
        initComponents();
        armarCabecera();
        armarDietaCabecera();
        cargarDietaCombo();
        cargarComboPaciente();
    }

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaComidasDieta = new javax.swing.JTable();
        dietaCombo = new javax.swing.JComboBox<>();
        caloBuscador = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaPacientes = new javax.swing.JTable();
        jRCumplido = new javax.swing.JRadioButton();
        jRNoCumplido = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboPaciente = new javax.swing.JComboBox<>();
        imcInicial = new javax.swing.JTextField();
        imcUltimaFecha = new javax.swing.JTextField();
        imcFinal = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(62, 168, 132));
        setMaximumSize(new java.awt.Dimension(1144, 768));
        setMinimumSize(new java.awt.Dimension(1144, 768));
        setPreferredSize(new java.awt.Dimension(1144, 768));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(62, 168, 132));

        jTabbedPane1.setBackground(new java.awt.Color(45, 132, 103));

        jPanel3.setBackground(new java.awt.Color(62, 168, 132));

        jTablaComidasDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTablaComidasDieta);

        dietaCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dietaComboItemStateChanged(evt);
            }
        });

        caloBuscador.setText("0");

        jToggleButton1.setText("Buscar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Buscador de comidas por calorias");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setText("Uso: Seleccione una dieta para ver las comidas contenidas en ella o ingrese una cantidad de calorias para ver comidas con una menor cantidad ingresada");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Contenido de dietas");

        jLabel13.setForeground(new java.awt.Color(242, 242, 242));
        jLabel13.setText("menor o igual a");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dietaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(caloBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(267, 267, 267))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)))
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dietaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caloBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta de contenido de dietas", jPanel3);

        jPanel2.setBackground(new java.awt.Color(62, 168, 132));

        jTablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaPacientes);

        jRCumplido.setForeground(new java.awt.Color(242, 242, 242));
        jRCumplido.setText("Obetivo Cumplido");
        jRCumplido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRCumplidoActionPerformed(evt);
            }
        });

        jRNoCumplido.setForeground(new java.awt.Color(242, 242, 242));
        jRNoCumplido.setText("Objetivo no cumplido");
        jRNoCumplido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRNoCumplidoActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Historial");

        jLabel5.setText("Uso: Seleccione una de las dos opciones para ver que pacientes han o no han llegado a su objetivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jRCumplido)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRNoCumplido))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel5)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRCumplido)
                    .addComponent(jRNoCumplido))
                .addGap(93, 93, 93)
                .addComponent(jButton1)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historial de objetivos", jPanel2);

        jPanel4.setBackground(new java.awt.Color(62, 168, 132));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Calculo IMC");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("Seleccione un Paciente");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("IMC Ultima Fecha");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("IMC Inicial");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(242, 242, 242));
        jLabel10.setText("IMC Final Deseado");

        ComboPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPacienteActionPerformed(evt);
            }
        });

        imcInicial.setEditable(false);
        imcInicial.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        imcUltimaFecha.setEditable(false);
        imcUltimaFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        imcFinal.setEditable(false);
        imcFinal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imcInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imcUltimaFecha)
                            .addComponent(imcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(433, 433, 433)
                        .addComponent(jLabel12)))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(78, 78, 78)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ComboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(imcInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(imcUltimaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(imcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(553, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta IMC", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRCumplidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRCumplidoActionPerformed
   
        limpiarTabla();
        
        CargarCumplidos();
    }//GEN-LAST:event_jRCumplidoActionPerformed

    private void jRNoCumplidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRNoCumplidoActionPerformed
      limpiarTabla();
      
      CargarNoCumplidos();
    }//GEN-LAST:event_jRNoCumplidoActionPerformed

    private void dietaComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dietaComboItemStateChanged
        // TODO add your handling code here:
        if (dietaCombo.getSelectedIndex()==0){
            limpiarTablaComidas();
        } else {
            limpiarTablaComidas();
            Dieta d=(Dieta) dietaCombo.getSelectedItem();
            if(d!=null){
                DietaComidaData dcd=new DietaComidaData();
                for(Comida diet:dcd.ListarComidas(d.getIdDieta())){
                    String nombre=diet.getNombre();
                    String tipo=diet.getTipoComida();
                    int calo=diet.getCantidadCalorias();
                    tablaComidaModelo.addRow(new Object [] {nombre,tipo,calo});
                }
            }
        }

    }//GEN-LAST:event_dietaComboItemStateChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (caloBuscador.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Error: Campo Vacio");
        } else {
            if(dietaCombo.getSelectedIndex()==0) {
            limpiarTablaComidas();
            SeguimientoData sd=new SeguimientoData();
            for(Comida diet:sd.ComidasMenosDeCalo(Integer.parseInt(caloBuscador.getText()))){
                String nombre=diet.getNombre();
                String tipo=diet.getTipoComida();
                int calo=diet.getCantidadCalorias();
                tablaComidaModelo.addRow(new Object [] {nombre,tipo,calo});
            }
        } else {
            limpiarTablaComidas();
            dietaCombo.setSelectedIndex(0);
            SeguimientoData sd=new SeguimientoData();
            for(Comida diet:sd.ComidasMenosDeCalo(Integer.parseInt(caloBuscador.getText()))){
                String nombre=diet.getNombre();
                String tipo=diet.getTipoComida();
                int calo=diet.getCantidadCalorias();
                tablaComidaModelo.addRow(new Object [] {nombre,tipo,calo});

            }
        }
        }

       
        
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ComboPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPacienteActionPerformed
       try{
        Paciente paciente=(Paciente) ComboPaciente.getSelectedItem();
        SeguimientoData segData = new SeguimientoData();
        int idPaciente=paciente.getIdPaciente();
        
        if(segData.CalcularIMCInicial(idPaciente)==0 ||segData.CalcularIMCFinal(idPaciente)==0 || segData.CalcularIMCFinalObtenido(idPaciente)==0){
            JOptionPane.showMessageDialog(null, "falta ingresar el peso de una dieta o seguimiento al paciente ");
        }else{
           imcInicial.setText(segData.CalcularIMCInicial(idPaciente)+"");
        imcFinal.setText(segData.CalcularIMCFinal(idPaciente)+"");
        imcUltimaFecha.setText(segData.CalcularIMCFinalObtenido(idPaciente)+""); 
        }
        }catch(NullPointerException | HeadlessException  e){
            JOptionPane.showMessageDialog(null, "falta ingresar el peso de una dieta o seguimiento al paciente-"+ e.getMessage());
        }catch(Exception  e){
            JOptionPane.showMessageDialog(null, "falta ingresar el peso de una dieta o seguimiento al paciente-"+ e.getMessage());
        }
    }//GEN-LAST:event_ComboPacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Paciente> ComboPaciente;
    private javax.swing.JTextField caloBuscador;
    private javax.swing.JComboBox<Dieta> dietaCombo;
    private javax.swing.JTextField imcFinal;
    private javax.swing.JTextField imcInicial;
    private javax.swing.JTextField imcUltimaFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRCumplido;
    private javax.swing.JRadioButton jRNoCumplido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablaComidasDieta;
    private javax.swing.JTable jTablaPacientes;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

 private void armarCabecera(){
        tablaModelo.addColumn("Nombre");
        tablaModelo.addColumn("Dni");
        tablaModelo.addColumn("Peso Inicial");
        tablaModelo.addColumn("Peso Final");
        tablaModelo.addColumn("Tipo de dieta");
        tablaModelo.addColumn("Inicio de tratamiento");
        tablaModelo.addColumn(" Fin de tratamiento");
        
        jTablaPacientes.setModel(tablaModelo);
    }

 private void armarDietaCabecera(){
        tablaComidaModelo.addColumn("Nombre");
        tablaComidaModelo.addColumn("Tipo");
        tablaComidaModelo.addColumn("Calorias");
        
        jTablaComidasDieta.setModel(tablaComidaModelo);
    }
 private void limpiarTabla() {

        DefaultTableModel modelo = (DefaultTableModel) jTablaPacientes.getModel();
        modelo.setRowCount(0); // Limpia todas las filas de la tabla
        tablaModelo.fireTableDataChanged();

    }
  private void limpiarTablaComidas() {

        DefaultTableModel modeloComidas = (DefaultTableModel) jTablaComidasDieta.getModel();
        modeloComidas.setRowCount(0); // Limpia todas las filas de la tabla
        tablaComidaModelo.fireTableDataChanged();

    }

  private void CargarCumplidos (){
      
    if (jRCumplido.isSelected()) {
        jRNoCumplido.setSelected(false);
    DietaData dietaData = new DietaData();
    Dieta dieta = new Dieta();
    SeguimientoData seguimientoData = new SeguimientoData();
    Seguimiento seguimiento;

    List<Dieta> ListaDietas = new ArrayList<>(dietaData.obtenerDietas());

    for (Dieta diet : ListaDietas) {
        List<Paciente> pacientesCumplidos = new ArrayList<>();

        List<Paciente> ListaPacientes = new ArrayList<>(seguimientoData.ObjetivoCumplido(diet));

        for (Paciente Listap : ListaPacientes) {
            int idPaciente = Listap.getIdPaciente();

            if (idPaciente == diet.getPaciente().getIdPaciente()) {
                seguimiento = seguimientoData.ObtenerSeguimientoPorIDPaciente(idPaciente);

                int idSeguimiento = seguimiento.getIdSeguimiento();
                LocalDate fechaUltima = seguimientoData.encontrarFechaMasReciente(idSeguimiento);

                java.util.Date fechaUltimaDato = java.util.Date.from(fechaUltima.atStartOfDay(ZoneId.systemDefault()).toInstant());

                String Nombre = Listap.getNombre();
                
                int DNI = Listap.getDni();
                
                LocalDate fFinal = diet.getFechaFinal();
                
                java.util.Date FfinalDato = java.util.Date.from(fFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                
                LocalDate fInicial = diet.getFechaInicial();
                
                java.util.Date FinicialDato = java.util.Date.from(fInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
                
                double pesoInicial = diet.getPesoInicial();
                
                double pesoFinal = diet.getPesoFinal();
                
                String nombreDieta = diet.getNombre();


                tablaModelo.addRow(new Object[]{Nombre, DNI, pesoInicial, pesoFinal, nombreDieta, FfinalDato, FinicialDato, fechaUltima}); 
            }
        }
    }
}

     } 
        
private void CargarNoCumplidos() {
    
    if (jRNoCumplido.isSelected()) {
        jRCumplido.setSelected(false);
        DietaData dietaData = new DietaData();
        
        SeguimientoData seguimientoData = new SeguimientoData();
        

        List<Dieta> ListaDietas = new ArrayList<>(dietaData.obtenerDietas());
        

        for (Dieta diet : ListaDietas) {
            
            
            List<Paciente> ListaPacientes = new ArrayList<>(seguimientoData.ObjetivoNoCumplido(diet));

            for (Paciente Listap : ListaPacientes) {
                
                if (Listap.getIdPaciente() == diet.getPaciente().getIdPaciente()) {
                    
                    String Nombre = Listap.getNombre();
                    
                    int DNI = Listap.getDni();
                    
                    LocalDate fFinal = diet.getFechaFinal();
                    
                    java.util.Date FfinalDato = java.util.Date.from(fFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    
                    LocalDate fInicial = diet.getFechaInicial();
                    
                    java.util.Date FinicialDato = java.util.Date.from(fInicial.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    
                    double pesoInicial = diet.getPesoInicial();
                    
                    double pesoFinal = diet.getPesoFinal();
                    
                    String nombreDieta = diet.getNombre();
                    
                    
                    tablaModelo.addRow(new Object[]{Nombre, DNI, pesoInicial, pesoFinal, nombreDieta, FfinalDato, FinicialDato});
                    
                }
            }
        }
    }
}




    private void cargarDietaCombo(){
        DietaData dietaData  = new DietaData();    
        dietaCombo.addItem(null);
        for(Dieta diet:dietaData.obtenerDietas()){
            dietaCombo.addItem(diet);
        }
    }
    
       private void cargarComboPaciente() {
        PacienteData pacienteData = new PacienteData();
        for (Paciente pac : pacienteData.ListarPacientes()) {
            ComboPaciente.addItem(pac);
        }
    }
 }
 
