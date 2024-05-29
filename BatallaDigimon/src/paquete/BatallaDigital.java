package paquete;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * La clase BatallaDigital representa una batalla entre el Digimon del domador y un Digimon enemigo.
 */
public class BatallaDigital {
    Digimon enemigo;

    /**
     * Constructor para inicializar una batalla con un Digimon enemigo aleatorio.
     * @param domador Domador con el que se va a realizar la batalla.
     */
    public BatallaDigital(Domador domador) {
        Random rand = new Random();
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        ArrayList<String> nombresDisponibles = new ArrayList<>();
        for (String nombre : nombres) {
            if (!domador.nombresDeDigimon().contains(nombre)) {
                nombresDisponibles.add(nombre);
            }
        }
        this.enemigo = new Digimon(nombresDisponibles.get(rand.nextInt(nombresDisponibles.size())));
    }

    /**
     * Permite al domador elegir un Digimon de su equipo para la batalla.
     * @param domador Domador que elige el Digimon.
     * @return El Digimon elegido para la batalla.
     */
    public Digimon elige(Domador domador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige un Digimon para la batalla:");
        for (int i = 0; i < domador.equipo.size(); i++) {
            System.out.println((i + 1) + ". " + domador.equipo.get(i));
        }
        int choice = sc.nextInt();
        return domador.equipo.get(choice - 1);
    }

    /**
     * Realiza la batalla entre el Digimon elegido del domador y el Digimon enemigo.
     * @param domador Domador que participa en la batalla.
     */
    public void pelea(Domador domador) {
        Scanner sc = new Scanner(System.in);
        Digimon elegido = elige(domador);

        while (true) {
            System.out.println("Stats de tu Digimon:");
            System.out.println(elegido);

            System.out.println("Stats del Digimon enemigo:");
            System.out.println(enemigo);

            System.out.println("Elige una acción:");
            System.out.println("1. Ataque 1 (Daño: " + elegido.attackPoints + ")");
            System.out.println("2. Ataque 2 (Daño: " + (elegido.attackPoints * 2) + ")");
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
