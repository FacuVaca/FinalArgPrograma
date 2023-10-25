/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoADatos.Conexion;
import AccesoADatos.DietaData;
import AccesoADatos.PacienteData;
import AccesoADatos.SeguimientoData;
import Entidades.Dieta;
import Entidades.Paciente;
import Entidades.Seguimiento;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;


public class GestionDieta extends javax.swing.JInternalFrame {

       private Connection con = null;
    public GestionDieta() {
                con = Conexion.getconexion();
        initComponents();
        cargarCombo();
        cargarComboEliminar();
                // Agregar KeyListener al campo jtNombreDieta
        jtNombreDieta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isLetter(c)||c == ' ')) {
                    e.consume(); // Evitar la entrada de caracteres no válidos
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // No es necesario implementar este método, pero se debe proporcionar una implementación
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar este método, pero se debe proporcionar una implementación
            }
            
        });
        jtPesoInicial.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
        jtPesoFinal.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
        jtMedidaPecho.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
        
        jtMedidaCadera.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
        jtMedidaCintura.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
        jtAltura.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c) || c == '.')) {
                    ke.consume(); // Evitar la entrada de caracteres no válidos
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtNombreDieta = new javax.swing.JTextField();
        jtPesoInicial = new javax.swing.JTextField();
        jtPesoFinal = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtMedidaPecho = new javax.swing.JTextField();
        jtMedidaCintura = new javax.swing.JTextField();
        jtMedidaCadera = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtAltura = new javax.swing.JTextField();
        jbModificar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jdFechaInicio = new com.toedter.calendar.JDateChooser();
        jdFechaFinal = new com.toedter.calendar.JDateChooser();
        jcPacientes = new javax.swing.JComboBox<>();
        comboDieta = new javax.swing.JComboBox<>();
        jcPacientes1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1144, 768));
        setMinimumSize(new java.awt.Dimension(1144, 768));
        setPreferredSize(new java.awt.Dimension(1144, 768));

        jPanel1.setBackground(new java.awt.Color(62, 168, 132));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Consulta Inicial");

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Tipo de dieta");

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Paciente");

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Fecha de Inicio");

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Fecha Limite");

        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("Peso Inicial");

        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Peso Final Deseado");

        jtNombreDieta.setMaximumSize(new java.awt.Dimension(213, 25));
        jtNombreDieta.setMinimumSize(new java.awt.Dimension(213, 25));
        jtNombreDieta.setPreferredSize(new java.awt.Dimension(213, 25));

        jtPesoInicial.setMaximumSize(new java.awt.Dimension(213, 22));
        jtPesoInicial.setMinimumSize(new java.awt.Dimension(213, 22));
        jtPesoInicial.setPreferredSize(new java.awt.Dimension(213, 25));

        jtPesoFinal.setMaximumSize(new java.awt.Dimension(213, 22));
        jtPesoFinal.setMinimumSize(new java.awt.Dimension(213, 22));
        jtPesoFinal.setPreferredSize(new java.awt.Dimension(213, 25));

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtMedidaPecho.setMaximumSize(new java.awt.Dimension(213, 22));
        jtMedidaPecho.setMinimumSize(new java.awt.Dimension(213, 22));
        jtMedidaPecho.setPreferredSize(new java.awt.Dimension(213, 25));

        jtMedidaCintura.setMaximumSize(new java.awt.Dimension(213, 22));
        jtMedidaCintura.setPreferredSize(new java.awt.Dimension(213, 25));

        jtMedidaCadera.setMaximumSize(new java.awt.Dimension(213, 22));
        jtMedidaCadera.setMinimumSize(new java.awt.Dimension(213, 22));
        jtMedidaCadera.setPreferredSize(new java.awt.Dimension(213, 25));

        jLabel8.setText("Pecho");

        jLabel9.setText("Cintura");

        jLabel10.setText("Cadera");

        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("Medidas:");

        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("Altura");

        jtAltura.setMaximumSize(new java.awt.Dimension(213, 22));
        jtAltura.setPreferredSize(new java.awt.Dimension(213, 25));

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

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jdFechaInicio.setMaximumSize(new java.awt.Dimension(213, 22));
        jdFechaInicio.setMinimumSize(new java.awt.Dimension(213, 22));
        jdFechaInicio.setPreferredSize(new java.awt.Dimension(213, 25));

        jdFechaFinal.setMaximumSize(new java.awt.Dimension(213, 22));
        jdFechaFinal.setMinimumSize(new java.awt.Dimension(213, 22));
        jdFechaFinal.setPreferredSize(new java.awt.Dimension(213, 25));

        jcPacientes.setMaximumSize(new java.awt.Dimension(213, 22));
        jcPacientes.setMinimumSize(new java.awt.Dimension(213, 22));
        jcPacientes.setPreferredSize(new java.awt.Dimension(213, 25));

        jcPacientes1.setMaximumSize(new java.awt.Dimension(213, 22));
        jcPacientes1.setMinimumSize(new java.awt.Dimension(213, 22));
        jcPacientes1.setPreferredSize(new java.awt.Dimension(213, 25));
        jcPacientes1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcPacientes1ItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Eliminar Dieta de Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtMedidaCadera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbModificar))
                                        .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtMedidaPecho, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtMedidaCintura, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboDieta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcPacientes1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(146, 146, 146))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(230, 230, 230))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jcPacientes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jdFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jdFechaFinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtPesoInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtNombreDieta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(157, 157, 157))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jcPacientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBorrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtNombreDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5)))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jtMedidaPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtMedidaCintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtMedidaCadera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbModificar)
                        .addComponent(jbSalir))
                    .addComponent(jbGuardar))
                .addContainerGap(103, Short.MAX_VALUE))
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

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        agregar();
        recargarComboDieta();
    }//GEN-LAST:event_jbGuardarActionPerformed
    private void recargarComboDieta(){
        comboDieta.removeAllItems();
        Paciente pacientea=(Paciente) jcPacientes1.getSelectedItem();
        PacienteData dd=new PacienteData();
System.out.println(pacientea);
        for(Dieta d:dd.ListarDietas(pacientea.getIdPaciente(), pacientea)){
            comboDieta.addItem(d);
        }
    } 

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        ModificarDatos();
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        EliminarDatos();
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        cargarDatosDelPacienteSeleccionado();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcPacientes1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcPacientes1ItemStateChanged
        // TODO add your handling code here:
                comboDieta.removeAllItems();
        Paciente pacientea=(Paciente) jcPacientes1.getSelectedItem();
        PacienteData dd=new PacienteData();
