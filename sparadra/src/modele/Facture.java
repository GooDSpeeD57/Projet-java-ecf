package modele;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final List<Facture> factures = new ArrayList<>();

    private String numeroFacture;
    private Client client;
    private List<Prescription> prescriptions;
    private LocalDate dateFacture;
    private double montantTotal;
    private boolean payee;

    public Facture(String numeroFacture, Client client, List<Prescription> prescriptions, LocalDate dateFacture) {
        this.numeroFacture = numeroFacture;
        this.client = client;
        this.prescriptions = new ArrayList<>(prescriptions);
        this.dateFacture = dateFacture;
        this.montantTotal = calculerMontantTotal();
        this.payee = false;
        factures.add(this);
    }

    private double calculerMontantTotal() {
        double total = 0;
        for (Prescription p : prescriptions) {
            total += p.getPrixUnitaire() * p.getQuantitePrescrite();
        }
        return total;
    }

        public static List<Facture> getFactures() {
        return factures;
    }

}
