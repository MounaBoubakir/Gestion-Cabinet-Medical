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
   
   //fichier 
   @FXML
   private TableView<FichierMedical> fichierTable;

   @FXML
   private TableColumn<?, ?> nomfich;

   @FXML
   private TableColumn<?, ?> prenomfich;

   @FXML
   private TableColumn<?, ?> agefich;

   @FXML
   private TableColumn<?, ?> poidfich;

   @FXML
   private TableColumn<?, ?> hautfich;

   @FXML
   private TableColumn<?, ?> medichifich;

   @FXML
   private TableColumn<?, ?> surgicfich;

   @FXML
   private TableColumn<?, ?> allergiefich;

   @FXML
   private TableColumn<?, ?> idfich;

   @FXML
   private TextField nameField;

   @FXML
   private TextField surnameField;

   @FXML
   private TextField ageField;

   @FXML
   private TextField weightField;

   @FXML
   private TextField heightField;

   @FXML
   private TextField medicalHistoryField;

   @FXML
   private TextField surgicalHistoryField;

   @FXML
   private TextField allergiesField;

   @FXML
   private TextField idFichierField;

   @FXML
   private ComboBox<String> fichierFonction;

   @FXML
   private Button fichier_btm;

   @FXML
   private AnchorPane fichier_form;
   @FXML
   private AnchorPane dossier_form;
   @FXML
   private Button Dossier_btm;
//Switch form -pour que je regle la visibilitee de chaque partie 
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == Doctors_btm) {
            medcin_form.setVisible(true);
            tablemedc_form.setVisible(true);
            patient_form.setVisible(false);
            patienttable_form.setVisible(false);
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            consultation_form.setVisible(false); 
            consultation_tab.setVisible(false); 
            dossierTableView.setVisible(false);
            dossier_form.setVisible(false);
            Doctors_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
         
        	
   		 patients_btm.setStyle("-fx-background-color: transparent;");
   		appointments_btm.setStyle("-fx-background-color: transparent;");
   	    Consul_btm.setStyle("-fx-background-color: transparent;");
   	    Dossier_btm.setStyle("-fx-background-color: transparent;");
        } else if (event.getSource() == patients_btm) {
            patient_form.setVisible(true);
            patienttable_form.setVisible(true);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            appointment_form.setVisible(false);
          rendezvoustable.setVisible(false); 
          consultation_form.setVisible(false);
          consultation_tab.setVisible(false); 
          fichier_form.setVisible(false); 
          fichierTable.setVisible(false);
          dossierTableView.setVisible(false);
          dossier_form.setVisible(false);
            
            patients_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            fichier_btm.setStyle("-fx-background-color: transparent;");
       	    Dossier_btm.setStyle("-fx-background-color: transparent;");

       		appointments_btm.setStyle("-fx-background-color: transparent;");
       		Consul_btm.setStyle("-fx-background-color: transparent;");
        } else if (event.getSource() == appointments_btm) {
            appointment_form.setVisible(true);
           rendezvoustable.setVisible(true); 
            patient_form.setVisible(false);
            patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(false); 
            consultation_tab.setVisible(false); 
            fichier_form.setVisible(false); 
            fichierTable.setVisible(false); 
            dossierTableView.setVisible(false);
            dossier_form.setVisible(false);
            
            appointments_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            Consul_btm.setStyle("-fx-background-color: transparent;");
            fichier_btm.setStyle("-fx-background-color: transparent;");
       	    Dossier_btm.setStyle("-fx-background-color: transparent;");

        }else if (event.getSource() == Consul_btm) {
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            patient_form.setVisible(false);
             patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(true); 
            consultation_tab.setVisible(true); 
            fichier_form.setVisible(false); 
            fichierTable.setVisible(false);
            dossierTableView.setVisible(false);
            dossier_form.setVisible(false);
            
            Consul_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            appointments_btm.setStyle("-fx-background-color: transparent;");
            fichier_btm.setStyle("-fx-background-color: transparent;");
       	    Dossier_btm.setStyle("-fx-background-color: transparent;");

        }else if (event.getSource() == fichier_btm) {
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            patient_form.setVisible(false);
             patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(false); 
            consultation_tab.setVisible(false); 
            fichier_form.setVisible(true); 
            fichierTable.setVisible(true);
            dossierTableView.setVisible(false);
            dossier_form.setVisible(false);
            
            Consul_btm.setStyle("-fx-background-color: transparent;");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            appointments_btm.setStyle("-fx-background-color: transparent;");
            fichier_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");
       	    Dossier_btm.setStyle("-fx-background-color: transparent;");

        }else if (event.getSource() ==Dossier_btm ) {
            appointment_form.setVisible(false);
            rendezvoustable.setVisible(false); 
            patient_form.setVisible(false);
             patienttable_form.setVisible(false);
            medcin_form.setVisible(false);
            tablemedc_form.setVisible(false);
            consultation_form.setVisible(false);
            consultation_tab.setVisible(false); 
            fichier_form.setVisible(false); 
            fichierTable.setVisible(false);
            dossierTableView.setVisible(true);
            dossier_form.setVisible(true);
            
            Consul_btm.setStyle("-fx-background-color: transparent;");
            Doctors_btm.setStyle("-fx-background-color: transparent;");
            patients_btm.setStyle("-fx-background-color: transparent;");
            appointments_btm.setStyle("-fx-background-color: transparent;");
            fichier_btm.setStyle("-fx-background-color: transparent;");
       	    Dossier_btm.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #8e44ad);");

        }
    }
