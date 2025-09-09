package modele;

import exception.SaisieException;
import utilitaires.RegexValidator;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nom,prenom,adresse,codePostal,ville,telephone,email,nSs,dateNaissance,mutuelle,medecinRef;
    private static List<Client> client = new ArrayList<>();

    public Client(String nom, String prenom, String adresse, String codePostal, String ville,
                  String telephone, String email,String nSs,String dateNaissance,
                  String mutuelle,String medecinRef)throws SaisieException{

        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setCodePostal(codePostal);
        this.setVille(ville);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setNSs(nSs);
        this.setDateNaissance (dateNaissance);
        this.setMutuelle (mutuelle);
        this.setMedecinRef(medecinRef);
        client.add(this);
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) throws SaisieException {
        if (!RegexValidator.validerMots(nom)) {
            throw new SaisieException("Erreur dans le nom ! Merci de corriger");
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) throws SaisieException {
        if (RegexValidator.validerMots(prenom)) {
            throw new SaisieException("Erreur dans le prénom ! Merci de corriger");
        }
        this.prenom = prenom;
    }
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) throws SaisieException {
        if (RegexValidator.validerAdresse(adresse)) {
            throw new SaisieException("Erreur dans l'adresse ! Merci de corriger");
        }
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) throws SaisieException {
        if (RegexValidator.validerCodePostal(codePostal)) {
            throw new SaisieException("Erreur dans le code postal ! Merci de corriger");
        }
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) throws SaisieException {
        if (RegexValidator.validerVille(ville)) {
            throw new SaisieException("Erreur dans la ville ! Merci de corriger");
        }
        this.ville = ville;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) throws SaisieException {
        if (RegexValidator.validerTelephone(telephone)) {
            throw new SaisieException("Erreur le N° de telephone est incorrecte ! Merci de corriger");
        }
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) throws SaisieException {
        if (RegexValidator.validerEmail(email)) {
            throw new SaisieException("Erreur Mail est incorrecte ! Merci de corriger");
        }
        this.email = email;
    }
    public String getNSs() {
        return this.nSs;
    }

    public void setNSs(String nSs) throws SaisieException {
        if (RegexValidator.validerNSS(nSs)) {
            throw new SaisieException("N° de Securité Social incorrecte ! 15 chiffres ");
        }
        this.nSs = nSs;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws SaisieException {
        if (RegexValidator.validerDateNaissance(dateNaissance)) {
            throw new SaisieException("Format de date incorrecte ! Jour/Mois/Années attendue");
        }
        this.dateNaissance = dateNaissance;
    }

    public String getMutuelle() {
        return this.mutuelle;
    }

    public void setMutuelle(String mutuelle) throws SaisieException {
        if (RegexValidator.validerMots(mutuelle)) {
            throw new SaisieException("Nom de Mutuelle incorrecte ! Si le client a oublié " +
                    "sa Mutuelle veuillez sélectionner Pas de Mutuelle");
        }
        this.mutuelle = mutuelle;
    }

    public String getMedecinRef() {
        return medecinRef;
    }

    public void setMedecinRef(String medecinRef) throws SaisieException {
        if (RegexValidator.validerMots(medecinRef)) {
            throw new SaisieException("Sélectionnez un médecin ou créez-en un");
        }
        this.medecinRef = medecinRef;
    }

    public static List<Client> getClient() {
        return client;
    }

    public static void setClient(List<Client> client) {
        Client.client = client;
    }

    public String toString(){return
            "\nNom : "+this.nom
                    +"\nPrénom : "+this.prenom
                    +"\nAdresse : "+this.adresse
                    +"\nCodePostal : "+this.codePostal
                    +"\nVille : "+this.ville
                    +"\nTelephone : "+this.telephone
                    +"\nEmail : "+this.email
                    +"\nNuméron de Sécurité Social "+this.nSs
                    +"\nDate de Naissance "+this.dateNaissance
                    +"\nNom de Mutuelle "+this.mutuelle
                    +"\nMédecin Référent "+this.medecinRef;
    }
}


