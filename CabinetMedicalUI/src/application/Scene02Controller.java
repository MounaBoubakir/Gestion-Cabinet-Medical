package application;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


public class Scene02Controller implements Initializable{

    @FXML
    private Button Doctors_btm;

    @FXML
    private TextField addmedcin_Id;

    @FXML
    private TextField addmedcin_nom;

    @FXML
    private ComboBox<String> addmedecin_fonc;

    @FXML
    private TextField addmedecin_spec;

    @FXML
    private TableColumn<Medecin, Integer> addmedtable_idmed;

    @FXML
    private TableColumn<Medecin, String> addmedtable_nommed;

    @FXML
    private TableColumn<Medecin, String> addmedtable_specmed;

    @FXML
    private TextField addpatient_adre;

    @FXML
    private TextField addpatient_alergie;

    @FXML
    private TextField addpatient_antece;

    @FXML
    private ComboBox<String> addpatient_fonctio;
  
    @FXML
    private TextField addpatient_id;

    @FXML
    private TextField addpatient_nom;

    @FXML
    private TextField addpatient_prenom;

    @FXML
    private TextField addpatient_teleph;

    @FXML
    private Button RendezVouss_btm;

    @FXML
    private Button close_btm;

    @FXML
    private Button dashbord_btm;

    @FXML
    private AnchorPane medcin_form;

    @FXML
    private AnchorPane patient_form;

    @FXML
    private Button patients_btm;

    @FXML
    private AnchorPane patienttable_form;

    @FXML
    private TableColumn<Patient,String> pattabe_adr;

    @FXML
    private TableColumn<?, ?> pattable_alergie;

    @FXML
    private TableColumn<?, ?> pattable_antece;

    @FXML
    private TableColumn<Patient,Integer> pattable_id;

    @FXML
    private TableColumn<Patient,String> pattable_nom;

    @FXML
    private TableColumn<Patient,String> pattable_prenom;

    @FXML
    private TableColumn<Patient, Double> pattable_teleph; 
    @FXML
    private Button record_btm;

    @FXML
    private AnchorPane tablemedc_form;
    @FXML
    private TableView<Medecin> tableView;
   @FXML
   private ObservableList<Medecin> medecins = FXCollections.observableArrayList(); // List to store doctors
   //rendez vous 
   @FXML
   private ComboBox<String> rendezvousbox;
   @FXML
   private TextField rendezdoctorid, rendezpatientid, rendeztime, rendezreason;
   @FXML
   private ComboBox<String> statusdoctor;
   @FXML
   private DatePicker rendezdate;
   @FXML
   private TableView<RendezVous> rendezvoustable;
   @FXML
   private TableColumn<RendezVous, LocalDate> daterendez;
   @FXML
   private TableColumn<RendezVous, LocalTime> timerendez;
   @FXML
   private TableColumn<RendezVous, Integer> doctrendez, patrendez;
   @FXML
   private TableColumn<RendezVous, String> statusrendez, reasonrendez;
   @FXML
   private AnchorPane appointment_form;
   @FXML
   private Button appointments_btm;
  //consultation 
   @FXML
   private ComboBox<String> consulfonction;

   @FXML
   private AnchorPane consultation_form;

   @FXML
   private TableView<Consultation> consultation_tab;
   @FXML
   private DatePicker dateconsul;
   @FXML
   private TextField diagno;

   @FXML
   private TableColumn<Consultation, String> diagtab;

   @FXML
   private TextField doctorconsul;

   @FXML
   private TableColumn<Consultation, Integer> doctorconsultab;
   @FXML
   private TableColumn<Consultation, Integer> paticonsultab;
   @FXML
   private TextField patientconsul;
   @FXML
   private TableColumn<Consultation, String> prescriptab;
   @FXML
   private TextField prescriptionconsul;
   @FXML
   private TableColumn<Consultation, String> symptab;
   @FXML
   private TextField symptoms;
   @FXML
   private TableColumn<Consultation, LocalDate> tabconsuldate;
   @FXML
   private Button Consul_btm;
   

 
   
