/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.VistaCitas;

/**
 *
 * @author Yair
 */
public interface VistaCitasDAO {
    
    public List<VistaCitas> listar() throws Exception;
    
    public List<VistaCitas> filtrarHoy() throws Exception;
    
    public List<VistaCitas> filtrarSiguientes() throws Exception;
    
    
}
