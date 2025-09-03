package vue;

public class Menu {
    Scanner sc = new Scanner(System.in);
    boolean fin = false;
    while(!fin){
        Vue.vueMenu();
        Vue.vueMenuglobal();
        int choix = Saisie.lireEntier("Votre Choix [1 -6] ou [0] pour quitter : ", "un nombre positif");

        switch (choix) {
            case 0 -> fin = quitterEtSauvegarder(donnees);
            case 1 -> Vue.vueCreation();
            case 2 -> Vue.vueCreaLivre();
            case 3 -> menuGestionLivres();
            case 4 -> afficherAbonnes();
            case 5 -> afficherLivres();
            case 6 -> afficherPrets();
            default -> System.err.println("! Choix incorrect ! [0-6] !");
        }
    }

    private static boolean quitterEtSauvegarder(Map<String, Object> donnees) {
        System.out.println("Sauvegarde en cours...");
        donnees.put("abonnes", Abonnes.getAbonnes());
        donnees.put("employes", Employe.getEmployees());
        donnees.put("livres", Livre.getLivres());
        donnees.put("prets", Livreprete.getLivrepretes());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
        System.out.println("Au revoir !");
        return true;
    }

    private static void menuGestionLivres() throws SaisieException {
        boolean fin = false;

        while (!fin) {
            Vue.vueMenu();
            Vue.vueMenuLivre();
            int choix = Saisie.lireEntier("Votre Choix [1 -5] ou [0] pour retourner au menu principal : ", "Un nombre");

            switch (choix) {
                case 0 -> fin = true;
                case 1 -> menuRechercheLivre();
                case 2 -> menuRechercheAbonne();
                case 3 -> System.out.println("test3");
                case 4 -> System.out.println("test4");
                case 5 -> System.out.println("test5");
                default -> System.err.println("Choix entre 1-5");
            }
        }
    }
    private static void menuRechercheLivre() throws SaisieException {
        boolean fin = false;

        while (!fin) {
            Vue.vueMenu();
            Vue.vueMenuRechLivre();
            int choix = Saisie.lireEntier("Votre Choix [1 -3] ou [0] pour quitter : ", "un NOMBRE !!!!");

            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    String isbn = Vue.saisieISBN("ISBN :", "10 ou 13 chiffres");
                    Livre livre = Livre.rechercherParISBN(isbn);
                    System.out.println((livre != null) ? "Livre trouvé :\n" + livre : "Aucun livre trouvé avec cet ISBN.");
                }
                case 2 -> {
                    String titre = Vue.saisieAuteur("Titre ?", "Pas d'espace avant et après");
                    afficherListeLivres(Livre.rechercherParTitre(titre), "titre \"" + titre + "\"");
                }
                case 3 -> {
                    String auteur = Vue.saisieAuteur("Auteur ?", "Pas d'espace avant et après");
                    afficherListeLivres(Livre.rechercherParAuteur(auteur), "auteur \"" + auteur + "\"");
                }
                default -> System.err.println("Choix entre 1-3");
            }
        }
    }

    private static void afficherListeLivres(List<Livre> livres, String critere) {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre trouvé pour : " + critere);
        } else {
            System.out.println("Livres trouvés pour " + critere + " :");
            for (Livre l : livres) {
                System.out.println("-------------------------");
                System.out.println(l);
            }
        }
    }

👤 Recherche d’abonné

    private static void menuRechercheAbonne() throws SaisieException {
        boolean fin = false;

        while (!fin) {
            Vue.vueMenu();
            Vue.vueMenuAbonne();
            int choix = Saisie.lireEntier("Votre Choix [1 -2] ou [0] pour quitter : ", "un nombre entre 0 et 3");

            switch (choix) {
                case 0 -> fin = true;
                case 1 -> {
                    String nom = Vue.saisieAuteur("Recherche par Nom ?", "Pas d'espace avant et après");
                    afficherListeAbonnes(Abonnes.rechercherNom(nom), nom);
                }
                case 2 -> {
                    String email = Vue.saisieMailUtilisateur("Recherche par Email ?", "Pas d'espace avant et après");
                    afficherListeAbonnes(Abonnes.rechercherEmail(email), email);
                }
                default -> System.err.println("Choix entre 1-2");
            }
        }
    }

    private static void afficherListeAbonnes(List<Abonnes> liste, String critere) {
        if (liste.isEmpty()) {
            System.out.println("Aucun résultat trouvé pour : " + critere);
        } else {
            System.out.println("Résultats pour \"" + critere + "\" :");
            for (Abonnes abonne : liste) {
                System.out.println("-------------------------");
                System.out.println(abonne);
            }
        }
    }

📋 Affichage des listes

    private static void afficherAbonnes() {
        System.out.println("----- Liste des abonnés -----");
        for (Abonnes abonne : Abonnes.getAbonnes()) {
            System.out.println("-------------------------");
            System.out.println(abonne);
        }
    }

    private static void afficherLivres() {
        System.out.println("----- Liste des livres -----");
        for (Livre livre : Livre.getLivres()) {
            System.out.println("-------------------------");
            System.out.println(livre);
        }
    }

    private static void afficherPrets() throws SaisieException {
        System.out.println("----- Liste des prêts -----");
        Livreprete pretExemple = new Livreprete(Livre.getLivres().get(0), Abonnes.getAbonnes().get(0), Employe.getEmployees().get(0));
        for (Livreprete pret : Livreprete.getLivrepretes()) {
            System.out.println("-------------------------");
            System.out.println(pret);
        }
    }
}
