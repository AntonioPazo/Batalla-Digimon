package paquete;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del domador:");
        String nombreDomador = sc.nextLine();

        Domador domador = new Domador(nombreDomador);
        BatallaDigital batalla = new BatallaDigital();

        while (true) {
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");

            int opcion = sc.nextInt();

            if (opcion == 1) {
                batalla.pelea(domador);
            } else if (opcion == 2) {
                System.out.println("Saliendo del juego...");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
