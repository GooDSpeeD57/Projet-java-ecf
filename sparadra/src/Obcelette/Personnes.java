//package modele;
//
//import exception.SaisieException;
//import utilitaires.RegexValidator;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.Locale;
//
//public class Personnes implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;
//    private String nom,prenom,adresse,codePostal,ville,telephone,email;
//
//
//    public Personnes(String nom, String prenom, String adresse, String codePostal,
//                     String ville, String telephone, String email)
//    throws SaisieException {
//        this.setNom(nom);
//        this.setPrenom(prenom);
//        this.setAdresse(adresse);
//        this.setCodePostal(codePostal);
//        this.setVille(ville);
//        this.setTelephone(telephone);
//        this.setEmail(email);
//    }
//    public Personnes(String nom, String adresse, String codePostal,
//                     String ville, String telephone, String email)
//            throws SaisieException {
//        this.setNom(nom);
//        this.setAdresse(adresse);
//        this.setCodePostal(codePostal);
//        this.setVille(ville);
//        this.setTelephone(telephone);
//        this.setEmail(email);
//    }
//    public Personnes(String nom, String prenom)
//            throws SaisieException {
//        this.setNom(nom);
//        this.setPrenom(prenom);
//
//    }
//
//    public String getNom() {
//        return this.nom;
//    }
//
//    public void setNom(String nom) throws SaisieException {
//        if (!RegexValidator.validerMots(nom)) {
//            throw new SaisieException("Erreur dans le nom ! Merci de corriger");
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
//            throw new SaisieException("Erreur dans le prénom ! Merci de corriger");
//        }
//        this.prenom = prenom;
//    }
//    public String getAdresse() {
//        return this.adresse;
//    }
//
//    public void setAdresse(String adresse) throws SaisieException {
//        if (!RegexValidator.validerAdresse(adresse)) {
//            throw new SaisieException("Erreur dans l'adresse ! Merci de corriger");
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
//            throw new SaisieException("Erreur dans le code postal ! Merci de corriger");
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
//            throw new SaisieException("Erreur dans la ville ! Merci de corriger");
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
//            throw new SaisieException("Erreur le N° de telephone est incorrecte ! Merci de corriger");
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
//            throw new SaisieException("Erreur Mail est incorrecte ! Merci de corriger");
//        }
//        this.email = email;
//    }
//
//public String toString(){return
//        "\nNom : "+this.nom
//        +"\nPrénom : "+this.prenom
//        +"\nAdresse : "+this.adresse
//        +"\nCodePostal : "+this.codePostal
//        +"\nVille : "+this.ville
//        +"\nTelephone : "+this.telephone
//        +"\nEmail : "+this.email;
//    }
//}
//
//
