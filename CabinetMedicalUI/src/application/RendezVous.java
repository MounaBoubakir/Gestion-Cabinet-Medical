package application;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.beans.property.*;

public class RendezVous {
	//ici jai utilisee ObjectProperty pour que je fait la lisaison avec javafx sans ls erreurs que javais avant
    private ObjectProperty<Medecin> doctor;
    private ObjectProperty<Patient> patient;
    private ObjectProperty<LocalDate> date;
    private ObjectProperty<LocalTime> time;
    private StringProperty status;
    private StringProperty reason;

    public RendezVous(Medecin doctor, Patient patient, LocalDate date, LocalTime time, String status, String reason) {
        this.doctor = new SimpleObjectProperty<>(doctor);
        this.patient = new SimpleObjectProperty<>(patient);
        this.date = new SimpleObjectProperty<>(date);
        this.time = new SimpleObjectProperty<>(time);
        this.status = new SimpleStringProperty(status);
        this.reason = new SimpleStringProperty(reason);
    }

   
	// Getters et setters
    public Medecin getDoctor() {
        return doctor.get();
    }

    public void setDoctor(Medecin doctor) {
        this.doctor.set(doctor);
    }

    public Patient getPatient() {
        return patient.get();
    }

    public void setPatient(Patient patient) {
        this.patient.set(patient);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public LocalTime getTime() {
        return time.get();
    }

    public void setTime(LocalTime time) {
        this.time.set(time);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getReason() {
        return reason.get();
    }

    public void setReason(String reason) {
        this.reason.set(reason);
    }

    // pr ls prorprety
    public ObjectProperty<Medecin> doctorProperty() {
        return doctor;
    }

    public ObjectProperty<Patient> patientProperty() {
        return patient;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public ObjectProperty<LocalTime> timeProperty() {
        return time;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty reasonProperty() {
        return reason;
    }
}

