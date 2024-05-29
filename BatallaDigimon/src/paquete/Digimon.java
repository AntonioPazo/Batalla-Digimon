package paquete;

import java.util.Random;

public class Digimon {
    String name;
    int level;
    int attackPoints;
    int healthPoints;
    int dp1;
    int dp2;

    public Digimon(String name) {
        this.name = name;
        Random rand = new Random();
        this.level = rand.nextInt(5) + 1; // Nivel entre 1 y 5
        this.attackPoints = this.level * 5;
        this.healthPoints = this.level * 10;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public int ataque1() {
        if (dp1 > 0) {
            dp1--;
            return attackPoints;
        } else {
            System.out.println("No quedan DP1 suficientes.");
            return 0;
        }
    }

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
        return "Digimon: " + name + " | Nivel: " + level + " | Ataque: " + attackPoints + " | Salud: " + healthPoints;
    }
}
