package modele;

import utilitaires.DateTimePaternFr;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordonnance implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final List<Ordonnance> ordonnances = new ArrayList<>();

    private Medecin medecin;
    private Client client;
    private List<Prescription> prescriptions;
    private LocalDate dateOrdonnance;

    public Ordonnance(Medecin medecin, Client client, List<Prescription> prescriptions, LocalDate dateOrdonnance) {
        this.medecin = medecin;
        this.client = client;
        this.prescriptions = prescriptions != null ? new ArrayList<>(prescriptions) : new ArrayList<>();
        this.dateOrdonnance = dateOrdonnance;
        ordonnances.add(this);
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

    public List<Prescription> getPrescriptions() {
        return Collections.unmodifiableList(prescriptions);
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions != null ? new ArrayList<>(prescriptions) : new ArrayList<>();
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


    public static void ajouterOrdonnance(Ordonnance ordonnance) {
        if (ordonnance != null) {
            ordonnances.add(ordonnance);
        }
    }

    public static List<Ordonnance> getToutesLesOrdonnances() {
        return Collections.unmodifiableList(ordonnances);
    }

    @Override
    public String toString() {
        String prescriptionsStr = "";
        for (Prescription p : prescriptions) {
            prescriptionsStr += "\n    - " + p.toString();
        }

        return "Ordonnance {\n" +
                "  Médecin      = " + medecin + "\n" +
                "  Client       = " + client + ",\n" +
                "  Date         = " + getDateOrdonnanceFormatee() + ",\n" +
                "  Prescriptions =" + prescriptionsStr + "\n" +
                "}";
    }
}
