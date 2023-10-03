/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class MascotaData {
    
      private Connection con = null;

    public MascotaData() {

        con = Conexion.getConexion();
    }
    
    
    
    
}
