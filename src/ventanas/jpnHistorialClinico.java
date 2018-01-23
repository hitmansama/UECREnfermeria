/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.JLabel;
import recursos.Soporte.Herramientas;
import recursos.Soporte.consultas;

/**
 *
 * @author PC
 */
public class jpnHistorialClinico extends javax.swing.JPanel {

    /**
     * Creates new form jpnHistorialClinico
     */
    public jpnHistorialClinico() {
        initComponents();
    }
    private String nombreEstudiante;
    private int idAlumno;
    public String getNombreEstudiante() {
        nombreEstudiante = jtxtEstudiante.getText();
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
        jtxtEstudiante.setText(nombreEstudiante);
    }
    public boolean campoLleno(){
        return jcbEnfermedad.getSelectedIndex()==jcbEnfermedad.getItemCount()-1?!jtxtOtroEnfermedad.getText().trim().isEmpty():jcbEnfermedad.getSelectedIndex()>0;
    }
    public boolean guardar(){
        if(campoLleno()){
            if(consultas.guardarHistorialClinicoAlumno(idAlumno,jcbEnfermedad.getSelectedIndex()<jcbEnfermedad.getItemCount()-1?jcbEnfermedad.getSelectedItem().toString():jtxtOtroEnfermedad.getText(), new java.util.Date(),jTextArea1.getText())){
                Herramientas.MensajeInfo("Historial guardado");
                return true;
            }
        }
        else{
            Herramientas.MensajeAdv("Hay campos vacios.");
        }
         return false;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbEnfermedad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxtOtroEnfermedad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha y hora: Genera automaticamente al guardar");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Alumno:");

        jtxtEstudiante.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enfermedad: ");

        jcbEnfermedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Asma", "Dolor de cabeza", "Dolor estomaca", "Dolor muscular", "Fiebre", "Herida", "Malestar general", "Mareo", "Náuseas", "Otitis", "Sangrado nasal", "Traumatismo", "Vertigo", "Vómito", "Otro:" }));
        jcbEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEnfermedadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Otros:");

        jtxtOtroEnfermedad.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Detalle:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbEnfermedad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtOtroEnfermedad)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtOtroEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEnfermedadActionPerformed
      jtxtOtroEnfermedad.setEnabled(!(jcbEnfermedad.getSelectedIndex()<jcbEnfermedad.getItemCount()-1));
      if(!jtxtOtroEnfermedad.isEnabled()){
          jtxtOtroEnfermedad.setText("");
      }
    }//GEN-LAST:event_jcbEnfermedadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jcbEnfermedad;
    private javax.swing.JTextField jtxtEstudiante;
    private javax.swing.JTextField jtxtOtroEnfermedad;
    // End of variables declaration//GEN-END:variables
}