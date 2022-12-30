package Parqueadero;

import java.util.ArrayList;
import java.util.Scanner;

/*El parqueadero "El guardián" presta sus servicios de parqueadero nocturno para los usuarios
 del barrio y requiere una aplicación que permita registrar los vehículos que se cuidan en estas instalaciones.

 Se sugiere que el parqueadero tenga los atributos del vehículo como son, placa y marca  y los datos del cliente
 como son nombre completo y número de teléfono.

 Para cada vehículo se debe permitir la opción de
 ingresar al parqueadero,
 retirar del parqueadero y
 consultar si un vehículo se encuentra en el parqueadero.

 Recuerde que el sistema debe terminar cuando el usuario así lo indique.
 Tenga en presente que el parqueadero solo puede almacenar máximo 5 vehículos.*/

public class Parqueadero {
    //Arrays
    static ArrayList<String> listaPlaca = new ArrayList<>();
    static ArrayList<String> listaMarca = new ArrayList<>();
    static ArrayList<String> listaNombre = new ArrayList<>();
    static ArrayList<String> listaApellido = new ArrayList<>();
    static ArrayList<String> listaTelefono = new ArrayList<>();



    //Variables
    static String marca, placa, nombre, apellido, telefono, opcion;

    public static void main(String[] args) {




        ////// MENU
        do {
            System.out.println("|///////////////////////////MENU///////////////////////////////|");
            System.out.println("| 1 - Ingresar Vehiculo.                                       |");
            System.out.println("| 2 - Retirar Vehiculo.                                        |");
            System.out.println("| 3 - Consultar si un vehículo se encuentra en el parqueadero. |");
            System.out.println("| 4 - Salir.                                                   |");
            System.out.println("|///////////////////////////👇/////////////////////////////////|");

            Scanner lectura = new Scanner(System.in);
            opcion = lectura.next();
            switch (opcion) {
                case "1":
                    if (listaPlaca.size() < 5) {
                        System.out.println("1- Ingresar Vehiculo");
                        System.out.println("Ingrese la placa del Vehiculo");
                        placa = lectura.next();
                        System.out.println("Ingrese la marca del Vehiculo");
                        marca = lectura.next();
                        System.out.println("Ingrese nombre del titular Vehiculo");
                        nombre = lectura.next();
                        System.out.println("Ingrese apellido del titular Vehiculo");
                        apellido = lectura.next();
                        System.out.println("Ingrese telefono del titular Vehiculo");
                        telefono = lectura.next();

                        registrarVehiculo(placa, marca, nombre, apellido, telefono);//,listaMarca,listaNombre,listaApellido,listaTelefono,listaPlaca

                        System.out.println("Se registro el vehiculo con la matricula " + placa + " ,marca: " + marca + " , a nombre de: " + nombre + " " + apellido);

                    } else {
                        System.out.println("Existen 5 Vehiculos Registrados");
                    }

                    break;

                case "2":
                    System.out.println("Para Retirar Vehiculo , Necesitamos la Placa");
                    placa = lectura.next();
                    retirarVechiculo(placa);
                    System.out.println(" Auto con placa " + placa + " fue retirado.");

                    break;

                case "3":
                    System.out.println("Para consultar Vehiculo , Necesitamos la Placa");
                    placa = lectura.next();

                    // Si no lo encuentra da MSG
                    if (consultarVechiculo(placa) == false) {
                        System.out.println("No se encuentra Vehiculo");
                    }

                    break;
                case "4":
                    System.out.println("Saliendo.....");
                    System.exit(0);

                    break;


                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != "4");


    }

    //////// Metodos
    // INGRESAR
    public static void registrarVehiculo(String placa, String marca, String nombre, String apellido, String telefono) {
        listaPlaca.add(placa);
        listaMarca.add(marca);
        listaNombre.add(nombre);
        listaApellido.add(apellido);
        listaTelefono.add(telefono);

    }

    // RETIRAR
    public static void retirarVechiculo(String placa) {
        int id = listaPlaca.indexOf(placa);
        listaPlaca.remove(id);
        listaMarca.remove(id);
        listaNombre.remove(id);
        listaApellido.remove(id);
        listaTelefono.remove(id);
    }


    //CONSULTAR
    public static boolean consultarVechiculo(String placa) {
        if (!listaPlaca.isEmpty()) {
            int id = listaPlaca.indexOf(placa);
            ArrayList<String> encontrado = new ArrayList<>();
            encontrado.add(listaPlaca.get(id));
            encontrado.add(listaMarca.get(id));
            encontrado.add(listaNombre.get(id));
            encontrado.add(listaApellido.get(id));
            encontrado.add(listaTelefono.get(id));

            System.out.println("Se encontro auto");
            for (int i = 0; i < encontrado.size(); i++) {
                System.out.println(encontrado.get(i));


            }
            return true;
        } else {
            return false;
        }

    }

}




