/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Entidades.Mascota;
import Entidades.Tratamiento;
import Entidades.Visita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class VisitaData {

    private Connection con = null;

    MascotaData datamascota = new MascotaData();
    TratamientoData datatrata = new TratamientoData();

    public VisitaData() {
        //datacliente = new ClienteData();
        //datamascota = new MascotaData();
        //datatrata = new TratamientoData();
        // datv=new VisitaData();
        con = Conexion.getConexion();
    }

    public void guardar(Visita visita) {
        String sql = "INSERT INTO `visita`(`idMascota`, `detalle`, `peso`, `idTratamiento`, `fechaVisita`, `activo`) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, visita.getMascota().getIdMascota());
            ps.setString(2, visita.getDetalle());
            ps.setDouble(3, visita.getPeso());
            ps.setInt(4, visita.getTratamiento().getIdTratamiento());
            ps.setDate(5, Date.valueOf(visita.getVisita()));
            ps.setBoolean(6, visita.isActivo());
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {

                    visita.setIdVisita(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "visita Guardada :)");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql guardar visita");
            ex.printStackTrace();
        }

    }

    public void modificar(Visita visita) {

        String sql = "UPDATE `visita` SET `idMascota`=?,`detalle`=?,`peso`=?,`idTratamiento`=?,`fechaVisita`=?,`activo`=? WHERE idVisita = ?";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, visita.getMascota().getIdMascota());
            ps.setString(2, visita.getDetalle());
            ps.setDouble(3, visita.getPeso());
            ps.setInt(4, visita.getTratamiento().getIdTratamiento());
            ps.setDate(5, Date.valueOf(visita.getVisita()));
            ps.setBoolean(6, visita.isActivo());
            ps.setInt(7, visita.getIdVisita());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "visita modificada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql modificar visita");
            ex.printStackTrace();
        }

    }

    public void eliminar(int id) {
        String sql = "UPDATE `visita` SET `activo`=0 WHERE idVisita =?";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "visita eliminada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql eliminar visita");
            ex.printStackTrace();
        }

    }

    public ArrayList<Visita> buscarVIDMa(int id) {
        ArrayList<Visita> listavisita = new ArrayList<>();
        String sql = "SELECT * FROM `visita` WHERE idMascota=?";
        Visita visita = null;

        Mascota mas = datamascota.buscarMascotaid(id);
        if (mas == null) {
            System.out.println("nulo :x" + mas);
        }
        Tratamiento tra = datatrata.buscar();

        try (PreparedStatement ps = con.prepareStatement(sql);) {
            if (mas != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    visita = new Visita();
                    visita.setActivo(rs.getBoolean("activo"));
                    visita.setDetalle(rs.getString("detalle"));
                    visita.setIdVisita(rs.getInt("idVisita"));
                    visita.setMascota(mas);
                    visita.setPeso(rs.getDouble("peso"));
                    visita.setTratamiento(tra);
                    visita.setVisita(rs.getDate("fechaVisita").toLocalDate());
                    listavisita.add(visita);

                }

            } else {
                JOptionPane.showMessageDialog(null, "visita nulo");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql buscar visita por id mascota");
            ex.printStackTrace();
        }

        return listavisita;
    }

    public ArrayList<Visita> buscarT(int id) {
        ArrayList<Visita> listavisita = new ArrayList<>();
        String sql = "SELECT * FROM `visita` WHERE idTratamiento = ? AND idMascota = ?;";
        Visita visita = null;
        Mascota mas = datamascota.buscarMascotaid(id);
        if (mas == null) {
            System.out.println("nulo :x" + mas);
        }
        Tratamiento tra = datatrata.buscar();

        try (PreparedStatement ps = con.prepareStatement(sql);) {
            if (mas != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    visita = new Visita();
                    visita.setActivo(rs.getBoolean("activo"));
                    visita.setDetalle(rs.getString("detalle"));
                    visita.setIdVisita(rs.getInt("idVisita"));
                    visita.setMascota(mas);
                    visita.setPeso(rs.getDouble("peso"));
                    visita.setTratamiento(tra);
                    visita.setVisita(rs.getDate("fechaVisita").toLocalDate());
                    listavisita.add(visita);

                }

            } else {
                JOptionPane.showMessageDialog(null, "visita nulo");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error sql buscar visita por id mascota");
            ex.printStackTrace();
        }

        return listavisita;
    }

}
