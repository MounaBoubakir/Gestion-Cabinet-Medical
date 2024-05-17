package application;

import java.util.ArrayList;
import java.util.List;

public class DossierMedical extends FichierMedical {
    private List<Consultation> consultations;

    public DossierMedical(int patientId, String medicalHistory, String surgicalHistory, String allergies) {
        super(patientId, medicalHistory, surgicalHistory, allergies);
        this.consultations = new ArrayList<>();
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    public List<Consultation> getConsultations() { return consultations; }
}
