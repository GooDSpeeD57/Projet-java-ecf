package vue;
import exception.SaisieException;
import modele.Client;
import modele.Medicament;
import modele.Medecin;
import modele.Mutuelle;
import modele.Pharmacien;
import utilitaires.RegexValidator;

import java.util.Scanner;

public class Vue {
    private Scanner sc = new Scanner(System.in);


    public void vueMenu() {

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                          ║");
        System.out.println("║                                        Bienvenue                                         ║");
        System.out.println("║                                                                                          ║");
        System.out.println("║                                   Application Sparadra                                   ║");
        System.out.println("║                                                                                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⣉⣤⣤⣤⣉⠛⢿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⣠⣴⡾⠟⠋⠉⠉⠉⠓⠀⠹⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⢁⣠⣶⡿⠟⠉⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⢻⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⡿⠟⢋⣠⣴⣾⣿⣿⣅⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⣸⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⡿⠋⣁⣤⣶⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⣠⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⡿⢁⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⠀⠀⠀⠀⠀⠀ ⠀⣀⣴⣿⣿⣿                             ║");
        System.out.println("║                         ⣿⡿⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠁⣀⡀⠀⠀⢀⣠⣴⣿⣿⣿⣿⣿⣿                             ║");
        System.out.println("║                         ⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⢁⣤⡶⠟⠋⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⡀⢻⣯⡙⠛⠛⠋⠁⣀⣤⠾⠛⢁⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣄⡙⠻⠿⣶⠶⠿⠋⣁⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣶⣤⣤⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("║                         ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuglobal(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Menu Principal                                                                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Choix du type de vente                                                               ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Gestion Pharmacie                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Quitter l'Application                                                                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuAvecSansOrdonnance(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Choix du type de vente                                                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Avec Ordonnance                                                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Sans Ordonnance                                                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour au Menu Principal                                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuOrdonnance() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Avec Ordonnance                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Rechercher Client                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Creation Client                                                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Recherche Médecin                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 4 : Recherche Mutuelle                                                                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 5 : Recherche Médicament                                                                 ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour au Menu Précedent                                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuSansOrdonnance() {

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Sans Ordonnance                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Rechercher Client                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Creation Client                                                                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 5 : Recherche Médicament                                                                 ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour au Menu Précedent                                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuMedicament() {

        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Gestion Pharmacie                                                                ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Enregistrer un Médicament                                                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Enregistrer un Médecin                                                               ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Enregistrer une Mutuelle                                                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 4 : Enregistrer un(e) Pharmacien(ne)                                                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 5 : Liste des ventes                                                                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour au Menu Précedent                                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
        }
    public void vueMenuRechercheClients(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Recherche de Client                                                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche par Nom                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche par Numéro de Sécurité Sociale                                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Recherche par Email                                                                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour                                                                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuRechercheMedecin(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Recherche de Médecin                                                             ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche par Nom                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche par RPPS                                                                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Afficher tous les médecins                                                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour                                                                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuRechercheMutuelle(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Recherche de Mutuelle                                                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche par Nom                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche par Département                                                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Afficher toutes les mutuelles                                                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour                                                                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void vueMenuRechercheMedicament(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Recherche de Médicament                                                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche par Nom                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche par Catégorie                                                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 3 : Afficher tous les médicaments                                                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour                                                                               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public void afficherListeVentes() {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                     Liste des ventes                                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Fonctionnalité à implémenter...");
    }
    public void vueCreationClient() throws SaisieException {
        System.out.println("Création d'un Client");
        String nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        String prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        String adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        String codePostal = saisieCodePostal("Code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        String ville = saisieVille("Ville ?", "La ville est incorrecte ! merci de ressaisir");
        String telephone = saisieTelephone("Téléphone ?", "Le n° de téléphone est incorrect ! merci de ressaisir");
        String email = saisieEmail("Le mail ?", "Le Email est incorrect ! merci de ressaisir");
        String nSs = saisieNSS("Le n° de sécurité sociale ?", "Le N° de sécurité sociale est incorrect ! merci de ressaisir");
        String dateNaissance = saisieDateNaissance("La Date de Naissance (JJ/MM/AAAA) ?", "La date de naissance est incorrecte ! merci de ressaisir");
        String mutuelle = saisieNomPrenom("La Mutuelle ?", "Le nom de la mutuelle est incorrect ! merci de ressaisir");
        String medecinRef = saisieNomPrenom("Le Médecin référent ?", "Le nom du médecin est incorrect ! merci de ressaisir");
        Client nouveauClient = new Client(nom, prenom, adresse, codePostal, ville, telephone, email, nSs, dateNaissance, mutuelle, medecinRef);
    }

    public void vueCreationMedecin() throws SaisieException {
        System.out.println("Création d'un médecin");
        String nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        String prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        String adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        String codePostal = saisieCodePostal("Le code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        String ville = saisieVille("La ville ?", "La ville est incorrecte ! merci de ressaisir");
        String telephone = saisieTelephone("Le téléphone ?", "Le téléphone est incorrect ! merci de ressaisir");
        String email = saisieEmail("Le mail ?", "Le mail est incorrect ! merci de ressaisir");
        String rPPS = saisieRPPS("Le numéro RPPS ?", "Le numéro RPPS est incorrect ! merci de ressaisir");
        Medecin nouveauMedecin = new Medecin(nom, prenom, adresse, codePostal, ville, telephone, email, rPPS);
    }

    public void vueCreationPharmacien() throws SaisieException {
        System.out.println("Création d'un pharmacien");
        String nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        String prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        String rPPS = saisieRPPS("Le numéro RPPS ?", "Le numéro RPPS est incorrect ! merci de ressaisir");
        Pharmacien nouveauPharmaciens = new Pharmacien(nom, prenom, rPPS);
    }

    public void vueCreationMutuelle() throws SaisieException {
        System.out.println("Création d'une Mutuelle");
        String nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        String adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        String codePostal = saisieCodePostal("Le code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        String ville = saisieVille("La ville ?", "La ville est incorrecte ! merci de ressaisir");
        String telephone = saisieTelephone("Le téléphone ?", "Le téléphone est incorrect ! merci de ressaisir");
        String email = saisieEmail("Le mail ?", "Le mail est incorrect ! merci de ressaisir");
        String departement = saisieDepartement("Le département ?", "Le département est incorrect ! merci de ressaisir");
        int tdRemboursement = saisieTauxRemboursement("Le taux de remboursement (0-100) ?", "Le taux de remboursement est incorrect ! merci de ressaisir");
        Mutuelle nouvelleMutuelle = new Mutuelle(nom, adresse, codePostal, ville, telephone, email, departement, tdRemboursement);
    }

    public void vueCreationMedicament() throws SaisieException {
        System.out.println("Création d'un médicament");
        String nomMedicament = saisieNomMedicament("Le nom du médicament ?", "Le nom du médicament est incorrect ! merci de ressaisir");
        String categorieMedicament = saisieCategorieMedicament("La catégorie ?", "La catégorie est incorrecte ! merci de ressaisir");
        double prixMedicament = saisiePrix("Le prix ?", "Le prix est incorrect ! merci de ressaisir");
        String dateMiseEnCirculation = saisieDateNaissance("La date de mise en circulation (JJ/MM/AAAA) ?", "La date est incorrecte ! merci de ressaisir");
        int quantiteMedicament = saisieQuantite("La quantité ?", "La quantité est incorrecte ! merci de ressaisir");
        String sansOrdonnanceMedicament = saisieSansOrdonnance("Sans ordonnance (oui/non) ?", "Veuillez répondre par 'oui' ou 'non' !");
        Medicament nouveauMedicament = new Medicament(nomMedicament, categorieMedicament, prixMedicament, dateMiseEnCirculation, quantiteMedicament, sansOrdonnanceMedicament);
    }


    private String saisieNomPrenom(String message, String messageException) {
        String saisie;
        boolean erreur;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            erreur = false;

            if (!RegexValidator.validerMots(saisie)) {
                System.err.println(messageException);
                erreur = true;
            }

        } while (erreur);

        return saisie;
    }

    private String saisieEmail(String message, String messageException) {
        String saisie;
        boolean erreur ;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            erreur = false;
            if (!RegexValidator.validerEmail(saisie)) {
                System.err.println(messageException);
                erreur = true;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieAdresse(String message, String messageException) {
        String saisie;
        boolean erreur;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            erreur = false ;
            if (!RegexValidator.validerAdresse(saisie)) {
                System.err.println(messageException);
                erreur = true;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieCodePostal(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerCodePostal(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieVille(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerVille(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieTelephone(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerTelephone(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieNSS(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerNSS(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieDateNaissance(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerDateNaissance(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieRPPS(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerRPPS(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieDepartement(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerDepartement(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieNomMedicament(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerNomMedicament(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieCategorieMedicament(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerCategorieMedicament(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private String saisieSansOrdonnance(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerSansOrdonnance(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private int saisieTauxRemboursement(String message, String messageException) {
        int valeur = 0;
        boolean erreur = true;

        do {
            System.out.println(message);
            String saisie = sc.nextLine().trim();

            try {
                valeur = Integer.parseInt(saisie);
                if (!RegexValidator.validerTauxRemboursement(valeur)) {
                    System.err.println(messageException);
                } else {
                    erreur = false;
                }
            } catch (NumberFormatException e) {
                System.err.println(messageException);
            }
        } while (erreur);

        return valeur;
    }

    private int saisieQuantite(String message, String messageException) {
        int valeur = 0;
        boolean erreur = true;

        do {
            System.out.println(message);
            String saisie = sc.nextLine().trim();

            try {
                valeur = Integer.parseInt(saisie);
                if (!RegexValidator.validerQuantite(valeur)) {
                    System.err.println(messageException);
                } else {
                    erreur = false;
                }
            } catch (NumberFormatException e) {
                System.err.println(messageException);
            }
        } while (erreur);

        return valeur;
    }

    private double saisiePrix(String message, String messageException) {
        double valeur = 0.0;
        boolean erreur = true;

        do {
            System.out.println(message);
            String saisie = sc.nextLine().trim();

            try {
                valeur = Double.parseDouble(saisie);
                if (!RegexValidator.validerPrix(valeur)) {
                    System.err.println(messageException);
                } else {
                    erreur = false;
                }
            } catch (NumberFormatException e) {
                System.err.println(messageException);
            }
        } while (erreur);

        return valeur;
    }
}



