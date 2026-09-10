package com.ambulance;

public class Emergency {

    private String patientId;
    private EmergencyType emergencyType;
    private String pickupLocation;
    private String destinationHospital;
    private String emergencyStatus;
    private Ambulance ambulance;

    public Emergency(String patientId,
                     EmergencyType emergencyType,
                     String pickupLocation,
                     String destinationHospital) {

        this.patientId = patientId;
        this.emergencyType = emergencyType;
        this.pickupLocation = pickupLocation;
        this.destinationHospital = destinationHospital;
        this.emergencyStatus = "WAITING";
    }

    public String getPatientId() {
        return patientId;
    }

    public EmergencyType getEmergencyType() {
        return emergencyType;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestinationHospital() {
        return destinationHospital;
    }

    public String getEmergencyStatus() {
        return emergencyStatus;
    }

    public void setEmergencyStatus(String status) {
        this.emergencyStatus = status;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public Ambulance getAmbulance() {
        return ambulance;
    }
}
