package com.ambulance;

import java.util.*;
import com.ambulance.exceptions.*;

public class EmergencyManager {

    private PriorityQueue<Emergency> waitingQueue =
        new PriorityQueue<>(
            Comparator.comparingInt(
                e -> e.getEmergencyType().getPriority()
            )
        );

    private List<Emergency> history = new ArrayList<>();

    public void addEmergency(Emergency emergency)
            throws InvalidEmergencyException {

        if (emergency.getPatientId() == null ||
            emergency.getPatientId().isEmpty()) {

            throw new InvalidEmergencyException(
                "Invalid Patient ID"
            );
        }

        waitingQueue.add(emergency);
        history.add(emergency);

        System.out.println(
            "Emergency request added for Patient "
            + emergency.getPatientId()
        );
    }

    public void dispatch(AmbulanceManager manager)
            throws AmbulanceUnavailableException {

        if (waitingQueue.isEmpty()) {
            System.out.println("No waiting emergencies.");
            return;
        }

        Emergency emergency = waitingQueue.peek();

        Ambulance ambulance =
            manager.findAmbulance(emergency);

        if (ambulance == null) {
            throw new AmbulanceUnavailableException(
                "No ambulance currently available."
            );
        }

        waitingQueue.poll();

        ambulance.setState(AmbulanceState.DISPATCHED);

        emergency.setAmbulance(ambulance);
        emergency.setEmergencyStatus("DISPATCHED");

        System.out.println(
            "Ambulance " + ambulance.getAmbulanceId()
            + " assigned to Patient "
            + emergency.getPatientId()
        );

        double eta = ambulance.getDistance() * 2;

        System.out.println(
            "Estimated Arrival Time: "
            + eta + " minutes"
        );
    }

    public void displayHistory() {

        System.out.println("\nEmergency History:");

        for (Emergency e : history) {

            System.out.println(
                e.getPatientId() + " | "
                + e.getEmergencyType() + " | "
                + e.getEmergencyStatus()
            );
        }
    }
}
