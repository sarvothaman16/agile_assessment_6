package com.ambulance;

import java.util.*;

public class AmbulanceManager {

    private List<Ambulance> ambulances = new ArrayList<>();

    public void addAmbulance(Ambulance ambulance) {
        ambulances.add(ambulance);
    }

    public Ambulance findAmbulance(Emergency emergency) {

        Ambulance best = null;

        for (Ambulance a : ambulances) {

            if (a.getState() != AmbulanceState.AVAILABLE)
                continue;

            if (best == null) {
                best = a;
            } else if (a.getDistance() < best.getDistance()) {
                best = a;
            }
        }

        return best;
    }

    public void displayAmbulances() {

        for (Ambulance a : ambulances) {
            System.out.println(a);
        }
    }
}