//pour fermee l'ongle du l application
    public void close() {
    	System.exit(0);
    }
  

//ici la method intilize elle intilize tous dans le code 
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Medecin
        ObservableList<String> doctorFunctionalities = FXCollections.observableArrayList("Add", "Update", "Delete", "none");
        addmedecin_fonc.setItems(doctorFunctionalities);
        addmedecin_fonc.valueProperty().addListener((obs, oldVal, newVal) -> handleAction(newVal));

        addmedtable_nommed.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        addmedtable_idmed.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        addmedtable_specmed.setCellValueFactory(cellData -> cellData.getValue().specialiteProperty());
        tableView.setItems(medecins);

        // patient
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
        //fichier medical 
        fichierFonction.setItems(FXCollections.observableArrayList("Add", "Update", "Delete","none"));
        initializefichierTableColumns();
        //dossier medical
        dossierFunctionComboBox.setItems(FXCollections.observableArrayList("Add Dossier", "Update Dossier", "Delete Dossier", "Generate Certificate"));
        dossierFunctionComboBox.valueProperty().addListener((obs, oldVal, newVal) -> handleDossierAction(newVal));

        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("patientSurname"));
        doctorNameColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        medicationColumn.setCellValueFactory(new PropertyValueFactory<>("medication"));
        doseColumn.setCellValueFactory(new PropertyValueFactory<>("dose"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));

        dossierTableView.setItems(dossiers);
    }
    //Ici vous trouverez les methode associee a chaque partie 
    //1-Medecin

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

		    // Cree un nv objet 
		    Medecin newMedecin = new Medecin(nom, specialite, id);

		    // l'ajouter dans observ list (utilisee car elle semble d'une base de donnee)
		    medecins.add(newMedecin);

		    System.out.println("Medecin ajouté" );  // pour sassurer quil fait l ajout 
		}
	 //en cas d'erreur- ajouter un ID qui exist deja 
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
	    handleAction("CheckBox Action");
	}

	
	
	
	
  // patient part 
	    @FXML
	    private TableView<Patient> patientTableView;
	    @FXML
	    private ObservableList<Patient> patients = FXCollections.observableArrayList(); 

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
	        //pour que je puisse avoir les champs.
	        String nom = addpatient_nom.getText();
	        String prenom = addpatient_prenom.getText();
	        double telephone = Double.parseDouble(addpatient_teleph.getText());  // Convert tlphn a double
	        String adress = addpatient_adre.getText();
	        int id = Integer.parseInt(addpatient_id.getText());  // Convert ID a int
	     // pour verifier si l ID exist si oui erreur -id toujeur unique
	        if (patients.stream().anyMatch(pat -> pat.getId() == id)) {
	            showAlert("Error", "A patient with ID " + id + " already exists.");
	            return;
	        }
	        // creation d'un nv objet
	        Patient newPatient = new Patient(nom, prenom, telephone, adress, id);
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

	                rendezvoustable.refresh(); 
	            } catch (NumberFormatException | DateTimeParseException e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	    @FXML
	    private void handleDeleteRendezVous() {
	        int selectedIndex = rendezvoustable.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            rendezvoustable.getItems().remove(selectedIndex);
	        } else {
	            System.out.println("No selection made");//just pour assuree
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

	            // Check si patient et medecin vraimenet exist
	            if (!doctorExists(doctorId)) {
	                showAlert("Error", "No doctor found with ID: " + doctorId);
	                return;
	            }
	            if (!patientExists(patientId)) {
	                showAlert("Error", "No patient found with ID: " + patientId);
	                return;
	            }

	            // un nv consul objet
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
	        }
	    }
	    
	    
	    //fiche patient
	    private void initializefichierTableColumns() {
	        nomfich.setCellValueFactory(new PropertyValueFactory<>("name"));
	        prenomfich.setCellValueFactory(new PropertyValueFactory<>("surname"));
	        agefich.setCellValueFactory(new PropertyValueFactory<>("age"));
	        poidfich.setCellValueFactory(new PropertyValueFactory<>("weight"));
	        hautfich.setCellValueFactory(new PropertyValueFactory<>("height"));
	        medichifich.setCellValueFactory(new PropertyValueFactory<>("medicalHistory"));
	        surgicfich.setCellValueFactory(new PropertyValueFactory<>("surgicalHistory"));
	        allergiefich.setCellValueFactory(new PropertyValueFactory<>("allergies"));
	        idfich.setCellValueFactory(new PropertyValueFactory<>("patientId"));

	        ObservableList<FichierMedical> fichierData = FXCollections.observableArrayList();

	        fichierTable.setItems(fichierData);
	    }
	    @FXML
	    private void handleAddFichier(ActionEvent event) {
	        try {
	            int patientId = Integer.parseInt(idFichierField.getText().trim());
	            String name = nameField.getText().trim();
	            String surname = surnameField.getText().trim();
	            int age = Integer.parseInt(ageField.getText().trim());
	            double weight = Double.parseDouble(weightField.getText().trim());
	            double height = Double.parseDouble(heightField.getText().trim());
	            String medicalHistory = medicalHistoryField.getText().trim();
	            String surgicalHistory = surgicalHistoryField.getText().trim();
	            String allergies = allergiesField.getText().trim();

	            FichierMedical fichier = new FichierMedical(patientId, name, surname, age, weight, height,
	                medicalHistory, surgicalHistory, allergies);

	            ObservableList<FichierMedical> data = fichierTable.getItems();
	            data.add(fichier);

	            showAlert3("Success", "Fichier Medical ajoutee.");//just pr assuree 
	        } catch (NumberFormatException e) {
	            showAlert3("Error", "Format invalide.Essauyee");
	        }
	    }
	    @FXML
	    private void handleUpdateFichier(ActionEvent event) {
	        FichierMedical selected = fichierTable.getSelectionModel().getSelectedItem();
	        if (selected != null) {
	            try {
	                selected.setName(nameField.getText());
	                selected.setSurname(surnameField.getText());
	                selected.setAge(Integer.parseInt(ageField.getText()));
	                selected.setWeight(Double.parseDouble(weightField.getText()));
	                selected.setHeight(Double.parseDouble(heightField.getText()));
	                selected.setMedicalHistory(medicalHistoryField.getText());
	                selected.setSurgicalHistory(surgicalHistoryField.getText());
	                selected.setAllergies(allergiesField.getText());

	                fichierTable.refresh();
	                showAlert3("Success", "Fichier Medical Modifier.");
	            } catch (NumberFormatException e) {
	                showAlert3("Error", "Invalid format,essayee.");
	            }
	        } else {
	            showAlert3("Error", "No Fichier Medical selected.");
	        }
	    }
	    @FXML
	    private void handleDeleteFichier(ActionEvent event) {
	        FichierMedical selected = fichierTable.getSelectionModel().getSelectedItem();
	        if (selected != null) {
	            fichierTable.getItems().remove(selected);
	            showAlert3("Success", "Fichier Medical deleted successfully.");
	        } else {
	            showAlert3("Error", "No Fichier Medical selected for deletion.");
	        }
	    }
	    private void showAlert3(String title, String content) {
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }
	    @FXML
	    private void handleFichierAction(ActionEvent event) {
	        String selectedAction = fichierFonction.getValue();
	        switch (selectedAction) {
	            case "Add":
	                handleAddFichier(new ActionEvent());
	                break;
	            case "Update":
	                handleUpdateFichier(new ActionEvent());
	                break;
	            case "Delete":
	                handleDeleteFichier(new ActionEvent());
	                break;
	        }
	        fichierFonction.getSelectionModel().clearSelection(); // Optional: clear selection after action
	    }

