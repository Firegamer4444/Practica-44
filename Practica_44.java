import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Practica_44 {

    public String busqueda_dni(File fichero){
        Scanner scanner = new Scanner(System.in);
        String dni = scanner.nextLine();
        scanner.close();
        String linea = null;
        try (FileReader fileReader = new FileReader(fichero);
        BufferedReader bufferedReader = new BufferedReader(fileReader);){
        while((linea=bufferedReader.readLine()) != null) {
            if (linea.substring(0 , 9) == dni){
                return linea;
            }
        }
        System.out.print("El dni introducido no existe");
        return linea;
        }
        catch (IOException e) {
            System.out.print("Error al leer el archivo");
            return linea;

        }
    }

    public void imprimir_datos(String linea){
        String[] linea_c = linea.split(" , ");
        System.out.println("nombre: " + linea_c[1]);
        System.out.println("apellidos: " + linea_c[2]);
        System.out.println("correo" + linea_c[3]);
    } 

    public static void main(String[] args){

    }
}