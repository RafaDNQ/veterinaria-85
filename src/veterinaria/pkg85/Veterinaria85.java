/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package veterinaria.pkg85;

import Data.ClienteData;
import Data.MascotaData;
import Entidades.Cliente;
import Entidades.Mascota;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Veterinaria85 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteData cli = new ClienteData();
        Cliente juan = new Cliente(10,"Marcos", 555123123, "Pérez", "Av. Ocampo 1111", 12121212, " Gabriel Pérez", 23232323, true);
        System.out.println(juan.getIdCliente());
        Mascota perro = new Mascota(7,"pochi","macho", "perro", "labrador", "blanco", 7, LocalDate.now(), juan, true);
        
        MascotaData mas=new MascotaData();
       // cli.guardarCliente(juan);
        mas.eliminar(perro.getIdMascota());
        
        
        
        
        
        
        
        
//-----------------------------------------------------------------------------------------------
//        Cliente juan = new Cliente("Marcos", 555123123, "Pérez", "Av. Ocampo 1111", 12121212, " Gabriel Pérez", 23232323, true);
//        ClienteData cli = new ClienteData();
//          cli.eliminarCliente(9);
//
//        cli.guardarCliente(juan);
//
//        Cliente clientee = cli.buscarDni(555123123);
//        if (clientee != null) {
//            System.out.println("cliente encontrado");
//            for (Cliente c : cli.listar()) {
//                System.out.println(c);
//            };
//
//        } else {
//            System.out.println("salio mal");
//        }
//
//        Cliente juan2 = new Cliente(juan.getIdCliente(),"juan", 4444, "Pérez", "Av. Ocampo 1111", 12121212, " Gabriel Pérez", 23232323, true);
//        cli.modificar(juan2);
//        
//        if (clientee != null) {
//            System.out.println("cliente encontrado");
//            for (Cliente c : cli.listar()) {
//                System.out.println(c);
//            };
//
//        } else {
//            System.out.println("salio mal");
//        }
    }

}
