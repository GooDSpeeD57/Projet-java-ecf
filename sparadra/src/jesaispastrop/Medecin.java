//package modele;
//
//import exception.SaisieException;
//import utilitaires.RegexValidator;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Medecin implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;
//    private String nom,prenom,adresse,codePostal,ville,telephone,email,rPPS;
//
//    private static List<Medecin> medecin = new ArrayList<>();
//
//    public Medecin(String nom, String prenom, String adresse, String codePostal,
//                     String ville, String telephone, String email,String rPPS)
//            throws SaisieException {
//        this.setNom(nom);
//        this.setPrenom(prenom);
//        this.setAdresse(adresse);
//        this.setCodePostal(codePostal);
//        this.setVille(ville);
//        this.setTelephone(telephone);
//        this.setEmail(email);
//        this.setRPPS(rPPS);
//        medecin.add(this);
//    }
//
//    public String getNom() {
//        return this.nom;
//    }
//
//    public void setNom(String nom) throws SaisieException {
//        if (!RegexValidator.validerMots(nom)) {
//            throw new SaisieException("Erreur dans le nom medecin! Merci de corriger"+nom);
//        }
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return this.prenom;
//    }
//
//    public void setPrenom(String prenom) throws SaisieException {
//        if (!RegexValidator.validerMots(prenom)) {
//            throw new SaisieException("Erreur dans le prénom medecin ! Merci de corriger"+prenom);
//        }
//        this.prenom = prenom;
//    }
//    public String getAdresse() {
//        return this.adresse;
//    }
//
//    public void setAdresse(String adresse) throws SaisieException {
//        if (!RegexValidator.validerAdresse(adresse)) {
//            throw new SaisieException("Erreur dans l'adresse medecin ! Merci de corriger"+adresse);
//        }
//        this.adresse = adresse;
//    }
//
//    public String getCodePostal() {
//        return this.codePostal;
//    }
//
//    public void setCodePostal(String codePostal) throws SaisieException {
//        if (!RegexValidator.validerCodePostal(codePostal)) {
//            throw new SaisieException("Erreur dans le code postal medecin ! Merci de corriger"+codePostal);
//        }
//        this.codePostal = codePostal;
//    }
//
//    public String getVille() {
//        return this.ville;
//    }
//
//    public void setVille(String ville) throws SaisieException {
//        if (!RegexValidator.validerVille(ville)) {
//            throw new SaisieException("Erreur dans la ville medecin ! Merci de corriger"+ville);
//        }
//        this.ville = ville;
//    }
//
//    public String getTelephone() {
//        return this.telephone;
//    }
//
//    public void setTelephone(String telephone) throws SaisieException {
//        if (!RegexValidator.validerTelephone(telephone)) {
//            throw new SaisieException("Erreur le N° de telephone est incorrecte medecin ! Merci de corriger"+telephone);
//        }
//        this.telephone = telephone;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setEmail(String email) throws SaisieException {
//        if (!RegexValidator.validerEmail(email)) {
//            throw new SaisieException("Erreur Mail est incorrecte medecin ! Merci de corriger"+email);
//        }
//        this.email = email;
//    }
//
//    public String getRPPS() {
//        return this.rPPS;
//    }
//
//    public void setRPPS(String rPPS) throws SaisieException {
//        if (!RegexValidator.validerRPPS(rPPS)) {
//            throw new SaisieException("RPPS non valide ! Merci de saisir 11 chiffres commencent par 10 "+rPPS);
//        } else {
//            this.rPPS = rPPS;
//        }
//    }
//
//    public static List<Medecin> getMedecin() {
//        return medecin;
//    }
//
//    public static void setMedecin(List<Medecin> medecin) {
//        Medecin.medecin = medecin;
//    }
//
//    public String toString(){return
//            "\nNom : "+this.nom
//            +"\nPrénom : "+this.prenom
//             +"\nAdresse : "+this.adresse
//              +"\nCodePostal : "+this.codePostal
//               +"\nVille : "+this.ville
//                +"\nTelephone : "+this.telephone
//                 +"\nEmail : "+this.email
//                  +"\nRépertoire Partagé des Professionnels de Santé : "+this.rPPS;
//    }
//}
//
//
