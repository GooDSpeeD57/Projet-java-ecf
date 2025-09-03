package modele;

import exception.SaisieException;
import utilitaires.RegexValidator;

import java.util.ArrayList;
import java.util.List;

public class Medecins extends Personnes {
    private String rPPS;

    private static List<Medecins> medecins = new ArrayList<Medecins>();

    public Medecins(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String email,String rPPS) throws SaisieException {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setRPPS(rPPS);
        medecins.add(this);
    }

    public String getRPPS() {
        return this.rPPS;
    }

    public void setRPPS(String rPPS) throws SaisieException {
        if (!RegexValidator.validerRPPS(rPPS)) {
            throw new SaisieException("RPPS non valide ! Merci de saisir 11 chiffres commencent par 10 ");
        } else {
            this.rPPS = rPPS;
        }
    }

    public static List<Medecins> getMedecins() {
        return medecins;
    }

    public static void setMedecins(List<Medecins> medecins) {
        Medecins.medecins = medecins;
    }

    public String toString() {
        return super.toString()+"\nN° RPPS: "+this.rPPS;
    }
}
