package paquete;

import java.util.ArrayList;
import java.util.Random;

public class Domador {
    String nombre;
    ArrayList<Digimon> equipo;
    final int MAX_EQUIPO = 3;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        Random rand = new Random();
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        for (String nombreDigimon : nombres) {
            this.equipo.add(new Digimon(nombreDigimon));
        }
    }

    public void captura(Digimon digimon) {
        if (digimon.healthPoints <= 20) {
            if (equipo.size() < MAX_EQUIPO) {
                equipo.add(digimon);
                System.out.println(digimon.name + " se ha unido a su equipo.");
            } else {
                System.out.println("El equipo ya está completo.");
            }
        } else {
            System.out.println("No se puede unir. Salud del Digimon es superior a 20.");
        }
    }
}
