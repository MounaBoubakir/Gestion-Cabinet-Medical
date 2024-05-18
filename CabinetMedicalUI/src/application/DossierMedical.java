package application;

public class DossierMedical {
    private String patientName;
    private String patientSurname;
    private String doctorName;
    private String medication;
    private String dose;
    private String duration;
    private String summary;

    public DossierMedical(String patientName, String patientSurname, String doctorName, String medication, String dose, String duration, String summary) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.doctorName = doctorName;
        this.medication = medication;
        this.dose = dose;
        this.duration = duration;
        this.summary = summary;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
