//package modele;
//
//import exception.SaisieException;
//import utilitaires.RegexValidator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Pharmaciens extends Personnes {
//    private String rPPS;
//    private static List<Pharmaciens> pharmaciens = new ArrayList<>();
//
//    public Pharmaciens(String nom, String prenom,String rPPS) throws SaisieException {
//        super(nom, prenom);
//        this.setRPPS(rPPS);
//        pharmaciens.add(this);
//    }
//
//    public String getRPPS() {
//        return this.rPPS;
//    }
//
//    public void setRPPS(String rPPS) throws SaisieException {
//        if (!RegexValidator.validerRPPS(rPPS)) {
//            throw new SaisieException("RPPS non valide ! Merci de saisir 11 chiffres commencent par 10 ");
//        } else {
//            this.rPPS = rPPS;
//        }
//    }
//
//    public static List<Pharmaciens> getPharmaciens() {
//        return pharmaciens;
//    }
//
//    public static void setPharmaciens(List<Pharmaciens> pharmaciens) {
//        Pharmaciens.pharmaciens = pharmaciens;
//    }
//
//    public String toString() {
//        return super.toString()+"\nN° RPPS: "+this.rPPS;
//    }
//}
