package vue;

import exception.SaisieException;
import modele.*;
import utilitaires.PersitSerializable;
import utilitaires.RegexValidator;
import utilitaires.Saisie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu2 {
    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    public static void lancerApplication() throws SaisieException {

        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        chargerDonnees();

        menuPrincipal();
    }

    private static void chargerDonnees() {
        List<Mutuelles> mutuelles = (List<Mutuelles>) donnees.getOrDefault("mutuelles", new java.util.ArrayList<>());
        List<Medicaments> medicaments = (List<Medicaments>) donnees.getOrDefault("medicaments", new java.util.ArrayList<>());
        List<Medecins> medecins = (List<Medecins>) donnees.getOrDefault("medecins", new java.util.ArrayList<>());
        List<Pharmaciens> pharmaciens = (List<Pharmaciens>) donnees.getOrDefault("pharmaciens", new java.util.ArrayList<>());
        List<Clients> clients = (List<Clients>) donnees.getOrDefault("clients", new java.util.ArrayList<>());

        Clients.setClients(clients);
        Mutuelles.setMutuelles(mutuelles);
        Medicaments.setMedicaments(medicaments);
        Medecins.setMedecins(medecins);
        Pharmaciens.setPharmaciens(pharmaciens);
    }

    private static void menuPrincipal() throws SaisieException {
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

    private static void menuAvecOrdonnance() throws SaisieException {
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

    private static void menuRechercheClient() throws SaisieException {
        boolean fin = false;
            while (!fin) {
                Vue.vueMenuRechercheClients();
                int choix = Saisie.lireEntier("Votre Choix [1-3] ou [0] pour retourner : ", "Un nombre entre 0 et 3");
                switch (choix) {
                    case 0 -> fin = true;
                    case 1 -> {
                        System.out.print("Nom du client à rechercher : \n");
                        String nom = RegexValidator.validerMots("nom");
                        List<Clients> resultats = rechercherClientParNom(nom);
                        afficherResultatsClients(resultats, "nom \"" + nom + "\"");
                    }
                    case 2 -> {
                        System.out.print("N° de sécurité sociale du client : ");
                        String nss = Saisie.lireChaine();
                        List<Clients> resultats = rechercherClientParNSS(nss);
                        afficherResultatsClients(resultats, "NSS \"" + nss + "\"");
                    }
                    case 3 -> {
                        System.out.print("Email du client à rechercher : ");
                        String email = Saisie.lireChaine();
                        List<Clients> resultats = rechercherClientParEmail(email);
                        afficherResultatsClients(resultats, "email \"" + email + "\"");
                    }
                    default -> System.err.println("Choix entre 0-3");
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
                    String nom = Saisie.lireChaine();
                    List<Medecins> resultats = rechercherMedecinParNom(nom);
                    afficherResultatsMedecins(resultats, "nom \"" + nom + "\"");
                }
                case 2 -> {
                    System.out.print("N° RPPS du médecin : ");
                    String rpps = Saisie.lireChaine();
                    List<Medecins> resultats = rechercherMedecinParRPPS(rpps);
                    afficherResultatsMedecins(resultats, "RPPS \"" + rpps + "\"");
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
                    String nom = Saisie.lireChaine();
                    List<Mutuelles> resultats = rechercherMutuelleParNom(nom);
                    afficherResultatsMutuelles(resultats, "nom \"" + nom + "\"");
                }
                case 2 -> {
                    System.out.print("Département de la mutuelle : ");
                    String departement = Saisie.lireChaine();
                    List<Mutuelles> resultats = rechercherMutuelleParDepartement(departement);
                    afficherResultatsMutuelles(resultats, "département \"" + departement + "\"");
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
                    String nom = Saisie.lireChaine();
                    List<Medicaments> resultats = rechercherNomMedicament(nom);
                    afficherResultatsMedicaments(resultats, "nom \"" + nom + "\"");
                }
                case 2 -> {
                    System.out.print("Catégorie du médicament : ");
                    String categorie = Saisie.lireChaine();
                    List<Medicaments> resultats = rechercherParCategorie(categorie);
                    afficherResultatsMedicaments(resultats, "catégorie \"" + categorie + "\"");
                }
                case 3 -> afficherTousLesMedicaments();
                default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    public static List<Clients> rechercherClientParNom(String nom) {
        List<Clients> resultats = new ArrayList<>();
        for (Clients client : Clients.getClients()) {
            if (client.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }


    public static List<Clients> rechercherClientParNSS(String nSs) {
        List<Clients> resultats = new ArrayList<>();
        for (Clients client : Clients.getClients()) {
            if (client.getNSs().toLowerCase().contains(nSs.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }

    public static List<Clients> rechercherClientParEmail(String email) {
        List<Clients> resultats = new ArrayList<>();
        for (Clients client : Clients.getClients()) {
            if (client.getEmail().toLowerCase().contains(email.toLowerCase())) {
                resultats.add(client);
            }
        }
        return resultats;
    }
    public static List<Medecins> rechercherMedecinParNom(String nom) {
        List<Medecins> resultats = new ArrayList<>();
        for (Medecins medecin : Medecins.getMedecins()) {
            if (medecin.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medecin);
            }
        }
        return resultats;
    }

    public static List<Medecins> rechercherMedecinParRPPS(String RPPS) {
        List<Medecins> resultats = new ArrayList<>();
        for (Medecins medecins : Medecins.getMedecins()) {
            if (medecins.getRPPS().toLowerCase().contains(RPPS.toLowerCase())) {
                resultats.add(medecins);
            }
        }
        return resultats;
    }
    private static void afficherTousLesMedecins() {
        for (Medecins medecins : Medecins.getMedecins()) {
            System.out.println("==================================");
            System.out.println(medecins);
        }
    }

    public static List<Mutuelles> rechercherMutuelleParNom(String nom) {
        List<Mutuelles> resultats = new ArrayList<>();
        for (Mutuelles mutuelles : Mutuelles.getMutuelles()) {
            if (mutuelles.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(mutuelles);
            }
        }
        return resultats;
    }
    public static List<Mutuelles> rechercherMutuelleParDepartement(String departement) {
        List<Mutuelles> resultats = new ArrayList<>();
        for (Mutuelles mutuelles : Mutuelles.getMutuelles()) {
            if(mutuelles.getDepartement().equals(departement)) {
                resultats.add(mutuelles);
            }
        }
        return resultats;
    }

    private static void afficherToutesLesMutuelles() {
        for (Mutuelles mutuelles : Mutuelles.getMutuelles()) {
            System.out.println("==================================");
            System.out.println(mutuelles);
        }
    }

    public static List<Medicaments> rechercherNomMedicament(String nom) {
        List<Medicaments> resultats = new ArrayList<>();
        for (Medicaments medicaments : Medicaments.getMedicaments()) {
            if (medicaments.getNomMedicament().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medicaments);
            }
        }
        return resultats;
    }

    public static List<Medicaments> rechercherParCategorie(String nom) {
        List<Medicaments> resultats = new ArrayList<>();
        for (Medicaments medicaments : Medicaments.getMedicaments()) {
            if (medicaments.getCategorieMedicament().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medicaments);
            }
        }
        return resultats;
    }

    private static void afficherTousLesMedicaments() {
        for (Medicaments medicament : Medicaments.getMedicaments()) {
            System.out.println("==================================");
            System.out.println(medicament);
        }
    }

    public static void afficherResultatsMedicamentsParCategorie(String nomCategorie) {
        List<Medicaments> resultats = rechercherParCategorie(nomCategorie);
            if (resultats.isEmpty()) {
                System.out.println("Aucun médicament trouvé pour la catégorie : " + nomCategorie);
            } else {
                System.out.println("Médicaments trouvés pour la catégorie : " + nomCategorie);
                for (Medicaments medicament : resultats) {
                    System.out.println("==================================");
                    System.out.println(medicament);
                }
            }
        }



        private static void afficherResultatsClients(List<Clients> clients, String critere) {
        if (clients.isEmpty()) {
            System.out.println("Aucun client trouvé pour : " + critere);
        } else {
            System.out.println("Clients trouvés pour " + critere + " :");
            for (Clients client : clients) {
                System.out.println("==================================");
                System.out.println(client);
            }
        }
    }

    private static void afficherResultatsMedecins(List<Medecins> medecins, String critere) {
        if (medecins.isEmpty()) {
            System.out.println("Aucun médecin trouvé pour : " + critere);
        } else {
            System.out.println("Médecins trouvés pour " + critere + " :");
            for (Medecins medecin : medecins) {
                System.out.println("==================================");
                System.out.println(medecin);
            }
        }
    }

    private static void afficherResultatsMutuelles(List<Mutuelles> mutuelles, String critere) {
        if (mutuelles.isEmpty()) {
            System.out.println("Aucune mutuelle trouvée pour : " + critere);
        } else {
            System.out.println("Mutuelles trouvées pour " + critere + " :");
            for (Mutuelles mutuelle : mutuelles) {
                System.out.println("==================================");
                System.out.println(mutuelle);
            }
        }
    }

    private static void afficherResultatsMedicaments(List<Medicaments> medicaments, String critere) {
        if (medicaments.isEmpty()) {
            System.out.println("Aucun médicament trouvé pour : " + critere);
        } else {
            System.out.println("Médicaments trouvés pour " + critere + " :");
            for (Medicaments medicament : medicaments) {
                System.out.println("==================================");
                System.out.println(medicament);
            }
        }
    }



    private static boolean quitterEtSauvegarder() {
        System.out.println("Sauvegarde en cours...");
        donnees.put("clients", Clients.getClients());
        donnees.put("mutuelles", Mutuelles.getMutuelles());
        donnees.put("medicaments", Medicaments.getMedicaments());
        donnees.put("pharmaciens", Pharmaciens.getPharmaciens());
        donnees.put("medecins", Medecins.getMedecins());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
        System.out.println("Au revoir !");
        return true;
    }
}