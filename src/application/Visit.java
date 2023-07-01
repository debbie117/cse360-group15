package application;

import java.time.LocalDateTime;

public class Visit {
    private Patient patient;
    private Doctor doctor;
    private Nurse nurse;
    private LocalDateTime visitDateTime;

    // Constructor
    public Visit(Patient patient, Doctor doctor, Nurse nurse, LocalDateTime visitDateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.nurse = nurse;
        this.visitDateTime = visitDateTime;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public LocalDateTime getVisitDateTime() {
        return visitDateTime;
    }

    // Setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public void setVisitDateTime(LocalDateTime visitDateTime) {
        this.visitDateTime = visitDateTime;
    }
}