   @FXML
   private void onAddButtonClick(ActionEvent event) {
       ajouterMedecin();  // Call the method to add a new doctor
   }

   
    
 
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == Doctors_btm) {
            medcin_form.setVisible(true);
            tablemedc_form.setVisible(true);
            patient_form.setVisible(false);
            patienttable_form.setVisible(false);
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            consultation_form.setVisible(false); // Hide consultation form
            consultation_tab.setVisible(false); // Hide consultation table
            Doctors_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
         
        	
   		 patients_btm.setStyle("-fx-background-color: transparent;");
   		appointments_btm.setStyle("-fx-background-color: transparent;");
   	    Consul_btm.setStyle("-fx-background-color: transparent;");
        } else if (event.getSource() == patients_btm) {
            patient_form.setVisible(true);
            patienttable_form.setVisible(true);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            appointment_form.setVisible(false);
          rendezvoustable.setVisible(false); 
          consultation_form.setVisible(false); // Hide consultation form
          consultation_tab.setVisible(false); // Hide consultation table
   
            
            patients_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
       		appointments_btm.setStyle("-fx-background-color: transparent;");
       		Consul_btm.setStyle("-fx-background-color: transparent;");
        } else if (event.getSource() == appointments_btm) {
            appointment_form.setVisible(true);
           rendezvoustable.setVisible(true); 
            patient_form.setVisible(false);
            patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(false); // Hide consultation form
            consultation_tab.setVisible(false); // Hide consultation table
         
            appointments_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            Consul_btm.setStyle("-fx-background-color: transparent;");
           
        }else if (event.getSource() == Consul_btm) {
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            patient_form.setVisible(false);
             patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(true); // Show consultation form
            consultation_tab.setVisible(true); // Show consultation table

            Consul_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            appointments_btm.setStyle("-fx-background-color: transparent;");
        }
    }

    public void close() {
    	System.exit(0);
    }
    private void initialize() {
      // Initialize
    	
    }

   
      

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Setup for Doctors
        ObservableList<String> doctorFunctionalities = FXCollections.observableArrayList("Add", "Update", "Delete", "none");
        addmedecin_fonc.setItems(doctorFunctionalities);
        addmedecin_fonc.valueProperty().addListener((obs, oldVal, newVal) -> handleAction(newVal));

        addmedtable_nommed.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        addmedtable_idmed.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        addmedtable_specmed.setCellValueFactory(cellData -> cellData.getValue().specialiteProperty());
        tableView.setItems(medecins);

        // Setup for Patients
        ObservableList<String> patientFunctionalities = FXCollections.observableArrayList("Add", "Update", "Delete","none");
        addpatient_fonctio.setItems(patientFunctionalities);
        addpatient_fonctio.valueProperty().addListener((obs, oldVal, newVal) -> handlePatientAction(newVal));

        pattable_nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        pattable_prenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        pattable_teleph.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty().asObject());
        pattabe_adr.setCellValueFactory(cellData -> cellData.getValue().adressProperty());
        patientTableView.setItems(patients);
        //rendez vous 
        rendezvousbox.setItems(FXCollections.observableArrayList("Add", "Update", "Delete","none"));
        statusdoctor.setItems(FXCollections.observableArrayList("Yes", "No"));
        initializeRendezVousTableColumns();
        //consultation 
        ObservableList<String> consultationFunctionalities = FXCollections.observableArrayList("Add", "Update", "Delete","none");
        consulfonction.setItems(consultationFunctionalities);
        consulfonction.valueProperty().addListener((obs, oldVal, newVal) -> handleConsultationAction());

        tabconsuldate.setCellValueFactory(new PropertyValueFactory<>("consultationDate"));
        doctorconsultab.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        paticonsultab.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        symptab.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        diagtab.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        prescriptab.setCellValueFactory(new PropertyValueFactory<>("prescription"));

        consultation_tab.setItems(FXCollections.observableArrayList());
    }
    //medecin

	private void handleAction(String action) {
	    switch (action) {
	        case "Add":
	            ajouterMedecin();
	            break;
	        case "Update":
	            updateMedecin();
	            break;
	        case "Delete":
	            deleteMedecin();
	            break;
	    }
	}
	
	 public void ajouterMedecin() {
		    String nom = addmedcin_nom.getText();
		    int id = Integer.parseInt(addmedcin_Id.getText());  // Convert ID to integer
		    String specialite = addmedecin_spec.getText();
		    if (medecins.stream().anyMatch(med -> med.getId() == id)) {
		        showAlert("Error", "A doctor with ID " + id + " already exists.");
		        return;
		    }

		    // Create a new Medecin object
		    Medecin newMedecin = new Medecin(nom, specialite, id);

		    // Add the new Medecin to the ObservableList
		    medecins.add(newMedecin);

		    System.out.println("Medecin ajouté" );  // to check if it works fr
		}
	 private void showAlert(String title, String content) {
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle(title);
		    alert.setHeaderText(null);
		    alert.setContentText(content);
		    alert.showAndWait();
		}
	private void updateMedecin() {
	    Medecin selected = tableView.getSelectionModel().getSelectedItem();
	    
	    if (selected != null) {
	        selected.setNom(addmedcin_nom.getText());
	        selected.setId(Integer.parseInt(addmedcin_Id.getText()));
	        selected.setSpecialite(addmedecin_spec.getText());
	        tableView.refresh();
	    }
	}

	private void deleteMedecin() {
	    int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        tableView.getItems().remove(selectedIndex);
	    }
	}
	@FXML
	private void handleCheckBox(ActionEvent event) {
	    // Call the handleAction method 
	    handleAction("CheckBox Action");
	}

	
	
	
	
  // patient part 
	    @FXML
	    private TableView<Patient> patientTableView;
	    @FXML
	    private ObservableList<Patient> patients = FXCollections.observableArrayList(); // List to store patients
	
	    


	    private void handlePatientAction(String action) {
	        switch (action) {
	            case "Add":
	                addPatient();
	                break;
	            case "Update":
	                updatePatient();
	                break;
	            case "Delete":
	                deletePatient();
	                break;
	        }
	    }

	    public void addPatient() {
	        // Retrieve data from the TextFields
	        String nom = addpatient_nom.getText();
	        String prenom = addpatient_prenom.getText();
	        double telephone = Double.parseDouble(addpatient_teleph.getText());  // Convert telephone to double
	        String adress = addpatient_adre.getText();
	        int id = Integer.parseInt(addpatient_id.getText());  // Convert ID to integer
	     // Check if the ID already exists
	        if (patients.stream().anyMatch(pat -> pat.getId() == id)) {
	            showAlert("Error", "A patient with ID " + id + " already exists.");
	            return;
	        }
	        // Create a new Patient object
	        Patient newPatient = new Patient(nom, prenom, telephone, adress, id);

	        // Add the new Patient to the ObservableList
	        patients.add(newPatient);

	        System.out.println("Patient ajouté");  
	    }

	    private void updatePatient() {
	        Patient selected = patientTableView.getSelectionModel().getSelectedItem();
	        if (selected != null) {
	            selected.setNom(addpatient_nom.getText());
	            selected.setPrenom(addpatient_prenom.getText());
	            selected.setTelephone(Double.parseDouble(addpatient_teleph.getText()));
	            selected.setAdress(addpatient_adre.getText());
	            patientTableView.refresh();
	        }
	    }
	    

	    private void deletePatient() {
	        int selectedIndex = patientTableView.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            patientTableView.getItems().remove(selectedIndex);
	        }
	    }
	    @FXML
		private void handleCheckBox2(ActionEvent event) {
		    // Call the handleAction method with the appropriate action
	    	handlePatientAction ("CheckBox Action");
		}
	   
	    //rendez vous 
	    private void initializeRendezVousTableColumns() {
	        daterendez.setCellValueFactory(new PropertyValueFactory<>("date"));
	        timerendez.setCellValueFactory(new PropertyValueFactory<>("time"));
	        doctrendez.setCellValueFactory(cellData -> cellData.getValue().getDoctor().idProperty().asObject());
	        patrendez.setCellValueFactory(cellData -> cellData.getValue().getPatient().idProperty().asObject());
	        statusrendez.setCellValueFactory(new PropertyValueFactory<>("status"));
	        reasonrendez.setCellValueFactory(new PropertyValueFactory<>("reason"));
	        
	        // Assuming you will populate this list elsewhere
	        rendezvoustable.setItems(FXCollections.observableArrayList());
	    }
	    @FXML
	    private void handleRendezVousAction() {
	        String selectedAction = rendezvousbox.getValue();
	        switch (selectedAction) {
	            case "Add":
	                handleAddRendezVous();
	                break;
	            case "Update":
	                handleUpdateRendezVous();
	                break;
	            case "Delete":
	                handleDeleteRendezVous();
	                break;
	        }
	    }
	    @FXML
	    private void handleAddRendezVous() {
	        try {
	            int doctorId = Integer.parseInt(rendezdoctorid.getText());
	            int patientId = Integer.parseInt(rendezpatientid.getText());
	            LocalDate date = rendezdate.getValue();
	            LocalTime time = LocalTime.parse(rendeztime.getText());
	            String status = statusdoctor.getValue();
	            String reason = rendezreason.getText();

	            Medecin doctor = findDoctorById(doctorId);
	            Patient patient = findPatientById(patientId);
	            RendezVous newRendezVous = new RendezVous(doctor, patient, date, time, status, reason);

	            rendezvoustable.getItems().add(newRendezVous);
	        } catch (NumberFormatException | DateTimeParseException e) {
	            System.out.println("Error: " + e.getMessage());
	            // Handle errors or display in UI
	        }
	    }
	    @FXML
	    private void handleUpdateRendezVous() {
	        RendezVous selectedRendezVous = rendezvoustable.getSelectionModel().getSelectedItem();
	        if (selectedRendezVous != null) {
	            try {
	                selectedRendezVous.setDoctor(findDoctorById(Integer.parseInt(rendezdoctorid.getText())));
	                selectedRendezVous.setPatient(findPatientById(Integer.parseInt(rendezpatientid.getText())));
	                selectedRendezVous.setDate(rendezdate.getValue());
	                selectedRendezVous.setTime(LocalTime.parse(rendeztime.getText()));
	                selectedRendezVous.setStatus(statusdoctor.getValue());
	                selectedRendezVous.setReason(rendezreason.getText());

	                rendezvoustable.refresh();  // Update the table view to show changes
	            } catch (NumberFormatException | DateTimeParseException e) {
	                System.out.println("Error: " + e.getMessage());
	                // Handle errors or display in UI
	            }
	        }
	    }
	    @FXML
	    private void handleDeleteRendezVous() {
	        int selectedIndex = rendezvoustable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            rendezvoustable.getItems().remove(selectedIndex);
	        } else {
	            System.out.println("No selection made");
	            // Optionally display this message to the user
	        }
	    }

	    private Medecin findDoctorById(int id) {
	        return medecins.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
	    }

	    private Patient findPatientById(int id) {
	        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	    }
	    
	    //consultation 
	    @FXML
	    private void handleConsultationAction() {
	        String selectedAction = consulfonction.getValue();
	        switch (selectedAction) {
	            case "Add":
	                handleAddConsultation();
	                break;
	            case "Update":
	                handleUpdateConsultation();
	                break;
	            case "Delete":
	                handleDeleteConsultation();
	                break;
	        }
	    }

	    @FXML
	    private void handleAddConsultation() {
	        try {
	            int doctorId = Integer.parseInt(doctorconsul.getText());
	            int patientId = Integer.parseInt(patientconsul.getText());
	            LocalDate date = dateconsul.getValue();
	            String symptomsText = symptoms.getText();
	            String diagnosisText = diagno.getText();
	            String prescriptionText = prescriptionconsul.getText();

	            // Check if both the doctor and the patient exist
	            if (!doctorExists(doctorId)) {
	                showAlert("Error", "No doctor found with ID: " + doctorId);
	                return;
	            }
	            if (!patientExists(patientId)) {
	                showAlert("Error", "No patient found with ID: " + patientId);
	                return;
	            }

	            // Create a new Consultation object
	            Consultation newConsultation = new Consultation(doctorId, patientId, symptomsText, "", diagnosisText, prescriptionText, date);
	            consultation_tab.getItems().add(newConsultation);
	            System.out.println("Consultation added successfully");
	        } catch (NumberFormatException e) {
	            showAlert("Error", "Invalid number format: " + e.getMessage());
	        }
	    }

	    // Method to check if a doctor exists
	    private boolean doctorExists(int id) {
	        return medecins.stream().anyMatch(doc -> doc.getId() == id);
	    }

	    // Method to check if a patient exists
	    private boolean patientExists(int id) {
	        return patients.stream().anyMatch(pat -> pat.getId() == id);
	    }

	    private void showAlertconsu(String title, String content) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }
	 // Method to check if a doctor exists
	    private boolean doctorExistsconsu(int id) {
	        return medecins.stream().anyMatch(doc -> doc.getId() == id);
	    }

	    // Method to check if a patient exists
	    private boolean patientExistsconsul(int id) {
	        return patients.stream().anyMatch(pat -> pat.getId() == id);
	    }

	    private void showAlertconsul(String title, String content) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }

	    @FXML
	    private void handleUpdateConsultation() {
	        Consultation selectedConsultation = consultation_tab.getSelectionModel().getSelectedItem();
	        if (selectedConsultation != null) {
	            try {
	                int doctorId = Integer.parseInt(doctorconsul.getText());
	                int patientId = Integer.parseInt(patientconsul.getText());
	                LocalDate date = dateconsul.getValue();
	                String symptomsText = symptoms.getText();
	                String diagnosisText = diagno.getText();
	                String prescriptionText = prescriptionconsul.getText();

	                selectedConsultation.setDoctorId(doctorId);
	                selectedConsultation.setPatientId(patientId);
	                selectedConsultation.setConsultationDate(date);
	                selectedConsultation.setSymptoms(symptomsText);
	                selectedConsultation.setDiagnosis(diagnosisText);
	                selectedConsultation.setPrescription(prescriptionText);

	                consultation_tab.refresh();  // Update the table view to show changes
	            } catch (NumberFormatException e) {
	                System.out.println("Error: " + e.getMessage());
	                // Handle errors or display in UI
	            }
	        }
	    }

	    @FXML
	    private void handleDeleteConsultation() {
	        int selectedIndex = consultation_tab.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            consultation_tab.getItems().remove(selectedIndex);
	        } else {
	            System.out.println("No selection made");
	            // Optionally display this message to the user
	        }
	    }
	    //fiche patient 
}
