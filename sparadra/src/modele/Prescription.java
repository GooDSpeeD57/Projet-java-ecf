package modele;

import java.io.Serializable;

public class Prescription implements Serializable {
    private Medicament medicament;
    private int quantitePrescrite;

    public Prescription(Medicament medicament, int quantitePrescrite) {
        this.medicament = medicament;
        this.quantitePrescrite = quantitePrescrite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getQuantitePrescrite() {
        return quantitePrescrite;
    }

    public void setQuantitePrescrite(int quantitePrescrite) {
        this.quantitePrescrite = quantitePrescrite;
    }

    public String getNomMedicament() {
        return medicament != null ? medicament.getNomMedicament() : "Inconnu";
    }

    public double getPrixUnitaire() {
        return medicament != null ? medicament.getPrixMedicament() : 0.0;
    }

    public double getPrixTotal() {
        return getPrixUnitaire() * quantitePrescrite;
    }

    @Override
    public String toString() {
        return "Prescription : " +
                "Médicament = " + getNomMedicament() +
                ", Quantité prescrite = " + quantitePrescrite +
                ", Prix unitaire = " + getPrixUnitaire() + "€" +
                ", Prix total = " + getPrixTotal() + "€";
    }
}
