package paquete;

import java.util.ArrayList;
import java.util.Random;

/**
 * La clase Domador representa a un domador de Digimon con un equipo de hasta 3 Digimon.
 */
public class Domador {
    String nombre;
    ArrayList<Digimon> equipo;
    final int MAX_EQUIPO = 3;

    /**
     * Constructor para inicializar un domador con un nombre y un Digimon aleatorio.
     * @param nombre Nombre del domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        Random rand = new Random();
        String[] nombres = {"Agumon", "Gabumon", "Patamon"};
        String nombreDigimon = nombres[rand.nextInt(nombres.length)];
        this.equipo.add(new Digimon(nombreDigimon));
    }

    /**
     * Captura un Digimon si su salud es 20 o menor y si el equipo no está completo.
     * @param digimon Digimon a capturar.
     */
    public void captura(Digimon digimon) {
        if (digimon.healthPoints <= 20) {
            if (equipo.size() < MAX_EQUIPO) {
                equipo.add(digimon);
                System.out.println(digimon.name + " se ha unido a su equipo.");
                if (equipo.size() == MAX_EQUIPO) {
                    System.out.println("¡Felicidades! Has capturado los 3 Digimon icónicos: Agumon, Gabumon y Patamon, y completaste la Digivice.");
                }
            } else {
                System.out.println("El equipo ya está completo.");
            }
        } else {
            System.out.println("No se puede unir. Salud del Digimon es superior a 20.");
        }
    }

    /**
     * Obtiene los nombres de los Digimon en el equipo del domador.
     * @return Lista de nombres de los Digimon en el equipo.
     */
    public ArrayList<String> nombresDeDigimon() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Digimon digimon : equipo) {
            nombres.add(digimon.name);
        }
        return nombres;
    }
}
