package modele;

import exception.SaisieException;
import utilitaires.RegexValidator;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Personne {
    private String rPPS;

    private static List<Medecin> medecin = new ArrayList<>();

    public Medecin(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String email, String rPPS) throws SaisieException {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setRPPS(rPPS);
        medecin.add(this);
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

    public static List<Medecin> getMedecin() {
        return medecin;
    }

    public static void setMedecin(List<Medecin> medecin) {
        Medecin.medecin = medecin;
    }

    public String toString() {
        return super.toString()+"\nN° RPPS: "+this.rPPS;
    }
}
