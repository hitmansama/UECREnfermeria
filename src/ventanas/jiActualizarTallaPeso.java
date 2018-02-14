package ventanas;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import pojos.Alumno;
import pojos.Electivo;
import pojos.Persona;
import recursos.Soporte.Herramientas;
import recursos.conexion.hAlumno;
import recursos.conexion.hElectivo;
import static recursos.Soporte.Herramientas.isFloat;
import static recursos.Soporte.Herramientas.formatearDecimal;

public class jiActualizarTallaPeso extends javax.swing.JInternalFrame {

    public jiActualizarTallaPeso() {
        initComponents();
        CargarElectivos();
        cargarListaAlumno();
    }

    public void CargarElectivos() {
        Electivo aux = new Electivo();
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        List<Electivo> lEl = hElectivo.obtenerElectivos();
        if (lEl != null) {
            Iterator it = lEl.iterator();
            for (Iterator<Electivo> iterator = lEl.iterator(); iterator.hasNext();) {
                Electivo next = iterator.next();
                cbModel.addElement(next);
            }
        }
        jcbElectivos.setModel(cbModel);
    }

    private void cargarListaAlumno() {
        DefaultComboBoxModel cbModelo = new DefaultComboBoxModel();
        Persona aux = new Persona();
        cbModelo.addElement("");
        List<Alumno> lAlumno = hAlumno.obtenerAlumnosPorElectivo((Electivo) jcbElectivos.getSelectedItem());
        if (lAlumno != null) {
            Iterator it = lAlumno.iterator();
            for (Iterator<Alumno> iterator = lAlumno.iterator(); iterator.hasNext();) {
                Alumno next = iterator.next();
                cbModelo.addElement(next);
            }
        }
        jcbAlumno.setModel(cbModelo);
        AutoCompleteDecorator.decorate(jcbAlumno);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbElectivos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jbtGuardar = new javax.swing.JButton();
        jbtGuardar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtEstaturaInicial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtPesoInicial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtxtEstaturaFinal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtPesoFinal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Formulario y alergia");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Electivo: ");
        jLabel1.setToolTipText("");

        jcbElectivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbElectivosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Alumno:");
        jLabel2.setToolTipText("");

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jbtGuardar.setText("Guardar");
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });

        jbtGuardar1.setText("Cancelar");
        jbtGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardar1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicial"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Estatura:");

        jtxtEstaturaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtEstaturaInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtEstaturaInicial.setText("0.00");
        jtxtEstaturaInicial.setEnabled(false);
        jtxtEstaturaInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtEstaturaInicialFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Peso:");

        jtxtPesoInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPesoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtPesoInicial.setText("0.00");
        jtxtPesoInicial.setEnabled(false);
        jtxtPesoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPesoInicialFocusLost(evt);
            }
        });

        jLabel7.setText("cm");

        jLabel8.setText("Kg");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtPesoInicial)
                    .addComponent(jtxtEstaturaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtEstaturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Final"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Estatura:");

        jtxtEstaturaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtEstaturaFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtEstaturaFinal.setText("0.00");
        jtxtEstaturaFinal.setEnabled(false);
        jtxtEstaturaFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtEstaturaFinalFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Peso:");

        jtxtPesoFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPesoFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtPesoFinal.setText("0.00");
        jtxtPesoFinal.setEnabled(false);
        jtxtPesoFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtPesoFinalFocusLost(evt);
            }
        });

        jLabel11.setText("cm");

        jLabel12.setText("Kg");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtPesoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jtxtEstaturaFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtEstaturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbElectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtGuardar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcbElectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtGuardar)
                            .addComponent(jbtGuardar1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbElectivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbElectivosActionPerformed
        cargarListaAlumno();
    }//GEN-LAST:event_jcbElectivosActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        if (jcbAlumno.getSelectedIndex() > 0) {
            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
            
            jtxtEstaturaInicial.setText(formatearDecimal(alumno.getEstaturaInicial()));
            jtxtPesoInicial.setText(formatearDecimal(alumno.getPesoInicial()));
            jtxtEstaturaFinal.setText(formatearDecimal(alumno.getEstaturaFinal()));
            jtxtPesoFinal.setText(formatearDecimal(alumno.getPesoFinal()));
            jtxtEstaturaFinal.setEnabled(true);
            jtxtEstaturaInicial.setEnabled(true);
            jtxtPesoFinal.setEnabled(true);
            jtxtPesoInicial.setEnabled(true);
        } else {
            jtxtEstaturaFinal.setText("0.00");
            jtxtEstaturaInicial.setText("0.00");
            jtxtPesoFinal.setText("0.00");
            jtxtPesoInicial.setText("0.00");
            jtxtEstaturaFinal.setEnabled(false);
            jtxtEstaturaInicial.setEnabled(false);
            jtxtPesoFinal.setEnabled(false);
            jtxtPesoInicial.setEnabled(false);
        }
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed
        Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
        alumno.setEstaturaFinal(Float.parseFloat(jtxtEstaturaFinal.getText()));
        alumno.setEstaturaInicial(Float.parseFloat(jtxtEstaturaInicial.getText()));
        alumno.setPesoFinal(Float.parseFloat(jtxtPesoFinal.getText()));
        alumno.setPesoInicial(Float.parseFloat(jtxtPesoInicial.getText()));
        if(hAlumno.editarAlumno(alumno)){
            Herramientas.MensajeInfo("Pesos y estaturas actualizados");
            this.dispose();
        }
    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtGuardar1ActionPerformed

    private void jtxtEstaturaFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtEstaturaFinalFocusLost
       jtxtEstaturaFinal.setText(isFloat(jtxtEstaturaFinal.getText())?formatearDecimal(Float.parseFloat(jtxtEstaturaFinal.getText())):"0.00");
    }//GEN-LAST:event_jtxtEstaturaFinalFocusLost

    private void jtxtPesoFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPesoFinalFocusLost
       jtxtPesoFinal.setText(isFloat(jtxtPesoFinal.getText())?formatearDecimal(Float.parseFloat(jtxtPesoFinal.getText())):"0.00");
    }//GEN-LAST:event_jtxtPesoFinalFocusLost

    private void jtxtEstaturaInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtEstaturaInicialFocusLost
        jtxtEstaturaInicial.setText(isFloat(jtxtEstaturaInicial.getText())?formatearDecimal(Float.parseFloat(jtxtEstaturaInicial.getText())):"0.00");
    }//GEN-LAST:event_jtxtEstaturaInicialFocusLost

    private void jtxtPesoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtPesoInicialFocusLost
         jtxtPesoInicial.setText(isFloat(jtxtPesoInicial.getText())?formatearDecimal(Float.parseFloat(jtxtPesoInicial.getText())):"0.00");
    }//GEN-LAST:event_jtxtPesoInicialFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtGuardar1;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JComboBox<String> jcbElectivos;
    private javax.swing.JTextField jtxtEstaturaFinal;
    private javax.swing.JTextField jtxtEstaturaInicial;
    private javax.swing.JTextField jtxtPesoFinal;
    private javax.swing.JTextField jtxtPesoInicial;
    // End of variables declaration//GEN-END:variables
}
