package vue;

import exception.SaisieException;
import modele.*;
import utilitaires.PersitSerializable;
import utilitaires.Saisie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static vue.Vue.afficherListeVentes;

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
                    case 1 -> rechercherClientParNom();
                    case 2 -> rechercherClientParNSS();
                    case 3 -> rechercherClientParEmail();
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
                    case 1 -> rechercherMedecinParNom();
                    case 2 -> rechercherMedecinParRPPS();
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
                    case 1 -> rechercherMutuelleParNom();
                    case 2 -> rechercherMutuelleParDepartement();
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
                    case 1 -> rechercherMedicamentParNom();
                    case 2 -> rechercherMedicamentParCategorie();
                    case 3 -> afficherTousLesMedicaments();
                    default -> System.err.println("Choix entre 0-3");
            }
        }
    }

    public static List<> rechercherClient(String nom) {
        List<Clients> resultats = new ArrayList<>();
        for (Abonnes abonne : abonnes) {
            if (abonne.getMail().toLowerCase().contains(email.toLowerCase())) {
                resultats.add(abonne);
            }
        }
        return resultats;
    }

    private static void rechercherClientParNom() {
        System.out.print("Nom du client à rechercher : ");
        String nom = Saisie.lireChaine();

        List<Clients> clientsTrouves = Clients.getClients().stream()
                .filter(c -> c.getNom().toLowerCase().contains(nom.toLowerCase()))
                .toList();

        afficherResultatsClients(clientsTrouves, "nom \"" + nom + "\"");
    }

    private static void rechercherClientParNSS() {
        System.out.print("Numéro de sécurité sociale : ");
        String nss = Saisie.lireChaine();

        List<Clients> clientsTrouves = Clients.getClients().stream()
                .filter(c -> c.getNSs().equals(nss))
                .toList();

        afficherResultatsClients(clientsTrouves, "NSS \"" + nss + "\"");
    }

    private static void rechercherClientParEmail() {
        System.out.print("Email du client : ");
        String email = Saisie.lireChaine();

        List<Clients> clientsTrouves = Clients.getClients().stream()
                .filter(c -> c.getEmail().toLowerCase().contains(email.toLowerCase()))
                .toList();

        afficherResultatsClients(clientsTrouves, "email \"" + email + "\"");
    }

    // Méthodes de recherche pour les médecins
    private static void rechercherMedecinParNom() {
        System.out.print("Nom du médecin à rechercher : ");
        String nom = Saisie.lireChaine();

        List<Medecins> medecinsTrouves = Medecins.getMedecins().stream()
                .filter(m -> m.getNom().toLowerCase().contains(nom.toLowerCase()) ||
                        m.getPrenom().toLowerCase().contains(nom.toLowerCase()))
                .toList();

        afficherResultatsMedecins(medecinsTrouves, "nom \"" + nom + "\"");
    }

    private static void rechercherMedecinParRPPS() {
        System.out.print("Numéro RPPS : ");
        String rpps = Saisie.lireChaine();

        List<Medecins> medecinsTrouves = Medecins.getMedecins().stream()
                .filter(m -> m.getRPPS().equals(rpps))
                .toList();

        afficherResultatsMedecins(medecinsTrouves, "RPPS \"" + rpps + "\"");
    }

    private static void afficherTousLesMedecins() {
        afficherResultatsMedecins(Medecins.getMedecins(), "tous les médecins");
    }

    // Méthodes de recherche pour les mutuelles
    private static void rechercherMutuelleParNom() {
        System.out.print("Nom de la mutuelle : ");
        String nom = Saisie.lireChaine();

        List<Mutuelles> mutuellesTrouvees = Mutuelles.getMutuelles().stream()
                .filter(m -> m.getNom().toLowerCase().contains(nom.toLowerCase()))
                .toList();

        afficherResultatsMutuelles(mutuellesTrouvees, "nom \"" + nom + "\"");
    }

    private static void rechercherMutuelleParDepartement() {
        System.out.print("Département : ");
        String departement = Saisie.lireChaine();

        List<Mutuelles> mutuellesTrouvees = Mutuelles.getMutuelles().stream()
                .filter(m -> m.getDepartement().toLowerCase().contains(departement.toLowerCase()))
                .toList();

        afficherResultatsMutuelles(mutuellesTrouvees, "département \"" + departement + "\"");
    }

    private static void afficherToutesLesMutuelles() {
        afficherResultatsMutuelles(Mutuelles.getMutuelles(), "toutes les mutuelles");
    }

    // Méthodes de recherche pour les médicaments
    private static void rechercherMedicamentParNom() {
        System.out.print("Nom du médicament : ");
        String nom = Saisie.lireChaine();

        List<Medicaments> medicamentsTrouves = Medicaments.getMedicaments().stream()
                .filter(m -> m.getNomMedicament().toLowerCase().contains(nom.toLowerCase()))
                .toList();

        afficherResultatsMedicaments(medicamentsTrouves, "nom \"" + nom + "\"");
    }

    private static void rechercherMedicamentParCategorie() {
        System.out.print("Catégorie : ");
        String categorie = Saisie.lireChaine();

        List<Medicaments> medicamentsTrouves = Medicaments.getMedicaments().stream()
                .filter(m -> m.getCategorieMedicament().toLowerCase().contains(categorie.toLowerCase()))
                .toList();

        afficherResultatsMedicaments(medicamentsTrouves, "catégorie \"" + categorie + "\"");
    }

    private static void afficherTousLesMedicaments() {
        afficherResultatsMedicaments(Medicaments.getMedicaments(), "tous les médicaments");
    }

    // Méthodes d'affichage des résultats
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