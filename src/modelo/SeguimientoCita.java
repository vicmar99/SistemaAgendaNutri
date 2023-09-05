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
public class SeguimientoCita {
    
    private int seguimientoCitaId;
    private int citaId;
    private String observaciones;
    private String nombreArchivo;
    private String rutaArchivo;
    
    
    public SeguimientoCita() {
        
    }

    public int getSeguimientoCitaId() {
        return seguimientoCitaId;
    }

    public void setSeguimientoCitaId(int seguimientoCitaId) {
        this.seguimientoCitaId = seguimientoCitaId;
    }

    public int getCitaId() {
        return citaId;
    }

    public void setCitaId(int citaId) {
        this.citaId = citaId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    
}
