package com.ambulance;

public class Ambulance {

    private String ambulanceId;
    private AmbulanceType type;
    private AmbulanceState state;
    private String driverName;
    private double distance;

    public Ambulance(String ambulanceId,
                     AmbulanceType type,
                     String driverName,
                     double distance) {

        this.ambulanceId = ambulanceId;
        this.type = type;
        this.driverName = driverName;
        this.distance = distance;
        this.state = AmbulanceState.AVAILABLE;
    }

    public String getAmbulanceId() {
        return ambulanceId;
    }

    public AmbulanceType getType() {
        return type;
    }

    public AmbulanceState getState() {
        return state;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getDistance() {
        return distance;
    }

    public void setState(AmbulanceState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ambulanceId + " | " + type +
               " | Driver: " + driverName +
               " | Distance: " + distance +
               " km | State: " + state;
    }
}
