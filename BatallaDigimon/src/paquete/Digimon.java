package paquete;

import java.util.Random;

/**
 * La clase Digimon representa a un Digimon con nombre, nivel, puntos de ataque, salud y puntos de ataque digital (DP1 y DP2).
 */
public class Digimon {
    String name;
    int level;
    int attackPoints;
    int healthPoints;
    int dp1;
    int dp2;

    /**
     * Constructor para inicializar un Digimon con un nombre.
     * @param name Nombre del Digimon.
     */
    public Digimon(String name) {
        this.name = name;
        Random rand = new Random();
        this.level = rand.nextInt(5) + 1; // Nivel entre 1 y 5
        this.attackPoints = this.level * 5;
        this.healthPoints = this.level * 10;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    /**
     * Realiza el ataque1, que causa daño igual a los puntos de ataque del Digimon y reduce DP1 en 1.
     * @return Daño causado por el ataque1.
     */
    public int ataque1() {
        if (dp1 > 0) {
            dp1--;
            return attackPoints;
        } else {
            System.out.println("No quedan DP1 suficientes.");
            return 0;
        }
    }

    /**
     * Realiza el ataque2, que causa daño igual al doble de los puntos de ataque del Digimon y reduce DP2 en 2.
     * @return Daño causado por el ataque2.
     */
    public int ataque2() {
        if (dp2 > 0) {
            dp2 -= 2;
            return attackPoints * 2;
        } else {
            System.out.println("No quedan DP2 suficientes.");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Digimon: " + name + " | Nivel: " + level + " | Ataque: " + attackPoints + " | Salud: " + healthPoints + " | DP1: " + dp1 + " | DP2: " + dp2;
    }
}
