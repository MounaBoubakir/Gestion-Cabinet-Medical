package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Patient {
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private DoubleProperty telephone;
    private SimpleStringProperty adress;
    private SimpleIntegerProperty id;
    
    public Patient(String nom, String prenom, double telephone, String adress,int id) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.telephone = new SimpleDoubleProperty(telephone);
        this.adress = new SimpleStringProperty(adress);
        this.id = new SimpleIntegerProperty(id);
    }

    
    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public DoubleProperty telephoneProperty() {
        return telephone;
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public double getTelephone() {
        return telephone.get();
    }

    public void setTelephone(double telephone) {
        this.telephone.set(telephone);
    }

    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }
    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
}
