/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Paciente;

/**
 *
 * @author Yair
 */
public interface PacienteDAO {
    
    public void agregar(Paciente paciente) throws Exception;

    public List<Paciente> listar() throws Exception;
    
    public void eliminar(String idPaciente);
    
    public void actualizar (Paciente paciente);
    
    public List<Paciente> buscar (String paciente);
    
}
