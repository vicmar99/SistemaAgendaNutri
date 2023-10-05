/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CitaDAOImplm;
import controlador.VistaCitasDAOImpl;
import interfaces.CitaDAO;
import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelo.Cita;
import modelo.ColorRenderer;
import modelo.VistaCitas;
import sistemaconsultorionutri.Dashboard;
import static sistemaconsultorionutri.Dashboard.showView;
import static vistas.ReagendarCita.txtNoCita;
import static vistas.ReagendarCita.txtPaciente;

/**
 *
 * @author Yair
 */
public class Citas extends javax.swing.JPanel {

    /**
     * Creates new form Citas
     */
    public Citas() {
        initComponents();
        listarCitas();
    }

    private void listarCitas() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();

            List<VistaCitas> vistaCitas = new VistaCitasDAOImpl().listar();

            String[] columnas = {"ID Cita", "ID Paciente", "Nombre Paciente", "Apellidos", "Fecha", "Hora", "Estado"};
            modelo.setColumnIdentifiers(columnas);

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd-MM-yyyy");

            for (VistaCitas vistaCita : vistaCitas) {
                String fechaFormateada = "";
                if (vistaCita.getFechaCitaVista() != null) {
                    fechaFormateada = dateFormat.format(vistaCita.getFechaCitaVista());
                }

                String[] renglon = {
                    String.valueOf(vistaCita.getIdCitaVista()),
                    String.valueOf(vistaCita.getIdPacienteVista()),
                    vistaCita.getNombrePacienteVista(),
                    vistaCita.getApellidosPacienteVista(),
                    fechaFormateada, // Usar la fecha formateada
                    vistaCita.getHoraCitaVista(),
                    vistaCita.getEstadoCitaVista()
                };

                modelo.addRow(renglon);
            }

            tablaCitas.setModel(modelo);

            // Aplicar el TableCellRenderer a la columna "Estado"
            TableColumn estadoColumn = tablaCitas.getColumnModel().getColumn(6); // Ajusta el índice de columna si es diferente
            estadoColumn.setCellRenderer(new ColorRenderer());

            packColumn(tablaCitas, 4);
            packColumn(tablaCitas, 3);

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

    //Metodo para realizar un filtrado de citas del día de hoy
    private void filtrarCitas(List<VistaCitas> vistaCitas) {
        try {
            DefaultTableModel modelo = new DefaultTableModel();

            String[] columnas = {"ID Cita", "ID Paciente", "Nombre Paciente", "Apellidos", "Fecha", "Hora", "Estado"};
            modelo.setColumnIdentifiers(columnas);

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd-MM-yyyy");

            for (VistaCitas vistaCita : vistaCitas) {
                String fechaFormateada = "";
                if (vistaCita.getFechaCitaVista() != null) {
                    fechaFormateada = dateFormat.format(vistaCita.getFechaCitaVista());
                }

                String[] renglon = {
                    String.valueOf(vistaCita.getIdCitaVista()),
                    String.valueOf(vistaCita.getIdPacienteVista()),
                    vistaCita.getNombrePacienteVista(),
                    vistaCita.getApellidosPacienteVista(),
                    fechaFormateada,
                    vistaCita.getHoraCitaVista(),
                    vistaCita.getEstadoCitaVista()
                };

                modelo.addRow(renglon);
            }

            tablaCitas.setModel(modelo);

            // Aplicar el TableCellRenderer a la columna "Estado"
            TableColumn estadoColumn = tablaCitas.getColumnModel().getColumn(6); // Ajusta el índice de columna si es diferente
            estadoColumn.setCellRenderer(new ColorRenderer());

            packColumn(tablaCitas, 4);
            packColumn(tablaCitas, 3);

        } catch (Exception e) {
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        btnConcluida = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnreagendar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        radioCitasHoy = new javax.swing.JRadioButton();
        radioCitasManiana = new javax.swing.JRadioButton();
        radioCitasSiguientes = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(788, 496));
        setPreferredSize(new java.awt.Dimension(988, 588));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaCitas.setBackground(new java.awt.Color(255, 255, 255));
        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCitas);

