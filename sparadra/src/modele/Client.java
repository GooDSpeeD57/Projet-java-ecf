package modele;

import exception.SaisieException;
import utilitaires.RegexValidator;

import java.util.ArrayList;
import java.util.List;

public class Client extends Personne {
    private String nSs,dateNaissance,mutuelle,medecinRef;
    private static List<Client> client = new ArrayList<>();

    public Client(String nom, String prenom, String adresse, String codePostal, String ville,
                   String telephone, String email,String nSs,String dateNaissance,
                   String mutuelle,String medecinRef)throws SaisieException {
        super(nom, prenom, adresse, codePostal, ville, telephone, email);
        this.setNSs(nSs);
        this.setDateNaissance (dateNaissance);
        this.setMutuelle (mutuelle);
        this.setMedecinRef(medecinRef);
        client.add(this);
    }

    public String getNSs() {
        return this.nSs;
    }

    public void setNSs(String nSs) throws SaisieException {
        if (!RegexValidator.validerNSS(nSs)) {
            throw new SaisieException("N° de Securité Social incorrecte ! 15 chiffres ");
        }
        this.nSs = nSs;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws SaisieException {
        if (!RegexValidator.validerDateNaissance(dateNaissance)) {
            throw new SaisieException("Format de date incorrecte ! Jour/Mois/Années attendue");
        }
        this.dateNaissance = dateNaissance;
    }

    public String getMutuelle() {
        return this.mutuelle;
    }

    public void setMutuelle(String mutuelle) throws SaisieException {
        if (!RegexValidator.validerMots(mutuelle)) {
            throw new SaisieException("Nom de Mutuelle incorrecte ! Si le client a oublié " +
                    "sa Mutuelle veuillez sélectionner Pas de Mutuelle");
        }
        this.mutuelle = mutuelle;
    }

    public String getMedecinRef() {
        return medecinRef;
    }

    public void setMedecinRef(String medecinRef) throws SaisieException {
        if (!RegexValidator.validerMots(medecinRef)) {
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

    public static List<Client> rechercherClientParNom(String nom) {
        List<Client> resultats = new ArrayList<>();
        for (Client c : client) {
            if (c.getNom() != null && c.getNom().equalsIgnoreCase(nom.trim())) {
                resultats.add(c);
            }
        }
        return resultats;
    }

    public static List<Client> rechercherClientParNss(String nSs) {
        List<Client> resultats = new ArrayList<>();
        for (Client c : client) {
            if (c.getNSs() != null && c.getNSs().equals(nSs.trim())) {
                resultats.add(c);
            }
        }
        return resultats;
    }

    public static List<Client> rechercherClientParEmail(String email) {
        List<Client> resultats = new ArrayList<>();
        for (Client c : client) {
            if (c.getEmail() != null && c.getEmail().equalsIgnoreCase(email.trim())) {
                resultats.add(c);
            }
        }
        return resultats;
    }


    public String toString(){
        return super.toString()+
                "\n Numéron de Sécurité Social "+this.nSs+
                "\n Date de Naissance "+this.dateNaissance+
                "\n Nom de Mutuelle "+this.mutuelle+
                "\n Médecin Référent "+this.medecinRef;
    }
}


