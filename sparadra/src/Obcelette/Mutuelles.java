//package modele;
//
//import exception.SaisieException;
//import utilitaires.RegexValidator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Mutuelles extends Personnes {
//    private String departement;
//    private int tdRemboursement;
//    private static List<Mutuelles> mutuelles = new ArrayList<Mutuelles>();
//
//    public Mutuelles(String nom, String adresse
//            , String codePostal, String ville, String telephone, String email
//            , String departement, int tdRemboursement) throws SaisieException {
//        super(nom, adresse, codePostal, ville, telephone, email);
//        this.setDepartement(departement);
//        this.setTdRemboursement(tdRemboursement);
//        mutuelles.add(this);
//    }
//
//    public String getDepartement() {
//        return departement;
//    }
//
//    public void setDepartement(String departement) throws SaisieException {
//        if (!RegexValidator.validerVille(departement)) {
//            throw new SaisieException("Sélectionnez un médecin ou créez-en un");
//        }
//        this.departement = departement;
//    }
//
//    public int getTdRemboursement() {
//        return tdRemboursement;
//    }
//
//    public void setTdRemboursement(int tdRemboursement) throws SaisieException {
//        if (!RegexValidator.validerTauxRemboursement(tdRemboursement)) {
//            throw new SaisieException("Taux de remboursement invalide ! Doit être entre 0 et 100.");
//        }
//        this.tdRemboursement = tdRemboursement;
//    }
//
//    public static List<Mutuelles> getMutuelles() {
//        return mutuelles;
//    }
//
//    public static void setMutuelles(List<Mutuelles> mutuelles) {
//        Mutuelles.mutuelles = mutuelles;
//    }
//
//    public String toString() {
//        return super.toString() + "\nDépartement : " + this.departement +
//                "\nTaux de remboursement : " + this.tdRemboursement;
//
//    }
//}
///*import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//
//public static boolean dateValide(String dateStr) {
//    try {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate date = LocalDate.parse(dateStr, formatter);
//        return !date.isAfter(LocalDate.now()); // Ne pas accepter les dates futures
//    } catch (DateTimeParseException e) {
//        return false;
//    }
//*/
