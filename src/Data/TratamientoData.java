/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TratamientoData {

    private Connection con = null;
    ClienteData datacliente = null;

    public TratamientoData() {
        datacliente = new ClienteData();
        con = Conexion.getConexion();
    }

    public void guardarTratamiento(Tratamiento trata) {

        String sql = " INSERT INTO `tratamiento`(`tipoTratamiento`, `descripcion`, `importe`, `activo`) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, trata.getTipoTratamiento());
            ps.setString(2, trata.getDescripcion());
            ps.setDouble(3, trata.getInporte());
            ps.setBoolean(4, trata.isActivo());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {

                    trata.setIdTratamiento(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "tratamiento Guardado :)");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql trata guardar");
            ex.printStackTrace();
        }

    }

    public void modificar(Tratamiento trata) {

        String sql = "UPDATE `tratamiento` SET `tipoTratamiento`=?,`descripcion`=?,`importe`=?,`activo`=? WHERE idTratamiento = ?";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, trata.getTipoTratamiento());
            ps.setString(2, trata.getDescripcion());
            ps.setDouble(3, trata.getInporte());
            ps.setBoolean(4, trata.isActivo());
            ps.setInt(5, trata.getIdTratamiento());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "tratamiento modificado");
            }

        } catch (SQLException ex) {
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Tratamiento buscar() {
        Tratamiento trata = null;

        String sql = "SELECT * FROM `tratamiento` WHERE 1";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trata = new Tratamiento();
                trata.setTipoTratamiento(rs.getString("tipoTratamiento"));
                trata.setDescripcion(rs.getString("descripcion"));
                trata.setActivo(rs.getBoolean("activo"));
                trata.setIdTratamiento(rs.getInt("idTratamiento"));
                trata.setInporte(rs.getDouble("inporte"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql buscar trata :,( " + ex.getMessage());
            ex.printStackTrace();
        }
        return trata;
    }
    
    public void eliminar(int id){
    String sql ="UPDATE `tratamiento` SET `activo`=0 WHERE idTratamiento =?";
    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
    
         ps.setInt(1, id);
        int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "tratamiento eliminado");
            }
        
        
    }   catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error sql eliminar trata :,( " + ex.getMessage());
            ex.printStackTrace();
        }
    
    
    }
    
    
    

}
