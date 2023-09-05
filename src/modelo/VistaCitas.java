/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Yair
 */
public class VistaCitas {
    private int idCitaVista;
    private int idPacienteVista;
    private String nombrePacienteVista;
    private String apellidosPacienteVista;
    private Date fechaCitaVista;
    private String horaCitaVista;
    private String estadoCitaVista;
    
    public VistaCitas(){
        
    }

    public int getIdCitaVista() {
        return idCitaVista;
    }

    public void setIdCitaVista(int idCitaVista) {
        this.idCitaVista = idCitaVista;
    }

    public int getIdPacienteVista() {
        return idPacienteVista;
    }

    public void setIdPacienteVista(int idPacienteVista) {
        this.idPacienteVista = idPacienteVista;
    }

    public String getNombrePacienteVista() {
        return nombrePacienteVista;
    }

    public void setNombrePacienteVista(String nombrePacienteVista) {
        this.nombrePacienteVista = nombrePacienteVista;
    }

    public String getApellidosPacienteVista() {
        return apellidosPacienteVista;
    }

    public void setApellidosPacienteVista(String apellidosPacienteVista) {
        this.apellidosPacienteVista = apellidosPacienteVista;
    }

    public Date getFechaCitaVista() {
        return fechaCitaVista;
    }

    public void setFechaCitaVista(Date fechaCitaVista) {
        this.fechaCitaVista = fechaCitaVista;
    }

    public String getHoraCitaVista() {
        return horaCitaVista;
    }

    public void setHoraCitaVista(String horaCitaVista) {
        this.horaCitaVista = horaCitaVista;
    }

    public String getEstadoCitaVista() {
        return estadoCitaVista;
    }

    public void setEstadoCitaVista(String estadoCitaVista) {
        this.estadoCitaVista = estadoCitaVista;
    }
    
    
    
}
