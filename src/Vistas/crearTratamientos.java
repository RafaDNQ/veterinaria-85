/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Data.TratamientoData;
import Entidades.Tratamiento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class crearTratamientos extends javax.swing.JInternalFrame {

    boolean insertar = false;
    boolean modoModificacion = true;
    boolean finInsercion = false;
    Tratamiento aux = new Tratamiento();
    boolean bloquearSeleccion = false;
    TratamientoData tradata = new TratamientoData();
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (bloquearSeleccion) {
                int ultimaFila = jtTabla.getRowCount() - 1;
                int idColumna = 0;
                return column > idColumna && ultimaFila == row;
            }
            return column > 0;
        }
    };

    public crearTratamientos() {
        initComponents();
        setClosable(true);
        CargarTabla();
        CargarTratamientos();
        jtTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Evento para manejar la tabla
        jtTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    try {
                        if (bloquearSeleccion) {
                            jtTabla.getSelectionModel().setSelectionInterval(jtTabla.getRowCount() - 1, jtTabla.getRowCount() - 1);
                        }
//                        
//                    int fila=jtTabla.getSelectedRow();
//                    int columna=jtTabla.getSelectedColumn();
//                    if(fila!=-1 && columna!=-1 ){
//                    aux=new Tratamiento();
//                        for(int columnas=0;columnas<jtTabla.getColumnCount();columnas++){
//                            Object obj=jtTabla.getValueAt(fila, columnas);
//                            if(obj==null){
//                                System.out.println("esta nulo");
//                            }
//                            switch (columnas) {
//                                case 0:
//                                    
//                                    aux.setIdTratamiento((Integer) obj);
//                                    break;
//                                case 1:
//                                    aux.setTipoTratamiento((String) obj);
//                                    break;
//                                case 2:
//                                    aux.setDescripcion((String)obj);
//                                    break;
//                                default:
//                                    aux.setInporte((Double)obj);
//                                    break;
//                            }
//                            
//                        }
//                        
//                        
//                       // aux=(Tratamiento)jtTabla.getValueAt(fila, columna);
//                       // System.out.println(aux);
//                        
//                        
//                    }     

                    } catch (NullPointerException ex) {

                        JOptionPane.showMessageDialog(null, "Ha ocurrido puntero vacio", "NullPointerException", JOptionPane.ERROR_MESSAGE);

                    } catch (RuntimeException ex) {

                        JOptionPane.showMessageDialog(null, "Debe completar los campos", "form", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }

        });

        jtTabla.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    System.out.println("evento de actualizacion");
                    int fila = e.getLastRow();
                    for (int columnas = 1; columnas < jtTabla.getColumnCount(); columnas++) {
                        Object obj = jtTabla.getValueAt(fila, columnas);
                        if (obj != null) {
                            System.out.println("1 "+obj);
                            switch (columnas) {
                                case 1:
                                    System.out.println("caso1 "+obj);
                                    aux.setTipoTratamiento( (String)obj);
                                    // System.out.println("columna 1 " + aux.getTipoTratamiento());
                                    break;
                                case 2:
                                    System.out.println("caso2 "+obj);
                                    aux.setDescripcion( (String)obj);
                                    // System.out.println("columna 2 " + aux.getDescripcion());
                                    break;
                                case 3:
                                    //System.out.println("valor de obj columna 3"+obj);
                                    //Double importeString = (String) obj;
//                                    Double valor=(Double) obj;
//                                    System.out.println(obj);
                                    // System.out.println(importeString);
                                    //Double importe = Double.valueOf(importeString);
//                                    System.out.println(valor);
                                    System.out.println("caso3 "+obj);
                                    Double valor = new Double (obj.toString());
                                    System.out.println(obj);
                                    aux.setImporte(valor);
                                    System.out.println("columna 3" + aux.getImporte());
                                    break;
                                default:
                                    System.out.println("erro");
                                    break;

                            }

                        }

                    }
