/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SelectionMode;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import pojos.Alumno;
import pojos.Electivo;
import pojos.Historialclinico;
import pojos.Persona;
import recursos.Soporte.Herramientas;
import recursos.Soporte.conector;
import recursos.Soporte.consultas;
import recursos.conexion.hAlumno;
import recursos.conexion.hElectivo;
import recursos.conexion.hHistorial;

/**
 *
 * @author PC
 */
public class jiHistorialClinico extends javax.swing.JInternalFrame {

    /**
     * Creates new form jiHistorialClinico
     */
    public jiHistorialClinico() {
        initComponents();
        cargarAñosElectivos();
        Electivo electivo = hElectivo.esteElectivo();
        jcbElectivo.setSelectedItem(electivo);
        cargarListaAlumno();

    }
    int idAux;

    private void cargarAñosElectivos() {
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
        jcbElectivo.setModel(cbModel);
    }

    private void cargarListaAlumno() {
        DefaultComboBoxModel cbModelo = new DefaultComboBoxModel();
        Persona aux = new Persona();
        cbModelo.addElement("");
        List<Alumno> lAlumno = hAlumno.obtenerAlumnosPorElectivo((Electivo) jcbElectivo.getSelectedItem());
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

    private void cargarListaHistoria() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Fecha");
        dtm.addColumn("Hora");
        dtm.addColumn("Enfermedad");
        dtm.addColumn("Seguimmiento");
        dtm.addColumn("aux");
        if (jcbAlumno.getSelectedIndex() == 0) {
            reiniciarContenido();
            return;
        }
        List<Historialclinico> historial = hHistorial.obtenerHistorialPorAlumno((Alumno) jcbAlumno.getSelectedItem());
        if (historial != null) {
            Iterator it = historial.iterator();
            for (Iterator<Historialclinico> iterator = historial.iterator(); iterator.hasNext();) {
                boolean agregar = true;
                Historialclinico next = iterator.next();
                if (jcbFiltroHistorial.getSelectedIndex() == 2) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(next.getFecha());
                    agregar = cal.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH);
                }

                if (jcbFiltroHistorial.getSelectedIndex() == 1) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(next.getFecha());
                    agregar = cal.get(Calendar.WEEK_OF_YEAR) == Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
                }

