package application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Medecin {
    private SimpleStringProperty nom;
    private SimpleStringProperty specialite;
    private SimpleIntegerProperty id;
  
    public Medecin(String nom, String specialite, int id) {
        this.nom = new SimpleStringProperty(nom);
        this.specialite = new SimpleStringProperty(specialite);
        this.id = new SimpleIntegerProperty(id);
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public SimpleStringProperty specialiteProperty() {
        return specialite;
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

    public String getSpecialite() {
        return specialite.get();
    }

    public void setSpecialite(String specialite) {
        this.specialite.set(specialite);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
