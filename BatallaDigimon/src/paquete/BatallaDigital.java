package paquete;

import java.util.Random;
import java.util.Scanner;

public class BatallaDigital {
    Digimon enemigo;

    public BatallaDigital() {
        Random rand = new Random();
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        this.enemigo = new Digimon(nombres[rand.nextInt(nombres.length)]);
    }

    public Digimon elige(Domador domador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige un Digimon para la batalla:");
        for (int i = 0; i < domador.equipo.size(); i++) {
            System.out.println((i + 1) + ". " + domador.equipo.get(i));
        }
        int choice = sc.nextInt();
        return domador.equipo.get(choice - 1);
    }

    public void pelea(Domador domador) {
        Scanner sc = new Scanner(System.in);
        Digimon elegido = elige(domador);

        while (true) {
            System.out.println("Stats de tu Digimon:");
            System.out.println(elegido);

            System.out.println("Stats del Digimon enemigo:");
            System.out.println(enemigo);

            System.out.println("Elige una acción:");
            System.out.println("1. Ataque 1");
            System.out.println("2. Ataque 2");
            System.out.println("3. Capturar");

            int accion = sc.nextInt();
            int damage = 0;

            switch (accion) {
                case 1:
                    damage = elegido.ataque1();
                    enemigo.healthPoints -= damage;
                    break;
                case 2:
                    damage = elegido.ataque2();
                    enemigo.healthPoints -= damage;
                    break;
                case 3:
                    domador.captura(enemigo);
                    return;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            System.out.println("El enemigo tiene " + enemigo.healthPoints + " puntos de salud restantes.");

            if (enemigo.healthPoints <= 0) {
                System.out.println("El enemigo ha sido derrotado.");
                return;
            }
        }
    }
}
