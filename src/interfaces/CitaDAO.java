/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import java.util.List;
import modelo.Cita;

/**
 *
 * @author Yair
 */
public interface CitaDAO {
    
    public void agregar(Cita cita) throws Exception;
    
    public void actualizar(Cita cita) throws Exception;
    
    public List<Cita> listar() throws Exception;
    
    public Cita traerCita(String idCita) throws Exception;
    
}
