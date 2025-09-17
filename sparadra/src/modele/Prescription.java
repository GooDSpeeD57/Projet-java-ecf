package modele;

public class Prescription {
    private String nomMedicament;
    private int quantite;

    public Prescription(String nomMedicament, int quantite) {
        this.nomMedicament = nomMedicament;
        this.quantite = quantite;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "nomMedicament='" + nomMedicament + '\'' +
                ", quantite=" + quantite +
                '}';
    }
}