                if (agregar) {
                    Object[] objetos = new Object[5];
                    objetos[0] = new SimpleDateFormat("dd-MMM-yyyy").format(next.getFecha());
                    objetos[1] = new SimpleDateFormat("hh:mm").format(next.getHora());
                    objetos[2] = next.getEnfermedad() + ": " + next.getDetalle();
                    objetos[3] = next.getRecomendacion().trim().isEmpty() ? "Sin recomendación" : next.getSeguimiento() == 1 ? next.getRecomendacion() + ". Se ha seguido las recomendaciones." : next.getRecomendacion() + ". No se ha seguido las recomendaciones";
                    objetos[4] = next;
//                    dtm.addRow(new String[]{new SimpleDateFormat("dd-MMM-yyyy").format(next.getFecha()), new SimpleDateFormat("hh:mm").format(next.getHora()), next.getEnfermedad() + ": " + next.getDetalle(), next.getRecomendacion().trim().isEmpty() ? "Sin recomendación" : next.getSeguimiento() == 1 ? next.getRecomendacion() + "Se ha seguido las recomendaciones." : next.getRecomendacion() + ". No se ha seguido las recomendaciones"});
                    dtm.addRow(objetos);

                }
            }
            jtHistorial.setModel(dtm);
            jtHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jtHistorial.setDefaultEditor(Object.class, null);
            jtHistorial.getTableHeader().setReorderingAllowed(false);
            jtHistorial.removeColumn(jtHistorial.getColumnModel().getColumn(4));
        }

    }

    private void deshabilitarEdicionTabla() {
        TableModel cm = jtHistorial.getModel();

    }

    private void reiniciarContenido() {
        jchHPV01.setSelected(false);
        jchHPV02.setSelected(false);
        jchSRP01.setSelected(false);
        jchSRP02.setSelected(false);
        jchInfluencia.setSelected(false);
        jtxtRepresentante.setText("");
        jtxtContactoRepresentante.setText("");
        jtxtDetalle.setText("");
        jopEnviado.setSelected(false);
        jopRecibido.setSelected(false);
        jtHistorial.setModel(new DefaultTableModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbElectivo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHistorial = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtRepresentante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtContactoRepresentante = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jchSRP01 = new javax.swing.JCheckBox();
        jchSRP02 = new javax.swing.JCheckBox();
        jchHPV01 = new javax.swing.JCheckBox();
        jchHPV02 = new javax.swing.JCheckBox();
        jchInfluencia = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jopEnviado = new javax.swing.JRadioButton();
        jopRecibido = new javax.swing.JRadioButton();
        jtxtDetalle = new javax.swing.JTextField();
        jcbFiltroHistorial = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtxtEstaturaInicial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtPesoInicial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtEstaturaFinal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtPesoFinal = new javax.swing.JTextField();
        jbSeguimiento = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Historial clinico");
        setToolTipText("");
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Año electivo");

        jcbElectivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbElectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbElectivoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Alumno");

        jcbAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jtHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtHistorial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtHistorialFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jtHistorial);

        jbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.setEnabled(false);
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Representante");

        jtxtRepresentante.setEditable(false);
        jtxtRepresentante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Contacto");

        jtxtContactoRepresentante.setEditable(false);
        jtxtContactoRepresentante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtContactoRepresentante.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vacunas"));

        jchSRP01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jchSRP01.setText("S.R.P. 01");
        jchSRP01.setEnabled(false);
        jchSRP01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchSRP01ActionPerformed(evt);
            }
        });

        jchSRP02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jchSRP02.setText("S.R.P. 02");
        jchSRP02.setEnabled(false);
        jchSRP02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchSRP02ActionPerformed(evt);
            }
        });

        jchHPV01.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jchHPV01.setText("H.P.V. 01");
        jchHPV01.setEnabled(false);
        jchHPV01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchHPV01ActionPerformed(evt);
            }
        });

        jchHPV02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jchHPV02.setText("H.P.V. 02");
        jchHPV02.setEnabled(false);
        jchHPV02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchHPV02ActionPerformed(evt);
            }
        });

        jchInfluencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jchInfluencia.setText("Influenza");
        jchInfluencia.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jchSRP01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchSRP02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchHPV01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchHPV02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchInfluencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchSRP01)
                    .addComponent(jchSRP02)
                    .addComponent(jchHPV01)
                    .addComponent(jchHPV02)
                    .addComponent(jchInfluencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jopEnviado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jopEnviado.setText("Enviado");
        jopEnviado.setEnabled(false);
        jopEnviado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jopEnviadoActionPerformed(evt);
            }
        });

        jopRecibido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jopRecibido.setText("Recibido");
        jopRecibido.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jopEnviado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jopRecibido))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jopEnviado)
                    .addComponent(jopRecibido))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtxtDetalle.setEditable(false);
        jtxtDetalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtDetalle)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtContactoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtContactoRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbFiltroHistorial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbFiltroHistorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo el año", "Esta semana", "Este mes" }));
        jcbFiltroHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltroHistorialActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Estatura inicial:");

        jtxtEstaturaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtEstaturaInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtEstaturaInicial.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Peso inicial:");

        jtxtPesoInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPesoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtPesoInicial.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Estatura final:");

        jtxtEstaturaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtEstaturaFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtEstaturaFinal.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Peso final:");

        jtxtPesoFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPesoFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtPesoFinal.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtEstaturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtEstaturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jtxtEstaturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jtxtPesoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jtxtPesoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jtxtEstaturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbSeguimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbSeguimiento.setText("Seguimiento");
        jbSeguimiento.setEnabled(false);
        jbSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeguimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbElectivo, 0, 262, Short.MAX_VALUE)
                            .addComponent(jcbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbFiltroHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSeguimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNuevo))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbElectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFiltroHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevo)
                    .addComponent(jbSeguimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbElectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbElectivoActionPerformed
        cargarListaAlumno();
    }//GEN-LAST:event_jcbElectivoActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        if (jcbAlumno.getSelectedIndex() > 0) {
            Alumno aux = (Alumno) jcbAlumno.getSelectedItem();
            Persona per = aux.getPersona();
            jchHPV01.setSelected(per.getHpv01() == 1 ? true : false);
            jchHPV02.setSelected(per.getHpv02() == 1 ? true : false);
            jchSRP01.setSelected(per.getSrp01() == 1 ? true : false);
            jchSRP02.setSelected(per.getSrp02() == 1 ? true : false);
            jchInfluencia.setSelected(per.getInfluencia() == 1 ? true : false);
            jtxtRepresentante.setText(aux.getRepresentante().toString());
            jtxtContactoRepresentante.setText(aux.getRepresentante().getContacto());
            jtxtDetalle.setText(aux.getAlergia());
            jopEnviado.setSelected(aux.getSeEnvioFormulario() == 1 ? true : false);
            jopRecibido.setSelected(aux.getSeRecibioFormulario() == 1 ? true : false);
            jtxtEstaturaInicial.setText(Float.toString(aux.getEstaturaInicial()) + "cm");
            jtxtEstaturaFinal.setText(Float.toString(aux.getEstaturaFinal()) + "cm");
            jtxtPesoInicial.setText(Float.toString(aux.getPesoInicial()) + "Kg");
            jtxtPesoFinal.setText(Float.toString(aux.getPesoFinal()) + "Kg");
            cargarListaHistoria();
        } else {
            reiniciarContenido();
        }
        jbNuevo.setEnabled(jcbAlumno.getSelectedIndex() > 0);
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        new jdNuevoHistorialClinico(null, true, (Alumno) jcbAlumno.getSelectedItem()).show();
        cargarListaHistoria();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jchSRP01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchSRP01ActionPerformed
        jchSRP01.setSelected(!jchSRP01.isSelected());
    }//GEN-LAST:event_jchSRP01ActionPerformed

    private void jchSRP02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchSRP02ActionPerformed
        jchSRP02.setSelected(!jchSRP02.isSelected());
    }//GEN-LAST:event_jchSRP02ActionPerformed

    private void jchHPV01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchHPV01ActionPerformed
        jchHPV01.setSelected(!jchHPV01.isSelected());
    }//GEN-LAST:event_jchHPV01ActionPerformed

    private void jchHPV02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchHPV02ActionPerformed
        jchHPV02.setSelected(!jchHPV02.isSelected());
    }//GEN-LAST:event_jchHPV02ActionPerformed

    private void jopEnviadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jopEnviadoActionPerformed
        jopEnviado.setSelected(!jopEnviado.isSelected());
    }//GEN-LAST:event_jopEnviadoActionPerformed

    private void jtxtDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDetalleActionPerformed

    private void jcbFiltroHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltroHistorialActionPerformed
        cargarListaHistoria();
    }//GEN-LAST:event_jcbFiltroHistorialActionPerformed

    private void jbSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeguimientoActionPerformed

        new jdEditarSeguimiento(null, true, (Historialclinico) jtHistorial.getModel().getValueAt(jtHistorial.getSelectedRow(), 4)).show();
        Alumno aux = (Alumno) jcbAlumno.getSelectedItem();
        Persona per = aux.getPersona();
        jchHPV01.setSelected(per.getHpv01() == 1 ? true : false);
        jchHPV02.setSelected(per.getHpv02() == 1 ? true : false);
        jchSRP01.setSelected(per.getSrp01() == 1 ? true : false);
        jchSRP02.setSelected(per.getSrp02() == 1 ? true : false);
        jchInfluencia.setSelected(per.getInfluencia() == 1 ? true : false);
        jtxtRepresentante.setText(aux.getRepresentante().toString());
        jtxtContactoRepresentante.setText(aux.getRepresentante().getContacto());
        jtxtDetalle.setText(aux.getAlergia());
        jopEnviado.setSelected(aux.getSeEnvioFormulario() == 1 ? true : false);
        jopRecibido.setSelected(aux.getSeRecibioFormulario() == 1 ? true : false);
        jtxtEstaturaInicial.setText(Float.toString(aux.getEstaturaInicial()) + "cm");
        jtxtEstaturaFinal.setText(Float.toString(aux.getEstaturaFinal()) + "cm");
        jtxtPesoInicial.setText(Float.toString(aux.getPesoInicial()) + "Kg");
        jtxtPesoFinal.setText(Float.toString(aux.getPesoFinal()) + "Kg");
        cargarListaHistoria();
    }//GEN-LAST:event_jbSeguimientoActionPerformed

    private void jtHistorialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtHistorialFocusGained
        jbSeguimiento.setEnabled(true);
    }//GEN-LAST:event_jtHistorialFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSeguimiento;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JComboBox<String> jcbElectivo;
    private javax.swing.JComboBox<String> jcbFiltroHistorial;
    private javax.swing.JCheckBox jchHPV01;
    private javax.swing.JCheckBox jchHPV02;
    private javax.swing.JCheckBox jchInfluencia;
    private javax.swing.JCheckBox jchSRP01;
    private javax.swing.JCheckBox jchSRP02;
    private javax.swing.JRadioButton jopEnviado;
    private javax.swing.JRadioButton jopRecibido;
    private javax.swing.JTable jtHistorial;
    private javax.swing.JTextField jtxtContactoRepresentante;
    private javax.swing.JTextField jtxtDetalle;
    private javax.swing.JTextField jtxtEstaturaFinal;
    private javax.swing.JTextField jtxtEstaturaInicial;
    private javax.swing.JTextField jtxtPesoFinal;
    private javax.swing.JTextField jtxtPesoInicial;
    private javax.swing.JTextField jtxtRepresentante;
    // End of variables declaration//GEN-END:variables
}
