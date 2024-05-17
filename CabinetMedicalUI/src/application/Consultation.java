package application;

import java.time.LocalDate;

public class Consultation {
    private int doctorId;
    private int patientId;
    private String symptoms;
    private String medicalHistory;
    private String diagnosis;
    private String prescription;
    private LocalDate consultationDate;

    public Consultation(int doctorId, int patientId, String symptoms, String medicalHistory, String diagnosis, String prescription, LocalDate consultationDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.symptoms = symptoms;
        this.medicalHistory = medicalHistory;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.consultationDate = consultationDate;
    }

    // Getters and setters
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public LocalDate getConsultationDate() { return consultationDate; }
    public void setConsultationDate(LocalDate consultationDate) { this.consultationDate = consultationDate; }
}