System.out.println(pacientea);
        for(Dieta d:dd.ListarDietas(pacientea.getIdPaciente(), pacientea)){
            comboDieta.addItem(d);
        }
    }//GEN-LAST:event_jcPacientes1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Dieta> comboDieta;
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
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Paciente> jcPacientes;
    private javax.swing.JComboBox<Paciente> jcPacientes1;
    private com.toedter.calendar.JDateChooser jdFechaFinal;
    private com.toedter.calendar.JDateChooser jdFechaInicio;
    private javax.swing.JTextField jtAltura;
    private javax.swing.JTextField jtMedidaCadera;
    private javax.swing.JTextField jtMedidaCintura;
    private javax.swing.JTextField jtMedidaPecho;
    private javax.swing.JTextField jtNombreDieta;
    private javax.swing.JTextField jtPesoFinal;
    private javax.swing.JTextField jtPesoInicial;
    // End of variables declaration//GEN-END:variables


 private void cargarCombo() {
        PacienteData pacienteData = new PacienteData();
        for (Paciente pac : pacienteData.ListarPacientes()) {
            jcPacientes.addItem(pac);
        }
    }
 private void cargarComboEliminar() {
        PacienteData pacienteData = new PacienteData();
        for (Paciente s : pacienteData.ListarPacientes()) {
            jcPacientes1.addItem(s);
        }
    }
    
    
