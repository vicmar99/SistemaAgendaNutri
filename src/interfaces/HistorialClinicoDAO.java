/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.HistorialClinico;

/**
 *
 * @author Yair
 */
public interface HistorialClinicoDAO {
    
    public void agregar(HistorialClinico historialClinico) throws Exception;
    
    public void visualizarHistorialC(String idHistorial) throws Exception;
    
   public HistorialClinico traerHistorialC(String idHistorial) throws Exception;
    
}
