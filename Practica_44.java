import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Practica_44 {

    public static String busqueda_dni(String fichero){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el dni: ");
        String dni = scanner.nextLine();
        String linea = null;
        try (FileReader fileReader = new FileReader(fichero);
        BufferedReader bufferedReader = new BufferedReader(fileReader);){
        while((linea=bufferedReader.readLine()) != null) {
            if (linea.substring(0, 9).equals(dni)){
                scanner.close();
                return linea;
            }
        }
        System.out.print("El dni introducido no existe");
        scanner.close();
        return linea;
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
            scanner.close();
            return linea;
        }
    }

    public static void imprimir_datos(String linea){
        String[] linea_c = linea.split(", ");
        System.out.println("nombre: " + linea_c[1]);
        System.out.println("apellidos: " + linea_c[2]);
        System.out.println("correo: " + linea_c[3]);
    } 

    public static void menu(){
        while (true){
            String fichero = "usuarios.txt";
            System.out.println("\n--- Opciones: ---");
            System.out.println("1. Buscar usuario por DNI");
            System.out.println("2. cerrar programa");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione una opcion: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                String linea = busqueda_dni(fichero);
                if (linea == null){
                    System.out.println("\nVuelva a elejir una opcion");
                }
                else {
                    imprimir_datos(linea);
                }
            }
            else if(opcion.equals("2")){
                scanner.close();
                return;
            }
        }
    }

    public static void main(String[] args){
        menu();
    }
}