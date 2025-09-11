package vue;

import exception.SaisieException;
import modele.*;
import utilitaires.PersitSerializable;
import utilitaires.RegexValidator;
import utilitaires.Saisie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    public static void lancerApplication() throws SaisieException {

        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        chargerDonnees();


    }

    private static void chargerDonnees() {

        List<Mutuelle> mutuelle = (List<Mutuelle>) donnees.getOrDefault("mutuelle", new java.util.ArrayList<>());
        List<Medicament> medicament = (List<Medicament>) donnees.getOrDefault("medicament", new java.util.ArrayList<>());
        List<Medecin> medecin = (List<Medecin>) donnees.getOrDefault("medecin", new java.util.ArrayList<>());
        List<Pharmacien> pharmacien = (List<Pharmacien>) donnees.getOrDefault("pharmacien", new java.util.ArrayList<>());
        List<Client> client = (List<Client>) donnees.getOrDefault("client", new java.util.ArrayList<>());

        Client.setClient(client);
        Mutuelle.setMutuelle(mutuelle);
        Medicament.setMedicament(medicament);
        Medecin.setMedecin(medecin);
        Pharmacien.setPharmacien(pharmacien);
    }



    public static void menuPrincipal() throws SaisieException {
         boolean fin = false;
            while (!fin) {
                Vue.vueMenu();
                Vue.vueMenuglobal();
                int choix = Saisie.lireEntier("Votre Choix [1-2] ou [0] pour quitter : ", "Choix entre 0, 1 et 2");
                switch (choix) {
                    case 0 -> fin = quitterEtSauvegarder();
                    case 1 -> menuAvecSansOrdonnance();
                    case 2 -> menuGestionPharmacie();
                    default -> System.err.println("! Choix incorrect ! [0-2] !");
            }
        }
    }

    private static void menuAvecSansOrdonnance() throws SaisieException {
        boolean fin = false;
            while (!fin) {
                Vue.vueMenuAvecSansOrdonnance();
                int choix = Saisie.lireEntier("Votre Choix [1-2] ou [0] pour retourner au menu principal : ", "Un nombre entre 0 et 2");
                switch (choix) {
                    case 0 -> fin = true;
                    case 1 -> menuAvecOrdonnance();
                    case 2 -> menuSansOrdonnance();
                    default -> System.err.println("Choix entre 0-2");
            }
        }
    }

    private  static void menuAvecOrdonnance() throws SaisieException {
        boolean fin = false;
            while (!fin) {
                Vue.vueMenuOrdonnance();
                int choix = Saisie.lireEntier("Votre Choix [1-5] ou [0] pour retourner au menu principal : ", "Un nombre entre 0 et 5");
                switch (choix) {
                    case 0 -> fin = true;
                    case 1 -> menuRechercheClient();
                    case 2 -> Vue.vueCreationClient();
                    case 3 -> menuRechercheMedecin();
                    case 4 -> menuRechercheMutuelle();
                    case 5 -> menuRechercheMedicament();
                    default -> System.err.println("Choix entre 0-5");
            }
        }
    }

    private static void menuSansOrdonnance() throws SaisieException {
        boolean fin = false;
            while (!fin) {
                Vue.vueMenuSansOrdonnance();
                int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner au menu principal : ", "Un nombre entre 0 et 3");
                switch (choix) {
                    case 0 -> fin = true;
                    case 1 -> menuRechercheClient();
                    case 2 -> Vue.vueCreationClient();
                    case 3 -> menuRechercheMedicament();
                    default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    private static void menuGestionPharmacie() throws SaisieException {
        boolean fin = false;
            while (!fin) {
                Vue.vueMenuMedicament();
                int choix = Saisie.lireEntier("Votre Choix [1-5] ou [0] pour retourner au menu principal : ", "Un nombre entre 0 et 5");
                switch (choix) {
                    case 0 -> fin = true;
                    case 1 -> Vue.vueCreationMedicament();
                    case 2 -> Vue.vueCreationMedecin();
                    case 3 -> Vue.vueCreationMutuelle();
                    case 4 -> Vue.vueCreationPharmacien();
                    case 5 -> Vue.afficherListeVentes();
                    default -> System.err.println("Choix entre 0-5");
            }
        }
    }

    private  static void menuRechercheClient() throws SaisieException {
        boolean fin = false;
        while (!fin) {
            Vue.vueMenuRechercheClients();
            int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner : ", "Un nombre entre 0 et 3");
            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    System.out.print("Nom du client à rechercher : \n");
                    String nom = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(nom)) {
                            List<Client> resultats = rechercherClientParNom(nom);
                            afficherResultatsClients(resultats, "nom \"" + nom + "\"");
                        } else {
                            System.out.println("Nom invalide Veuillez entrer un nom valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du client.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("N° de sécurité sociale du client : ");
                    String nss = scanner.nextLine();
                    try {
                        if (!RegexValidator.validerMots(nss)) {
                            List<Client> resultats = rechercherClientParNSS(nss);
                            afficherResultatsClients(resultats, "NSS \"" + nss + "\"");
                        } else {
                            System.out.println("NSS invalide Veuillez entrer un NSS valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du client.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Email du client à rechercher : ");
                    String email = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(email)) {
                            List<Client> resultats = rechercherClientParEmail(email);
                            afficherResultatsClients(resultats, "email \"" + email + "\"");
                        } else {
                            System.out.println("Email invalide Veuillez entrer un email valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du client.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
            }
        }
    }
    private static void menuRechercheMedecin() throws SaisieException {
        boolean fin = false;
        while (!fin) {
            Vue.vueMenuRechercheMedecin();
            int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner : ", "Un nombre entre 0 et 3");
            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    System.out.print("Nom du médecin à rechercher : ");
                    String nom = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(nom)) {
                            List<Medecin> resultats = rechercherMedecinParNom(nom);
                            afficherResultatsMedecins(resultats, "nom \"" + nom + "\"");
                        } else {
                            System.out.println("Nom invalide Veuillez entrer un nom valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du médecin.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("N° RPPS du médecin : ");
                    String rpps = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(rpps)) {
                            List<Medecin> resultats = rechercherMedecinParRPPS(rpps);
                            afficherResultatsMedecins(resultats, "RPPS \"" + rpps + "\"");
                        } else {
                            System.out.println("RPPS invalide Veuillez entrer un RPPS valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du médecin.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 3 -> afficherTousLesMedecins();
                default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    private static void menuRechercheMutuelle() throws SaisieException {
        boolean fin = false;
        while (!fin) {
            Vue.vueMenuRechercheMutuelle();
            int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner : ", "Un nombre entre 0 et 3");
            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    System.out.print("Nom de la mutuelle à rechercher : ");
                    String nom = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(nom)) {
                            List<Mutuelle> resultats = rechercherMutuelleParNom(nom);
                            afficherResultatsMutuelles(resultats, "nom \"" + nom + "\"");
                        } else {
                            System.out.println("Nom invalide Veuillez entrer un nom valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche de la mutuelle.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Département de la mutuelle : ");
                    String departement = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(departement)) {
                            List<Mutuelle> resultats = rechercherMutuelleParDepartement(departement);
                            afficherResultatsMutuelles(resultats, "département \"" + departement + "\"");
                        } else {
                            System.out.println("Département invalide Veuillez entrer un département valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche de la mutuelle.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 3 -> afficherToutesLesMutuelles();
                default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    private static void menuRechercheMedicament() throws SaisieException {
        boolean fin = false;
        while (!fin) {
            Vue.vueMenuRechercheMedicament();
            int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner : ", "Un nombre entre 0 et 3");
            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    System.out.print("Nom du médicament à rechercher : ");
                    String nom = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(nom)) {
                            List<Medicament> resultats = rechercherNomMedicament(nom);
                            afficherResultatsMedicaments(resultats, "nom \"" + nom + "\"");
                        } else {
                            System.out.println("Nom invalide Veuillez entrer un nom valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du médicament.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Catégorie du médicament : ");
                    String categorie = scanner.nextLine();
                    try {
                        if (RegexValidator.validerMots(categorie)) {
                            List<Medicament> resultats = rechercherParCategorie(categorie);
                            afficherResultatsMedicaments(resultats, "catégorie \"" + categorie + "\"");
                        } else {
                            System.out.println("Catégorie invalide Veuillez entrer une catégorie valide");
                        }
                    } catch (Exception e) {
                        System.out.println(" Une erreur est survenue pendant la recherche du médicament.");
                        System.out.println("Détails de l'erreur : " + e.getMessage());
                    }
                }
                case 3 -> afficherTousLesMedicaments();
                default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    public static List<Client> rechercherClientParNom(String nom) {
        List<Client> resultats = new ArrayList<>();
        for (Client client : Client.getClient()) {
            if (client.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }


    public static List<Client> rechercherClientParNSS(String nSs) {
        List<Client> resultats = new ArrayList<>();
        for (Client client : Client.getClient()) {
            if (client.getNSs().toLowerCase().contains(nSs.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }

    public static List<Client> rechercherClientParEmail(String email) {
        List<Client> resultats = new ArrayList<>();
        for (Client client : Client.getClient()) {
            if (client.getEmail().toLowerCase().contains(email.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }
    public static List<Medecin> rechercherMedecinParNom(String nom) {
        List<Medecin> resultats = new ArrayList<>();
        for (Medecin medecin : Medecin.getMedecin()) {
            if (medecin.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medecin);
            }
        }
        return resultats;
    }

    public static List<Medecin> rechercherMedecinParRPPS(String RPPS) {
        List<Medecin> resultats = new ArrayList<>();
        for (Medecin medecins : Medecin.getMedecin()) {
            if (medecins.getRPPS().toLowerCase().contains(RPPS.toLowerCase())) {
                resultats.add(medecins);
            }
        }
        return resultats;
    }
    private static void afficherTousLesMedecins() {
        for (Medecin medecins : Medecin.getMedecin()) {
            System.out.println("==================================");
            System.out.println(medecins);
        }
    }

    public static List<Mutuelle> rechercherMutuelleParNom(String nom) {
        List<Mutuelle> resultats = new ArrayList<>();
        for (Mutuelle mutuelles : Mutuelle.getMutuelle()) {
            if (mutuelles.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(mutuelles);
            }
        }
        return resultats;
    }
    public static List<Mutuelle> rechercherMutuelleParDepartement(String departement) {
        List<Mutuelle> resultats = new ArrayList<>();
        for (Mutuelle mutuelles : Mutuelle.getMutuelle()) {
            if(mutuelles.getDepartement().equals(departement)) {
                resultats.add(mutuelles);
            }
        }
        return resultats;
    }

    private static void afficherToutesLesMutuelles() {
        for (Mutuelle mutuelles : Mutuelle.getMutuelle()) {
            System.out.println("==================================");
            System.out.println(mutuelles);
        }
    }

    public static List<Medicament> rechercherNomMedicament(String nom) {
        List<Medicament> resultats = new ArrayList<>();
        for (Medicament medicament : Medicament.getMedicament()) {
            if (medicament.getNomMedicament().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medicament);
            }
        }
        return resultats;
    }

    public static List<Medicament> rechercherParCategorie(String nom) {
        List<Medicament> resultats = new ArrayList<>();
        for (Medicament medicament : Medicament.getMedicament()) {
            if (medicament.getCategorieMedicament().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medicament);
            }
        }
        return resultats;
    }

    private static void afficherTousLesMedicaments() {
        for (Medicament medicament : Medicament.getMedicament()) {
            System.out.println("==================================");
            System.out.println(medicament);
        }
    }

    public static void afficherResultatsMedicamentsParCategorie(String nomCategorie) {
        List<Medicament> resultats = rechercherParCategorie(nomCategorie);
            if (resultats.isEmpty()) {
                System.out.println("Aucun médicament trouvé pour la catégorie : " + nomCategorie);
            } else {
                System.out.println("Médicaments trouvés pour la catégorie : " + nomCategorie);
                for (Medicament medicament : resultats) {
                    System.out.println("==================================");
                    System.out.println(medicament);
                }
            }
        }



        private static void afficherResultatsClients(List<Client> clients, String critere) {
        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé pour : " + critere);
        } else {
            System.out.println("Clients trouvés pour " + critere + " :");
            for (Client client : clients) {
                System.out.println("==================================");
                System.out.println(client);
            }
        }
    }

    private static void afficherResultatsMedecins(List<Medecin> medecins, String critere) {
        if (medecins.isEmpty()) {
            System.out.println("Aucun médecin trouvé pour : " + critere);
        } else {
            System.out.println("Médecins trouvés pour " + critere + " :");
            for (Medecin medecin : medecins) {
                System.out.println("==================================");
                System.out.println(medecin);
            }
        }
    }

    private static void afficherResultatsMutuelles(List<Mutuelle> mutuelles, String critere) {
        if (mutuelles.isEmpty()) {
            System.out.println("Aucune mutuelle trouvée pour : " + critere);
        } else {
            System.out.println("Mutuelles trouvées pour " + critere + " :");
            for (Mutuelle mutuelle : mutuelles) {
                System.out.println("==================================");
                System.out.println(mutuelle);
            }
        }
    }

    private static void afficherResultatsMedicaments(List<Medicament> medicaments, String critere) {
        if (medicaments.isEmpty()) {
            System.out.println("Aucun médicament trouvé pour : " + critere);
        } else {
            System.out.println("Médicaments trouvés pour " + critere + " :");
            for (Medicament medicament : medicaments) {
                System.out.println("==================================");
                System.out.println(medicament);
            }
        }
    }

    private static boolean quitterEtSauvegarder() {
        System.out.println("Sauvegarde en cours...");
        donnees.put("client", Client.getClient());
        donnees.put("mutuelle", Mutuelle.getMutuelle());
        donnees.put("medicament", Medicament.getMedicament());
        donnees.put("pharmacien", Pharmacien.getPharmacien());
        donnees.put("medecin", Medecin.getMedecin());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
        System.out.println("Au revoir !");
        return true;
    }
}