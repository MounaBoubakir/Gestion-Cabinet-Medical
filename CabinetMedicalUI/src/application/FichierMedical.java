package application;

public class FichierMedical {
    private int patientId;
    private String medicalHistory;
    private String surgicalHistory;
    private String allergies;

    public FichierMedical(int patientId, String medicalHistory, String surgicalHistory, String allergies) {
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.surgicalHistory = surgicalHistory;
        this.allergies = allergies;
    }

    // Getters and Setters
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    public String getSurgicalHistory() { return surgicalHistory; }
    public void setSurgicalHistory(String surgicalHistory) { this.surgicalHistory = surgicalHistory; }
    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }
}
