package Data;

import Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteData {

    private Connection con = null;

    public ClienteData() {

        con = Conexion.getConexion();
    }

    public void guardarCliente(Cliente cliente) {

        String sql = "INSERT INTO `cliente`(`dni`, `nombre`, `apellido`, `telefono`, `direccion`, `nombreAlternativo`, `contactoAlternativo`, `activo`)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(0, cliente.getDni());
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getNombreAl());
            ps.setInt(5, cliente.getTelefonoAl());
            ps.setBoolean(7, cliente.isActivo());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {

                    cliente.setIdCliente(rs.getInt(1));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Salio Malo");
            ex.printStackTrace();
        }
      
    }
    
    public Cliente buscarDni(int dni){
        
        Cliente cliente = null;
        
        String sql ="SELECT * FROM `cliente` WHERE dni=?";
        
        try (PreparedStatement ps = con.prepareStatement(sql);) {
        
            ps.setInt(0, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setDni(dni);
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setTelefono(rs.getInt("telefono"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setNombreAl(rs.getString("nombreAlternativo"));
            cliente.setTelefonoAl(rs.getInt("contactoAlternativo"));
            cliente.setActivo(rs.getBoolean("activo"));  
            }
                 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder :,( " + ex.getMessage());
            ex.printStackTrace();
        }

    return cliente;
    }

    public Cliente bucarId(int id){
    
        Cliente cliente = null;
        
        String sql ="SELECT `dni`, `nombre`, `apellido`, `telefono`, `direccion`, `nombreAlternativo`,"
                + " `contactoAlternativo`, `activo` FROM `cliente` WHERE idCliente = ? ";
        
        try (PreparedStatement ps = con.prepareStatement(sql);) {
        
            ps.setInt(0, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(id);
            cliente.setDni(rs.getInt("dni"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setTelefono(rs.getInt("telefono"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setNombreAl(rs.getString("nombreAlternativo"));
            cliente.setTelefonoAl(rs.getInt("contactoAlternativo"));
            cliente.setActivo(rs.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder :,( " + ex.getMessage());
            ex.printStackTrace();
        }
        
    return cliente;
    }
    
    public void modificar(){
    
    
    
    }
    
    
    
    
    
    

}
