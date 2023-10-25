/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Data.ClienteData;
import Data.MascotaData;
import Data.TratamientoData;
import Data.VisitaData;
import Entidades.Cliente;
import Entidades.Mascota;
import Entidades.Tratamiento;
import Entidades.Visita;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class listaVisita extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {

        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    VisitaData vidata = new VisitaData();
    MascotaData masdata = new MascotaData();
    TratamientoData tradata = new TratamientoData();
    int idMascota = vistasVisita.getterId();
    double peso;
    public static int idVisita;

    public listaVisita() {
        initComponents();
        armarCabecera();
        CargarVisita();
        cargarcombo();
        peso = vidata.promedioVisitas(idMascota);
        jlPesoPromedio.setText(""+peso+" Kg");

    }

    private void cargarcombo() {
        ArrayList<Tratamiento> tra = tradata.ListaTrata();

        if (tra != null) {
            for (Tratamiento m : tra) {
                jcCombo.addItem(m);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtAlias = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcCombo = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbBuscarVisitasMascota = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jlPesoPromedio = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador de Visitas");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setText("Lista de Visita de mascota");

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtTabla);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre :");

        jtAlias.setEditable(false);
        jtAlias.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Crear Visita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tratamientos:");

        jcCombo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jbBuscar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Peso Promedio de las ultimas 10 visitas:");

        jbBuscarVisitasMascota.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbBuscarVisitasMascota.setText("Actualizar");
        jbBuscarVisitasMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarVisitasMascotaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Visitas de la Mascota :");

        jlPesoPromedio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlPesoPromedio.setText("0");

        jbModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbModificar.setText("Modificar Visita");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEliminar.setText("Eliminar Visita");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarVisitasMascota)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbEliminar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(jlPesoPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbBuscar))))
                                .addGap(0, 177, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jbBuscarVisitasMascota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlPesoPromedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbModificar)
                    .addComponent(jbEliminar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearVisita ventana = new crearVisita();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        limpiarTabla();
        cargarTabla2();
        


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbBuscarVisitasMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarVisitasMascotaActionPerformed
        limpiarTabla();
        CargarVisita();
  
    }//GEN-LAST:event_jbBuscarVisitasMascotaActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // eliminar
        int fila = jtTabla.getSelectedRow();
        if(fila!=-1){
        int idvisita= (Integer)jtTabla.getValueAt(fila, 0);
        vidata.eliminar(idvisita);
        modelo.removeRow(fila);
        peso = vidata.promedioVisitas(idMascota);
        jlPesoPromedio.setText(""+peso+" Kg");
        }
        
        
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        int fila = jtTabla.getSelectedRow();
        if(fila!=-1){
        int idv= (Integer)jtTabla.getValueAt(fila, 0);
        idVisita = idv;
        }
        ModificarVisita ventana = new ModificarVisita();
        ventana.setVisible(true);
        
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        peso = vidata.promedioVisitas(idMascota);
        jlPesoPromedio.setText(""+peso+" Kg");
    
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaVisita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscarVisitasMascota;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<Tratamiento> jcCombo;
    private javax.swing.JLabel jlPesoPromedio;
    private javax.swing.JTextField jtAlias;
    private javax.swing.JTable jtTabla;
    // End of variables declaration//GEN-END:variables
private void armarCabecera() {
        modelo.addColumn("ID Visita ");
        modelo.addColumn("Fecha ");
        modelo.addColumn("Detalle ");
        modelo.addColumn("Peso ");
        modelo.addColumn("tratamiento ");
        modelo.addColumn("Finalizado ");
        jtTabla.setModel(modelo);

    }

    private void CargarVisita() {

        if (idMascota > 0) {
            jtAlias.setText(masdata.buscarMascotaid(idMascota).getAlias());
            ArrayList<Visita> listaTratamientos = vidata.buscarVIDMa(idMascota);
            for (Visita t : listaTratamientos) {
                modelo.addRow(new Object[]{
                    t.getIdVisita(),
                    t.getVisita(),
                    t.getDetalle(),
                    t.getPeso(),
                    t.getTratamiento().getTipoTratamiento(),
                    t.isFinalizado()?"si":"no"
                   
                        
                });

            }

        }
    }

    private void cargarTabla2() {
        int idtratamiento = ((Tratamiento) jcCombo.getSelectedItem()).getIdTratamiento();
        ArrayList<Visita> listaTratamientos = vidata.buscarT(idMascota, idtratamiento);
        for (Visita t : listaTratamientos) {
            modelo.addRow(new Object[]{
                t.getIdVisita(),
                t.getVisita(),
                t.getDetalle(),
                t.getPeso(),
                t.getTratamiento().getTipoTratamiento(),
                 t.isFinalizado()?"si":"no"
            });

        }
    }

    private void limpiarTabla() {
        int filas = modelo.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);

        }

    }

    public static int idvisitaselecionada(){
 
    
    return idVisita;
    }
}
