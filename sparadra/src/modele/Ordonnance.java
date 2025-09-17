package modele;

import utilitaires.DateTimePaternFr;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ordonnance implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final List<Ordonnance> ORDONNANCES = new ArrayList<>();

    private Medecin medecin;
    private Client client;
    private Medicament medicament;
    private LocalDate dateOrdonnance;


    public Ordonnance(Medecin medecin, Client client, Medicament medicament, LocalDate dateOrdonnance) {
        this.medecin = medecin;
        this.client = client;
        this.medicament = medicament;
        this.dateOrdonnance = dateOrdonnance;
    }


    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public LocalDate getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(LocalDate dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getDateOrdonnanceFormatee() {
        return DateTimePaternFr.formatDate(dateOrdonnance, "dd/MM/yyyy");
    }

    // --- Méthodes utilitaires ---
    public static void ajouterOrdonnance(Ordonnance ordonnance) {
        ORDONNANCES.add(ordonnance);
    }

    public static List<Ordonnance> getToutesLesOrdonnances() {
        return new ArrayList<>(ORDONNANCES);
    }

    @Override
    public String toString() {
        return "Ordonnance {" +
                "Médecin = " + medecin +
                ", Client = " + client +
                ", Médicament = " + medicament +
                ", Date = " + getDateOrdonnanceFormatee() +
                '}';
    }
}
