//package Obcelette;
//
//import exception.SaisieException;
//import utilitaires.RegexValidator;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Medicaments implements Serializable {
//    private String nomMedicament;
//    private String categorieMedicament;
//    private double prixMedicament;
//    private String dateMiseEnCirculation;
//    private int quantiteMedicament;
//    private String sansOrdonnanceMedicament;
//        private static List<Medicaments> medicaments = new ArrayList<>();
//
//    public Medicaments(String nomMedicament,String categorieMedicament,
//             double prixMedicament,String dateMiseEnCirculation,
//             int quantiteMedicament,String sansOrdonnanceMedicament)throws SaisieException {
//        this.setNomMedicament(nomMedicament);
//        this.setCategorieMedicament (categorieMedicament);
//        this.setPrixMedicament(prixMedicament);
//        this.setDateMiseEnCirculation(dateMiseEnCirculation);
//        this.setQuantiteMedicament(quantiteMedicament);
//        this.setSansOrdonnanceMedicament(sansOrdonnanceMedicament);
//    medicaments.add(this);
//    }
//
//    public String getNomMedicament() {
//        return nomMedicament;
//    }
//
//    public void setNomMedicament(String nomMedicament) throws SaisieException {
//        if (!RegexValidator.validerNomMedicament(nomMedicament)) {
//            throw new SaisieException("Nom du medicament incorrecte !");
//        }
//        this.nomMedicament = nomMedicament;
//    }
//
//    public String getCategorieMedicament() {
//        return categorieMedicament;
//    }
//
//    public void setCategorieMedicament(String categorieMedicament) throws SaisieException {
//        if (!RegexValidator.validerCategorieMedicament(categorieMedicament)) {
//            throw new SaisieException("Catégorie incorrecte !");
//        }
//        this.categorieMedicament = categorieMedicament;
//    }
//
//    public double getPrixMedicament() {
//        return prixMedicament;
//    }
//
//    public void setPrixMedicament(double prixMedicament) throws SaisieException {
//        if (!RegexValidator.validerPrix(prixMedicament)) {
//            throw new SaisieException("Prix ne peut pas être négatif !");
//        }
//        this.prixMedicament = prixMedicament;
//    }
//
//    public String getDateMiseEnCirculation() {
//        return dateMiseEnCirculation;
//    }
//
//    public void setDateMiseEnCirculation(String dateMiseEnCirculation)throws SaisieException {
//        if (dateMiseEnCirculation == null) {
//            throw new SaisieException("Date doit être rentrée !");
//        } else {
//            this.dateMiseEnCirculation = dateMiseEnCirculation;
//        }
//    }
//    public void setQuantiteMedicament(int quantiteMedicament) throws SaisieException {
//        if (!RegexValidator.validerQuantite(quantiteMedicament)) {
//            throw new SaisieException("Quantité ne peut pas être négatif !");
//        }
//        this.quantiteMedicament = quantiteMedicament;
//    }
//
//    public void setSansOrdonnanceMedicament(String sansOrdonnanceMedicament) {
//        if (RegexValidator.validerSansOrdonnance(sansOrdonnanceMedicament)) {
//            this.sansOrdonnanceMedicament = sansOrdonnanceMedicament.toLowerCase();
//        } else {
//            this.sansOrdonnanceMedicament = sansOrdonnanceMedicament;
//        }
//    }
//
//    public static List<Medicaments> getMedicaments() {
//        return medicaments;
//    }
//
//    public static void setMedicaments(List<Medicaments> medicaments) {
//        Medicaments.medicaments = medicaments;
//    }
//
//    public String toString(){
//        return "Nom du medicament : "+this.nomMedicament+
//                "\nCatégorie du medicament : "+this.categorieMedicament+
//                "\nPrix du medicament : "+this.prixMedicament+
//                "\nDate de mise sur le marché : "+this.dateMiseEnCirculation+
//                "\nQuantité du medicament : "+this.quantiteMedicament+
//                "\nDisponible sans ordonnance"+this.sansOrdonnanceMedicament;
//    }
//}
//
