/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.SeguimientoCita;

/**
 *
 * @author Yair
 */
public interface SeguimientoCitaDAO {
    
    public void agregar(SeguimientoCita seguimientoCita) throws Exception;
    
    public List<SeguimientoCita> listar(String idUsuario) throws Exception;
    
    public void VisualizarSeguimeientoCita(String idSeguimiento) throws Exception;
    
}