//                    System.out.println(aux.getIdTratamiento());
//                    System.out.println(aux.getTipoTratamiento());
//                    System.out.println(aux.getDescripcion());
//                    System.out.println(aux.getImporte());

                    boolean validacion = aux.getImporte() > 0 && !aux.getDescripcion().isEmpty() && !aux.getDescripcion().isEmpty();
                    if (validacion && insertar) {
                        System.out.println("insercion Interna");
                        int opc = JOptionPane.showConfirmDialog(null, "Desea insertar estos datos?Y/N", "Confirmacion", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (opc == 0) {
                            aux.setActivo(true);
                            tradata.guardarTratamiento(aux);
                            limpiarTabla();
                            CargarTratamientos();
                            finInsercion = true;
                            bloquearSeleccion = false;
                            aux = null;
                            aux = new Tratamiento();
                            jtTabla.clearSelection();

                        }
                    } else if (modoModificacion) {
                        Tratamiento tratamiento = obtenerTramiento(true);
                        int respuesta = JOptionPane.showConfirmDialog(null, "Desea modificar este tratamiento?Y?N", "Confirmacion", JOptionPane.YES_NO_OPTION);

                        if (validacion && tratamiento.getIdTratamiento() > 0 && respuesta == 0) {
                            tradata.modificar(tratamiento);
                        } else {
                            JOptionPane.showMessageDialog(null, "Operacion abortada", "Mensaje", JOptionPane.WARNING_MESSAGE);
                        }

                    }

                } else if (e.getType() == TableModelEvent.INSERT) {
                    if (aux == null) {
                        aux = new Tratamiento();
                    }
                    finInsercion = false;
                    insertar = true;
                    modoModificacion = false;
                    System.out.println("evento de insercion");
                    if (!finInsercion) {
                        bloquearSeleccion = true;
                    }

                }
            }

        });

    }

    private void CargarTabla() {
        modelo.addColumn("ID");
        modelo.addColumn("Tipo Tratamiento");
        modelo.addColumn("Descripcion");
        modelo.addColumn("importe");
        jtTabla.setModel(modelo);

    }

    private void CargarTratamientos() {
        ArrayList<Tratamiento> listaTratamientos = tradata.ListaTrata();
        for (Tratamiento t : listaTratamientos) {
            modelo.addRow(new Object[]{
                t.getIdTratamiento(),
                t.getTipoTratamiento(),
                t.getDescripcion(),
                t.getImporte()
            });

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jbGuardar1 = new javax.swing.JButton();
        jbEliminar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTabla1 = new javax.swing.JTable();
        jbNuevo1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Listas de Tratamientos");

        jbGuardar.setText("Cancelar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtTabla);

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Lista de tratamientos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbNuevo))
                .addGap(21, 21, 21))
        );

        jbGuardar1.setText("guardar");
        jbGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardar1ActionPerformed(evt);
            }
        });

        jbEliminar1.setText("Eliminar");
        jbEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminar1ActionPerformed(evt);
            }
        });

        jtTabla1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtTabla1);

        jbNuevo1.setText("nuevo");
        jbNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevo1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Lista de tratamientos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbNuevo1)
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar1)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar1)
                    .addComponent(jbEliminar1)
                    .addComponent(jbNuevo1))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        int fila = jtTabla.getSelectedRow();
        if (fila != -1) {
            modelo.removeRow(fila);
            bloquearSeleccion = false;
            modoModificacion = true;
            insertar = false;
            jtTabla.clearSelection();
        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        modelo.addRow(new Object[]{});


    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        Tratamiento auxiliar = obtenerTramiento(true);
        if (auxiliar != null) {
            tradata.eliminar(auxiliar.getIdTratamiento());
            limpiarTabla();
            CargarTratamientos();
            jtTabla.clearSelection();
            bloquearSeleccion = false;
            //_>
            modoModificacion = true;
            insertar = false;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede borrar este elemento", "Ups", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGuardar1ActionPerformed

    private void jbEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminar1ActionPerformed

    private void jbNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbNuevo1ActionPerformed

    private void limpiarTabla() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);

        }

    }

    private Tratamiento obtenerTramiento(boolean id) {
        Tratamiento auxiliar = new Tratamiento();
        try {
            int val = id ? 0 : 1;
            int fila = jtTabla.getSelectedRow();
            int columna = jtTabla.getSelectedColumn();
            if (fila != -1 && columna != -1) {

                for (int columnas = val; columnas < jtTabla.getColumnCount(); columnas++) {
                    Object obj = jtTabla.getValueAt(fila, columnas);
//                    if (obj == null) {
//                        throw new RuntimeException("El objeto es nulo");
//                    }
                    switch (columnas) {
                        case 0:
                            auxiliar.setIdTratamiento((Integer) obj);
                            break;
                        case 1:
                            auxiliar.setTipoTratamiento((String) obj);
                            break;
                        case 2:
                            auxiliar.setDescripcion((String) obj);
                            break;
                        default:
                            auxiliar.setImporte((Double) obj);
                            break;
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun elemento", "error", JOptionPane.WARNING_MESSAGE);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + ex.getMessage(), "Info", JOptionPane.WARNING_MESSAGE);
        }
        return auxiliar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEliminar1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbGuardar1;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbNuevo1;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTable jtTabla1;
    // End of variables declaration//GEN-END:variables

}
