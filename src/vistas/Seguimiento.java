/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.SeguimientoCitaDAOImpl;
import interfaces.SeguimientoCitaDAO;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.SeguimientoCita;
import sistemaconsultorionutri.Dashboard;

/**
 *
 * @author Yair
 */
public final class Seguimiento extends javax.swing.JPanel {

    /**
     * Creates new form Citas
     */
    public Seguimiento() {
        initComponents();
        listarSeguimientos();
    }

    private void listarSeguimientos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();

            List<SeguimientoCita> seguimientoCitas = new SeguimientoCitaDAOImpl().listar(Pacientes.getIdPaciente());

            String[] columnas = {"ID Archivo", "ID Cita", "Observaciones", "Archivo"};
            modelo.setColumnIdentifiers(columnas);

            for (SeguimientoCita seguimientoCita : seguimientoCitas) {
                String[] renglon = {
                    String.valueOf(seguimientoCita.getSeguimientoCitaId()),
                    String.valueOf(seguimientoCita.getCitaId()), // Cambio aquí
                    seguimientoCita.getObservaciones(), seguimientoCita.getNombreArchivo()
                };

                modelo.addRow(renglon);
            }

            tablaSeguimiento.setModel(modelo);

            // Ajustar las columnas al tamaño del contenido
            packColumn(tablaSeguimiento, 2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Método para ajustar las columnas de la tabla
    private void packColumn(JTable table, int column) {
        int maxWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(cellRenderer, row, column);
            maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
        }
        table.getColumnModel().getColumn(column).setPreferredWidth(maxWidth);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSeguimiento = new javax.swing.JTable();
        btnVisualizarArchivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiPaciente = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(788, 496));
        setPreferredSize(new java.awt.Dimension(988, 588));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaSeguimiento.setBackground(new java.awt.Color(255, 255, 255));
        tablaSeguimiento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaSeguimiento);

        btnVisualizarArchivo.setBackground(new java.awt.Color(0, 102, 102));
        btnVisualizarArchivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVisualizarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizarArchivo.setText("Visualizar archivo");
        btnVisualizarArchivo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 15, new java.awt.Color(0, 0, 0)));
        btnVisualizarArchivo.setBorderPainted(false);
        btnVisualizarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVisualizarArchivo.setFocusPainted(false);
        btnVisualizarArchivo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVisualizarArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVisualizarArchivo.setIconTextGap(10);
        btnVisualizarArchivo.setSelected(true);
        btnVisualizarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarArchivoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Seguimiento");

        etiPaciente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiPaciente.setText("Paciente: Nombre Paciente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVisualizarArchivo)
                            .addComponent(etiPaciente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(etiPaciente)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btnVisualizarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarArchivoActionPerformed
        try {
            int fila = tablaSeguimiento.getSelectedRow();
            if (fila == -1) {
                Dashboard.mostrarMensajeAlerta("Seleccione un regitro");
                return;
            }

            String idArchivo = (String.valueOf(tablaSeguimiento.getValueAt(fila, 0)));

            SeguimientoCitaDAO seguimientoCitaDAO = new SeguimientoCitaDAOImpl();
            seguimientoCitaDAO.VisualizarSeguimeientoCita(idArchivo);
        } catch (Exception ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVisualizarArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizarArchivo;
    public static javax.swing.JLabel etiPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSeguimiento;
    // End of variables declaration//GEN-END:variables
}