//dossier medical 
	    @FXML
	    private TextField patientNameField;
	    @FXML
	    private TextField patientSurnameField;
	    @FXML
	    private TextField doctorNameField;
	    @FXML
	    private TextField medicationField;
	    @FXML
	    private TextField doseField;
	    @FXML
	    private TextField durationField;
	    @FXML
	    private TextField summaryField;
	    @FXML
	    private ComboBox<String> dossierFunctionComboBox;
	    @FXML
	    private TableView<DossierMedical> dossierTableView;
	    @FXML
	    private TableColumn<DossierMedical, String> patientNameColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> patientSurnameColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> doctorNameColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> medicationColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> doseColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> durationColumn;
	    @FXML
	    private TableColumn<DossierMedical, String> summaryColumn;
	    @FXML
	    private Button generateCertificateButton;

	    private ObservableList<DossierMedical> dossiers = FXCollections.observableArrayList();
	    @FXML
	    private void handleDossierAction(String newVal) {
	        String selectedAction = dossierFunctionComboBox.getValue();
	        switch (selectedAction) {
	            case "Add Dossier":
	                handleAddDossier();
	                break;
	            case "Update Dossier":
	                handleUpdateDossier();
	                break;
	            case "Delete Dossier":
	                handleDeleteDossier();
	                break;
	            case "Generate Certificate":
	                handleGenerateCertificate();
	                break;
	        }
	    }

	    @FXML
	    private void handleAddDossier() {
	        String patientName = patientNameField.getText();
	        String patientSurname = patientSurnameField.getText();
	        String doctorName = doctorNameField.getText();
	        String medication = medicationField.getText();
	        String dose = doseField.getText();
	        String duration = durationField.getText();
	        String summary = summaryField.getText();

	        if (!patientExistsByName(patientName, patientSurname)) {
	            showAlert("Error", "Patient with the name " + patientName + " " + patientSurname + " does not exist.");
	            return;
	        }

	        if (!doctorExistsByName(doctorName)) {
	            showAlert("Error", "Doctor with the name " + doctorName + " does not exist.");
	            return;
	        }

	        DossierMedical newDossier = new DossierMedical(patientName, patientSurname, doctorName, medication, dose, duration, summary);
	        dossiers.add(newDossier);
	        dossierTableView.setItems(dossiers);

	        clearDossierFields();
	    }


	    @FXML
	    private void handleUpdateDossier() {
	        DossierMedical selectedDossier = dossierTableView.getSelectionModel().getSelectedItem();
	        if (selectedDossier != null) {
	            selectedDossier.setPatientName(patientNameField.getText());
	            selectedDossier.setPatientSurname(patientSurnameField.getText());
	            selectedDossier.setDoctorName(doctorNameField.getText());
	            selectedDossier.setMedication(medicationField.getText());
	            selectedDossier.setDose(doseField.getText());
	            selectedDossier.setDuration(durationField.getText());
	            selectedDossier.setSummary(summaryField.getText());

	            dossierTableView.refresh();
	            clearDossierFields();
	        } else {
	            showAlert("Error", "No dossier selected.");
	        }
	    }

	    @FXML
	    private void handleDeleteDossier() {
	        int selectedIndex = dossierTableView.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            dossiers.remove(selectedIndex);
	            clearDossierFields();
	        } else {
	            showAlert("Error", "No dossier selected for deletion.");
	        }
	    }

	    @FXML
	    private void handleGenerateCertificate() {
	        DossierMedical selectedDossier = dossierTableView.getSelectionModel().getSelectedItem();
	        if (selectedDossier != null) {
	            String certificate = "Certificate: " + selectedDossier.getPatientName() + " " +
	                    selectedDossier.getPatientSurname() + ", Doctor: " + selectedDossier.getDoctorName() +
	                    ", Medication: " + selectedDossier.getMedication() + ", Dose: " + selectedDossier.getDose() +
	                    ", Duration: " + selectedDossier.getDuration() + ", Summary: " + selectedDossier.getSummary();
	            System.out.println(certificate);
	        } else {
	            showAlert("Error", "No dossier selected for certificate generation.");
	        }
	    }

	    private void clearDossierFields() {
	        patientNameField.clear();
	        patientSurnameField.clear();
	        doctorNameField.clear();
	        medicationField.clear();
	        doseField.clear();
	        durationField.clear();
	        summaryField.clear();
	    }
	    private boolean patientExistsByName(String name, String surname) {
	        return patients.stream().anyMatch(p -> p.getNom().equals(name) && p.getPrenom().equals(surname));
	    }

	    private boolean doctorExistsByName(String name) {
	        return medecins.stream().anyMatch(d -> d.getNom().equals(name));
	    }
//retour btmn 
	    @FXML
	    private Button returnButton; 

	    private Stage stage;
	    private Scene scene;

	    @FXML
	    public void switchToScene1(ActionEvent event) throws IOException {
	        Parent root = FXMLLoader.load(getClass().getResource("scene01.fxml"));
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
}
//fin