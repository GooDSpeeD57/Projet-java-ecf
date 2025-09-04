package vue;
import exception.SaisieException;
import modele.Clients;
import modele.Medicaments;
import modele.Medecins;
import modele.Mutuelles;
import modele.Ordonnance;
import modele.Pharmaciens;
import utilitaires.RegexValidator;

import java.util.Scanner;

public class Vue {
    private static Scanner sc = new Scanner(System.in);
    private static String nom, prenom, adresse, codePostal, ville, telephone, email, nSs
            , dateNaissance, mutuelle, medecinRef, rPPS, nomMedicament, categorieMedicament
            , dateMiseEnCirculation, sansOrdonnanceMedicament, departement;
    private static int tdRemboursement, quantiteMedicament;
    private static double prixMedicament;

    public static void vueMenu() {

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
    public static void vueMenuglobal(){
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║         Menu Principal                                                                   ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 1 : Avec ou Sans Ordonnance                                                              ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 2 : Gestion Pharmacie                                                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ 0 : Quitter l'Application                                                                ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════╝");
    }
    public static void vueMenuOrdonnance() {
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
    public static void vueMenuSansOrdonnance() {

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
    public static void vueMenuMedicament() {

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
    public static void vueCreationClient() throws SaisieException {
        System.out.println("Création d'un Client");
        nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        codePostal = saisieCodePostal("Code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        ville = saisieVille("Ville ?", "La ville est incorrecte ! merci de ressaisir");
        telephone = saisieTelephone("Téléphone ?", "Le n° de téléphone est incorrect ! merci de ressaisir");
        email = saisieEmail("Le mail ?", "Le Email est incorrect ! merci de ressaisir");
        nSs = saisieNSS("Le n° de sécurité sociale ?", "Le N° de sécurité sociale est incorrect ! merci de ressaisir");
        dateNaissance = saisieDateNaissance("La Date de Naissance (JJ/MM/AAAA) ?", "La date de naissance est incorrecte ! merci de ressaisir");
        mutuelle = saisieNomPrenom("La Mutuelle ?", "Le nom de la mutuelle est incorrect ! merci de ressaisir");
        medecinRef = saisieNomPrenom("Le Médecin référent ?", "Le nom du médecin est incorrect ! merci de ressaisir");
        Clients nouveauClient = new Clients(nom, prenom, adresse, codePostal, ville, telephone, email, nSs, dateNaissance, mutuelle, medecinRef);
    }

    public static void vueCreationMedecin() throws SaisieException {
        System.out.println("Création d'un médecin");
        nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        codePostal = saisieCodePostal("Le code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        ville = saisieVille("La ville ?", "La ville est incorrecte ! merci de ressaisir");
        telephone = saisieTelephone("Le téléphone ?", "Le téléphone est incorrect ! merci de ressaisir");
        email = saisieEmail("Le mail ?", "Le mail est incorrect ! merci de ressaisir");
        rPPS = saisieRPPS("Le numéro RPPS ?", "Le numéro RPPS est incorrect ! merci de ressaisir");
        Medecins nouveauMedecin = new Medecins(nom, prenom, adresse, codePostal, ville, telephone, email, rPPS);
    }

    public static void vueCreationPharmacien() throws SaisieException {
        System.out.println("Création d'un pharmacien");
        nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        prenom = saisieNomPrenom("Le prénom ?", "Le prénom est incorrect ! merci de ressaisir");
        rPPS = saisieRPPS("Le numéro RPPS ?", "Le numéro RPPS est incorrect ! merci de ressaisir");
        Pharmaciens nouveauPharmaciens = new Pharmaciens(nom, prenom, rPPS);
    }

    public static void vueCreationMutuelle() throws SaisieException {
        System.out.println("Création d'une Mutuelle");
        nom = saisieNomPrenom("Le nom ?", "Le nom est incorrect ! merci de ressaisir");
        adresse = saisieAdresse("L'adresse ?", "L'adresse est incorrecte ! merci de ressaisir");
        codePostal = saisieCodePostal("Le code postal ?", "Le code postal est incorrect ! merci de ressaisir");
        ville = saisieVille("La ville ?", "La ville est incorrecte ! merci de ressaisir");
        telephone = saisieTelephone("Le téléphone ?", "Le téléphone est incorrect ! merci de ressaisir");
        email = saisieEmail("Le mail ?", "Le mail est incorrect ! merci de ressaisir");
        departement = saisieDepartement("Le département ?", "Le département est incorrect ! merci de ressaisir");
        tdRemboursement = saisieTauxRemboursement("Le taux de remboursement (0-100) ?", "Le taux de remboursement est incorrect ! merci de ressaisir");
        Mutuelles nouvelleMutuelle = new Mutuelles(nom, adresse, codePostal, ville, telephone, email, departement, tdRemboursement);
    }

    public static void vueCreationMedicament() throws SaisieException {
        System.out.println("Création d'un médicament");
        nomMedicament = saisieNomMedicament("Le nom du médicament ?", "Le nom du médicament est incorrect ! merci de ressaisir");
        categorieMedicament = saisieCategorieMedicament("La catégorie ?", "La catégorie est incorrecte ! merci de ressaisir");
        prixMedicament = saisiePrix("Le prix ?", "Le prix est incorrect ! merci de ressaisir");
        dateMiseEnCirculation = saisieDateNaissance("La date de mise en circulation (JJ/MM/AAAA) ?", "La date est incorrecte ! merci de ressaisir");
        quantiteMedicament = saisieQuantite("La quantité ?", "La quantité est incorrecte ! merci de ressaisir");
        sansOrdonnanceMedicament = saisieSansOrdonnance("Sans ordonnance (oui/non) ?", "Veuillez répondre par 'oui' ou 'non' !");
        Medicaments nouveauMedicament = new Medicaments(nomMedicament, categorieMedicament, prixMedicament, dateMiseEnCirculation, quantiteMedicament, sansOrdonnanceMedicament);
    }


    private static String saisieNomPrenom(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerMots(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private static String saisieEmail(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerEmail(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private static String saisieAdresse(String message, String messageException) {
        String saisie = "";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!RegexValidator.validerAdresse(saisie)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private static String saisieCodePostal(String message, String messageException) {
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

    private static String saisieVille(String message, String messageException) {
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

    private static String saisieTelephone(String message, String messageException) {
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

    private static String saisieNSS(String message, String messageException) {
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

    private static String saisieDateNaissance(String message, String messageException) {
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

    private static String saisieRPPS(String message, String messageException) {
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

    private static String saisieDepartement(String message, String messageException) {
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

    private static String saisieNomMedicament(String message, String messageException) {
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

    private static String saisieCategorieMedicament(String message, String messageException) {
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

    private static String saisieSansOrdonnance(String message, String messageException) {
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

    private static int saisieTauxRemboursement(String message, String messageException) {
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

    private static int saisieQuantite(String message, String messageException) {
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

    private static double saisiePrix(String message, String messageException) {
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



