/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Yair
 */
public class ColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String estado = value.toString(); // Convertir el valor a una cadena

        if ("Concluida".equals(estado)) {
            c.setForeground(Color.BLUE);
        } else if ("Cancelada".equals(estado)) {
            c.setForeground(Color.RED);
        } else if ("Pendiente".equals(estado)) {
            c.setForeground(Color.GREEN);
        } else {
            c.setForeground(table.getForeground());
        }

        return c;
    }

}
