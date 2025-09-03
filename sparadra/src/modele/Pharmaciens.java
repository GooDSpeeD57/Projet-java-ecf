package modele;

import exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

public class Pharmaciens extends Personnes {
    private String rPPS;
    private final String REGEXRpps = "^10\\d{11}$";
    private static List<Pharmaciens> pharmaciens = new ArrayList<Pharmaciens>();

    public Pharmaciens(String nom, String prenom,String rPPS) throws SaisieException {
        super(nom, prenom);
        this.setRPPS(rPPS);
        pharmaciens.add(this);
    }

    public String getRPPS() {
        return this.rPPS;
    }

    public void setRPPS(String rPPS) throws SaisieException {
        if (rPPS == null || rPPS.trim().length() < 13 || !rPPS.matches(REGEXRpps)) {
            throw new SaisieException("RPPS non valide ! Merci de saisir 13 chiffres commencent par 10 ");
        } else {
            this.rPPS = rPPS;
        }
    }

    public static List<Pharmaciens> getPharmaciens() {
        return pharmaciens;
    }

    public static void setPharmaciens(List<Pharmaciens> pharmatiens) {
        Pharmaciens.pharmaciens = pharmaciens;
    }

    public String toString() {
        return super.toString()+"\nN° RPPS: "+this.rPPS;
    }
}