private void cargarDatosDelPacienteSeleccionado() {
        
    Seguimiento seguimientoL = null;
    Dieta dieta = null;
    Paciente p= null;
 
   if (jcPacientes.getSelectedIndex() >= 0) {
    p = (Paciente) jcPacientes.getSelectedItem();
    
    int id= p.getIdPaciente();

            DietaData dietaData = new DietaData();
            
            Dieta dietaIDDieta= (Dieta) comboDieta.getSelectedItem();
            
            int idDieta= dietaIDDieta.getIdDieta();
            
                dieta = dietaData.obtenerUnaDietaPorPersonaYidDieta(id,idDieta);

            if (dieta != null) {
                String nombre = dieta.getNombre();
                LocalDate fechaInicio = dieta.getFechaInicial();
                java.util.Date finicio = java.util.Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
                LocalDate fechaFinal = dieta.getFechaFinal();
                java.util.Date ffinal = java.util.Date.from(fechaFinal.atStartOfDay(ZoneId.systemDefault()).toInstant());

                Double pesoInicial = dieta.getPesoInicial();
                Double pesoFinal = dieta.getPesoFinal();
                Double altura = dieta.getAltura();
                
                   jtNombreDieta.setText(nombre);
                  jdFechaInicio.setDate(finicio);
                    jdFechaFinal.setDate(ffinal);
                    jtPesoInicial.setText(Double.toString(pesoInicial));
                    jtPesoFinal.setText(Double.toString(pesoFinal));
                    jtAltura.setText(Double.toString(altura));
                
            }
               
                SeguimientoData seguimientod = new SeguimientoData();
                 seguimientoL = seguimientod.ObtenerSeguimientoPorIDPaciente(id);
                
                System.out.println("Seguimiento" + seguimientoL);
          
                if (seguimientoL != null) {
                    Double pecho = seguimientoL.getMedidaPecho();
                    Double cintura = seguimientoL.getMedidaCintura();
                    Double cadera = seguimientoL.getMedidaCadera();
                    
                     jtMedidaPecho.setText(Double.toString(pecho));
                    jtMedidaCintura.setText(Double.toString(cintura));
                    jtMedidaCadera.setText(Double.toString(cadera));
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Todavia no existe un seguimiento, por favor ingrese los datos faltantes");
             
                }   
    }
    }
    

  private void agregar() {
    try {
        Paciente p = (Paciente) jcPacientes.getSelectedItem();
        String nombre = jtNombreDieta.getText();
        LocalDate fechaInicial = jdFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFinal = jdFechaFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Double pesoInicial = Double.valueOf(jtPesoInicial.getText());
        Double pesoFinal = Double.valueOf(jtPesoFinal.getText());
        Double altura = Double.valueOf(jtAltura.getText());
        Double pecho = Double.valueOf(jtMedidaPecho.getText());
        Double cintura = Double.valueOf(jtMedidaCintura.getText());
        Double cadera = Double.valueOf(jtMedidaCadera.getText());
        
        DietaData dietaData = new DietaData();
        Dieta dieta = new Dieta(nombre, p, fechaInicial, pesoInicial, pesoFinal, fechaFinal, altura);
        dietaData.guardarDieta(dieta);
        
        //Inicio el primer seguimiento
        SeguimientoData seguimientoData = new SeguimientoData();
        
        if (!seguimientoData.verificarSeguimientoExistente(p, fechaInicial)) {           
            int idDieta;
            SeguimientoData sd=new SeguimientoData();
            idDieta=sd.ultimoDieta();
            System.out.println(idDieta);
            Seguimiento seguimiento = new Seguimiento(p, fechaInicial, pecho, cintura, cadera, pesoInicial,idDieta);
            seguimientoData.AgregarSeguimiento(seguimiento);
            JOptionPane.showMessageDialog(null, "Dieta y seguimiento agregados con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un seguimiento para esta fecha.");
        }
        
    } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Paciente no encontrado " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Debe ingresar datos numéricos " + e.getMessage());
    }
}

 public void ModificarDatos() {
    try {
        Paciente p = (Paciente) jcPacientes.getSelectedItem();
        int idPaciente = p.getIdPaciente();

       
        Dieta dietaSeleccionada = (Dieta) comboDieta.getSelectedItem();
        int idDieta = dietaSeleccionada.getIdDieta();

        String nombre = jtNombreDieta.getText();

        LocalDate fechaInicial = jdFechaInicio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaFinal = jdFechaFinal.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Double pesoInicial = Double.valueOf(jtPesoInicial.getText());
        Double pesoFinal = Double.valueOf(jtPesoFinal.getText());
        Double altura = Double.valueOf(jtAltura.getText());
        Double pecho = Double.valueOf(jtMedidaPecho.getText());
        Double cintura = Double.valueOf(jtMedidaCintura.getText());
        Double cadera = Double.valueOf(jtMedidaCadera.getText());

        DietaData dietaData = new DietaData();

        Dieta dieta = new Dieta(idDieta, nombre, p, fechaInicial, pesoInicial, pesoFinal, fechaFinal, altura);
        dietaData.modificarDieta(idPaciente, dieta);

        SeguimientoData seguimientoData = new SeguimientoData();

           int idSeguimiento = seguimientoData.obtenerIdSeguimientoPorFechaYPaciente(idPaciente, fechaInicial, fechaFinal);
        
        Seguimiento seguimiento = new Seguimiento(idSeguimiento,p, fechaInicial, pecho, cintura, cadera, pesoInicial);
        
   
        seguimientoData.modificarSeguimiento(idPaciente, seguimiento);
        
        

        JOptionPane.showMessageDialog(null, "Dieta modificada");

    } catch (NumberFormatException | NullPointerException ex) {
        JOptionPane.showMessageDialog(null, "Error, Revisa los datos ingresados.");
    }
}
    
    private void EliminarDatos() {
        Paciente p = (Paciente) jcPacientes1.getSelectedItem();
        Dieta d=(Dieta) comboDieta.getSelectedItem();
        DietaData dd=new DietaData();
        dd.borrarDietaPorID(d.getIdDieta(),p.getIdPaciente());
        
    }
}




