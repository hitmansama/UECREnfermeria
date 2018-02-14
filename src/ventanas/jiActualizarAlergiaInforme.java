package ventanas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import pojos.Alumno;
import pojos.Electivo;
import pojos.Persona;
import recursos.Soporte.Herramientas;
import recursos.conexion.hAlumno;
import recursos.conexion.hElectivo;

public class jiActualizarAlergiaInforme extends javax.swing.JInternalFrame {

    public jiActualizarAlergiaInforme() {
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
        jPanel1 = new javax.swing.JPanel();
        jchEnviado = new javax.swing.JCheckBox();
        jchRecibido = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jtxtAlergia = new javax.swing.JTextField();
        jbtGuardar = new javax.swing.JButton();
        jbtGuardar1 = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jchEnviado.setText("Enviado");
        jchEnviado.setEnabled(false);
        jchEnviado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchEnviadoActionPerformed(evt);
            }
        });

        jchRecibido.setText("Recibido");
        jchRecibido.setEnabled(false);
        jchRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchRecibidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jchEnviado)
                .addGap(18, 18, 18)
                .addComponent(jchRecibido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchEnviado)
                    .addComponent(jchRecibido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Alergia:");

        jtxtAlergia.setEnabled(false);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbElectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtxtAlergia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addComponent(jbtGuardar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtGuardar)
                            .addComponent(jbtGuardar1)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jcbElectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbElectivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbElectivosActionPerformed
        cargarListaAlumno();
    }//GEN-LAST:event_jcbElectivosActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        if (jcbAlumno.getSelectedIndex() > 0) {
            jchEnviado.setEnabled(true);
            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
            jchEnviado.setSelected(alumno.getSeEnvioFormulario()==1);
            jchRecibido.setSelected(alumno.getSeRecibioFormulario()==1);
            jtxtAlergia.setText(alumno.getAlergia());
            jtxtAlergia.setEnabled(jchRecibido.isSelected());
            jchRecibido.setEnabled(jchEnviado.isSelected());
        } else {
            jchRecibido.setSelected(false);
            jchEnviado.setSelected(false);
            jtxtAlergia.setText("");
            jchRecibido.setEnabled(jchEnviado.isSelected());
            jtxtAlergia.setEnabled(jchRecibido.isSelected());
        }
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jchEnviadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchEnviadoActionPerformed
        jchRecibido.setEnabled(jchEnviado.isSelected());
        if (!jchEnviado.isSelected()) {
            jtxtAlergia.setEnabled(false);
            jchRecibido.setSelected(false);
            jtxtAlergia.setText("");
        }
    }//GEN-LAST:event_jchEnviadoActionPerformed

    private void jchRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchRecibidoActionPerformed
        jtxtAlergia.setEnabled(jchRecibido.isSelected());
        if (!jchRecibido.isSelected()) {
            jtxtAlergia.setText("");
        }
    }//GEN-LAST:event_jchRecibidoActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed
        if(jcbAlumno.getSelectedIndex()>0 && (jchRecibido.isSelected()?!jtxtAlergia.getText().trim().isEmpty():true)){
            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
            alumno.setAlergia(jtxtAlergia.getText());
            alumno.setSeEnvioFormulario(Herramientas.toByte(jchEnviado.isSelected()));
            alumno.setSeRecibioFormulario(Herramientas.toByte(jchRecibido.isSelected()));
            if(hAlumno.editarAlumno(alumno))
            {
                Herramientas.MensajeInfo("Formulario y alergia actualizado");
                this.dispose();
            }
        }
        else{
            Herramientas.MensajeAdv("Todos los campos son obligatorios");
        }
    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardar1ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jbtGuardar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtGuardar1;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JComboBox<String> jcbElectivos;
    private javax.swing.JCheckBox jchEnviado;
    private javax.swing.JCheckBox jchRecibido;
    private javax.swing.JTextField jtxtAlergia;
    // End of variables declaration//GEN-END:variables
}
