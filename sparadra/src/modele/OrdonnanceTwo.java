package modele;

import utilitaires.DateTimePaternFr;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdonnanceTwo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final List<OrdonnanceTwo> ORDONNANCE_TWOS = new ArrayList<>();

    private Medecin medecin;
    private Client client;
    private List<Prescription> prescriptions; // Liste des prescriptions (médicament + quantité)
    private LocalDate dateOrdonnance;
    private String statut; // "En cours", "Délivrée", "Annulée"

    // Constructeur avec une liste de prescriptions
    public OrdonnanceTwo(Medecin medecin, Client client, List<Prescription> prescriptions, LocalDate dateOrdonnance) {
        this.medecin = medecin;
        this.client = client;
        this.prescriptions = new ArrayList<>(prescriptions);
        this.dateOrdonnance = dateOrdonnance;
        this.statut = "En cours";
        ORDONNANCE_TWOS.add(this);
    }

    // Constructeur avec un seul médicament (rétrocompatibilité)
    public OrdonnanceTwo(Medecin medecin, Client client, Medicament medicament, int quantite, LocalDate dateOrdonnance) {
        this.medecin = medecin;
        this.client = client;
        this.prescriptions = new ArrayList<>();
        this.prescriptions.add(new Prescription(medicament.getNomMedicament(), quantite));
        this.dateOrdonnance = dateOrdonnance;
        this.statut = "En cours";
        ORDONNANCE_TWOS.add(this);
    }

    // Getters et Setters
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
        return new ArrayList<>(prescriptions);
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = new ArrayList<>(prescriptions);
    }

    public LocalDate getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(LocalDate dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDateOrdonnanceFormatee() {
        return DateTimePaternFr.formatDate(dateOrdonnance, "dd/MM/yyyy");
    }

    // Méthodes pour gérer les prescriptions
    public void ajouterPrescription(String nomMedicament, int quantite) {
        this.prescriptions.add(new Prescription(nomMedicament, quantite));
    }

    public void supprimerPrescription(String nomMedicament) {
        prescriptions.removeIf(p -> p.getNomMedicament().equals(nomMedicament));
    }

    public boolean contientMedicament(String nomMedicament) {
        return prescriptions.stream()
                .anyMatch(p -> p.getNomMedicament().equals(nomMedicament));
    }

    public int getQuantiteMedicament(String nomMedicament) {
        return prescriptions.stream()
                .filter(p -> p.getNomMedicament().equals(nomMedicament))
                .mapToInt(Prescription::getQuantite)
                .sum();
    }

    // Calcul du prix total de l'ordonnance
    public double calculerPrixTotal() {
        double total = 0.0;
        for (Prescription prescription : prescriptions) {
            for (Medicament med : Medicament.getMedicaments()) {
                if (med.getNomMedicament().equals(prescription.getNomMedicament())) {
                    total += med.getPrixMedicament() * prescription.getQuantite();
                    break;
                }
            }
        }
        return total;
    }

    // Vérification de la disponibilité des médicaments
    public boolean verifierDisponibilite() {
        for (Prescription prescription : prescriptions) {
            for (Medicament med : Medicament.getMedicaments()) {
                if (med.getNomMedicament().equals(prescription.getNomMedicament())) {
                    if (med.getQuantiteMedicament() < prescription.getQuantite()) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    // Délivrer l'ordonnance (retirer du stock)
    public boolean delivrerOrdonnance() {
        if (!verifierDisponibilite()) {
            return false;
        }

        for (Prescription prescription : prescriptions) {
            for (Medicament med : Medicament.getMedicaments()) {
                if (med.getNomMedicament().equals(prescription.getNomMedicament())) {
                    med.retirerDuStock(prescription.getQuantite());
                    break;
                }
            }
        }
        this.statut = "Délivrée";
        return true;
    }

    // Méthodes utilitaires statiques
    public static void ajouterOrdonnance(OrdonnanceTwo ordonnanceTwo) {
        ORDONNANCE_TWOS.add(ordonnanceTwo);
    }

    public static List<OrdonnanceTwo> getToutesLesOrdonnances() {
        return new ArrayList<>(ORDONNANCE_TWOS);
    }

    public static void setOrdonnances(List<OrdonnanceTwo> ordonnanceTwos) {
        ORDONNANCE_TWOS.clear();
        ORDONNANCE_TWOS.addAll(ordonnanceTwos);
    }

    // Recherche d'ordonnances
    public static List<OrdonnanceTwo> rechercherParClient(String nomClient) {
        List<OrdonnanceTwo> resultats = new ArrayList<>();
        for (OrdonnanceTwo ord : ORDONNANCE_TWOS) {
            if (ord.getClient().getNom().equalsIgnoreCase(nomClient.trim())) {
                resultats.add(ord);
            }
        }
        return resultats;
    }

    public static List<OrdonnanceTwo> rechercherParMedecin(String nomMedecin) {
        List<OrdonnanceTwo> resultats = new ArrayList<>();
        for (OrdonnanceTwo ord : ORDONNANCE_TWOS) {
            if (ord.getMedecin().getNom().equalsIgnoreCase(nomMedecin.trim())) {
                resultats.add(ord);
            }
        }
        return resultats;
    }

    public static List<OrdonnanceTwo> rechercherParStatut(String statut) {
        List<OrdonnanceTwo> resultats = new ArrayList<>();
        for (OrdonnanceTwo ord : ORDONNANCE_TWOS) {
            if (ord.getStatut().equalsIgnoreCase(statut.trim())) {
                resultats.add(ord);
            }
        }
        return resultats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdonnanceTwo {\n");
        sb.append("  Médecin: ").append(medecin.getNom()).append(" ").append(medecin.getPrenom()).append("\n");
        sb.append("  Client: ").append(client.getNom()).append(" ").append(client.getPrenom()).append("\n");
        sb.append("  Date: ").append(getDateOrdonnanceFormatee()).append("\n");
        sb.append("  Statut: ").append(statut).append("\n");
        sb.append("  Prescriptions:\n");
        for (Prescription p : prescriptions) {
            sb.append("    - ").append(p.getNomMedicament())
                    .append(" (quantité: ").append(p.getQuantite()).append(")\n");
        }
        sb.append("  Prix total: ").append(String.format("%.2f", calculerPrixTotal())).append("€\n");
        sb.append("}");
        return sb.toString();
    }
}