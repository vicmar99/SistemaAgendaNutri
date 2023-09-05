/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Yair
 */
public class HistorialClinico {
    
    private int historialId;
    private String archivoReferencia;
    private String archivoNombre;
    private int pacienteId;
    
    public HistorialClinico(){
        
    }

    public int getHistorialId() {
        return historialId;
    }

    public void setHistorialId(int historialId) {
        this.historialId = historialId;
    }


    public String getArchivoReferencia() {
        return archivoReferencia;
    }

    public void setArchivoReferencia(String archivoReferencia) {
        this.archivoReferencia = archivoReferencia;
    }

    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    
}