        btnConcluida.setBackground(new java.awt.Color(0, 102, 102));
        btnConcluida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnConcluida.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluida.setText("Concluída");
        btnConcluida.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 15, new java.awt.Color(0, 0, 0)));
        btnConcluida.setBorderPainted(false);
        btnConcluida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConcluida.setFocusPainted(false);
        btnConcluida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConcluida.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConcluida.setIconTextGap(10);
        btnConcluida.setSelected(true);
        btnConcluida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluidaActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 15, new java.awt.Color(0, 0, 0)));
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setIconTextGap(10);
        btnCancelar.setSelected(true);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnreagendar.setBackground(new java.awt.Color(0, 102, 102));
        btnreagendar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnreagendar.setForeground(new java.awt.Color(255, 255, 255));
        btnreagendar.setText("Reagendar");
        btnreagendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 15, new java.awt.Color(0, 0, 0)));
        btnreagendar.setBorderPainted(false);
        btnreagendar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreagendar.setFocusPainted(false);
        btnreagendar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnreagendar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnreagendar.setIconTextGap(10);
        btnreagendar.setSelected(true);
        btnreagendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreagendarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Citas");

        radioCitasHoy.setText("Citas de hoy");
        radioCitasHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCitasHoyActionPerformed(evt);
            }
        });
        radioCitasHoy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radioCitasHoyKeyPressed(evt);
            }
        });

        radioCitasManiana.setText("Citas de mañana");
        radioCitasManiana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCitasManianaActionPerformed(evt);
            }
        });

        radioCitasSiguientes.setText("Citas siguientes");
        radioCitasSiguientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCitasSiguientesActionPerformed(evt);
            }
        });

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
                        .addComponent(btnConcluida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreagendar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioCitasHoy)
                        .addGap(18, 18, 18)
                        .addComponent(radioCitasManiana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCitasSiguientes)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCitasHoy)
                    .addComponent(radioCitasManiana)
                    .addComponent(radioCitasSiguientes))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreagendar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnConcluidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluidaActionPerformed
        int fila = tablaCitas.getSelectedRow();
        if (fila == -1) {
            Dashboard.mostrarMensajeAlerta("¡Seleccione una cita!");
            return;
        }

        String idCita = String.valueOf(tablaCitas.getValueAt(fila, 0));

        CitaDAO citaDAO = new CitaDAOImplm();

        try {
            Cita citaBD = citaDAO.traerCita(idCita);

            if ("Cancelada".equals(citaBD.getEstado()) || "Concluida".equals(citaBD.getEstado())) {
                Dashboard.mostrarMensajeAlerta("La cita no se puede concluir");
                return;
            }

        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
            Dashboard.mostrarMensajeError("No se pudo realizar la operación");
        }

        CitaConcluida cc = new CitaConcluida();
        CitaConcluida.txtIdCita.setText(idCita);

        Dashboard.showView(cc);
    }//GEN-LAST:event_btnConcluidaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int fila = tablaCitas.getSelectedRow();
        if (fila == -1) {
            Dashboard.mostrarMensajeAlerta("¡Seleccione una cita!");
            return;
        }

        String idCita = String.valueOf(tablaCitas.getValueAt(fila, 0));
        String hora = String.valueOf(tablaCitas.getValueAt(fila, 5));

        CitaDAO citaDAO = new CitaDAOImplm();
        try {
            Cita citaBD = citaDAO.traerCita(idCita);

            if ("Cancelada".equals(citaBD.getEstado())) {
                Dashboard.mostrarMensajeAlerta("La cita ya ha sido cancelada.");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de cancelar la cita?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion != JOptionPane.YES_OPTION) {
                return; // El usuario canceló la operación
            }

            LocalDate fecha = citaBD.getFecha().toLocalDate();

            String nuevoEstado = "Cancelada";
            citaBD.setEstado(nuevoEstado);
            citaBD.setFecha(Date.valueOf(fecha));
            citaBD.setHora(hora);

            citaDAO.actualizar(citaBD);
            Dashboard.mostrarMensajeAviso("La cita ha sido cancelada exitosamente.");

            vistas.Citas citas = new Citas();
            showView(citas);
        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
            Dashboard.mostrarMensajeError("No se pudo realizar la operación.");
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnreagendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreagendarActionPerformed
        int fila = tablaCitas.getSelectedRow();
        if (fila == -1) {
            Dashboard.mostrarMensajeAlerta("¡Seleccione una cita!");
            return;
        }

        String idCita = String.valueOf(tablaCitas.getValueAt(fila, 0));
        String nombre = String.valueOf(tablaCitas.getValueAt(fila, 2));
        String apellidos = String.valueOf(tablaCitas.getValueAt(fila, 3));

        CitaDAO citaDAO = new CitaDAOImplm();
        try {
            Cita citaBD = citaDAO.traerCita(idCita);

            if ("Cancelada".equals(citaBD.getEstado()) || "Concluida".equals(citaBD.getEstado())) {
                Dashboard.mostrarMensajeAlerta("La cita no se puede reagendar");
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
            Dashboard.mostrarMensajeError("No se pudo realizar la operación");
        }

        ReagendarCita rc = new ReagendarCita();
        txtNoCita.setText(idCita);
        txtPaciente.setText(nombre + " " + apellidos);
        Dashboard.showView(rc);
    }//GEN-LAST:event_btnreagendarActionPerformed

    private void radioCitasHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCitasHoyActionPerformed

        try {
            List<VistaCitas> vistaCitas = new VistaCitasDAOImpl().filtrarHoy();
            if (vistaCitas == null || vistaCitas.isEmpty()) {
                radioCitasHoy.setSelected(false);
                Dashboard.mostrarMensajeAviso("No tiene citas programadas para el día de hoy");
                return;
            }

            radioCitasManiana.setSelected(false);
            radioCitasSiguientes.setSelected(false);

            filtrarCitas(vistaCitas);
        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioCitasHoyActionPerformed

    private void radioCitasHoyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radioCitasHoyKeyPressed

    }//GEN-LAST:event_radioCitasHoyKeyPressed

    private void radioCitasManianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCitasManianaActionPerformed

        try {
            List<VistaCitas> vistaCitas = new VistaCitasDAOImpl().filtrarManiana();
            if (vistaCitas == null || vistaCitas.isEmpty()) {
                radioCitasManiana.setSelected(false);
                Dashboard.mostrarMensajeAviso("No tiene citas programadas para el día de mañana");
                return;
            }

            radioCitasHoy.setSelected(false);
            radioCitasSiguientes.setSelected(false);

            filtrarCitas(vistaCitas);
        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_radioCitasManianaActionPerformed

    private void radioCitasSiguientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCitasSiguientesActionPerformed

        try {
            List<VistaCitas> vistaCitas = new VistaCitasDAOImpl().filtrarSiguientes();
            if (vistaCitas == null || vistaCitas.isEmpty()) {
                radioCitasSiguientes.setSelected(false);
                Dashboard.mostrarMensajeAviso("No tiene citas programadas para los días siguientes");
                return;
            }

            radioCitasHoy.setSelected(false);
            radioCitasManiana.setSelected(false);

            filtrarCitas(vistaCitas);
        } catch (Exception ex) {
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_radioCitasSiguientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConcluida;
    private javax.swing.JButton btnreagendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioCitasHoy;
    private javax.swing.JRadioButton radioCitasManiana;
    private javax.swing.JRadioButton radioCitasSiguientes;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
