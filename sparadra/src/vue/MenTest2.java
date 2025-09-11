package vue;
import controleur.Main;
import exception.SaisieException;
import modele.Client;
import modele.Medecin;
import modele.Medicament;
import modele.Mutuelle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenTest2 {
    public static void main(String[] args) throws SaisieException {
        Main.chargement();
        Scanner scanner = new Scanner(System.in);
        List<Object> resultatsGlobaux = new ArrayList<>();

        System.out.print("Entrez un client à rechercher : \n");
        String recherche = scanner.nextLine();
        List<Client> clientsTrouves = rechercherClientParNom(recherche);
        if (!clientsTrouves.isEmpty()) {
            for (Client client : clientsTrouves) {
                String info = "Client : " + client.getNom() + " " + client.getPrenom();
                resultatsGlobaux.add(info);
            }
            afficherResultatsClients(clientsTrouves, recherche);
        } else {
            System.out.println("Aucun client trouvé pour : " + recherche);
        }

        System.out.println("\nRecherche de médicaments sans ordonnace\n");
        String choix;
        do {
            System.out.print("\nEntrez un médicament à rechercher : ");
            recherche = scanner.nextLine();
            List<Medicament> medicamentsTrouves = rechercherMedicamentsSansOrdonnanceParNom(recherche);

            if (!medicamentsTrouves.isEmpty()) {
                afficherResultatsMedicaments(medicamentsTrouves, recherche);

                for (Medicament medicament : medicamentsTrouves) {
                    System.out.println("Stock actuel : " + medicament.getQuantiteMedicament());
                    System.out.print("Entrez la quantité pour le médicament '" + medicament.getNomMedicament() + "' : ");
                    int quantite;
                    try {
                        quantite = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantité invalide. Quantité 1 assignée par défaut.");
                        quantite = 1;
                    }

                    if (quantite > medicament.getQuantiteMedicament()) {
                        System.out.println("Stock insuffisant pour " + medicament.getNomMedicament() +
                                ". Quantité disponible : " + medicament.getQuantiteMedicament());
                    } else {
                        medicament.retirerDuStock(quantite);
                        String info = "Médicament : " + medicament.getNomMedicament()
                                + " | Quantité : " + quantite
                                + " | Stock restant : " + medicament.getQuantiteMedicament();
                        resultatsGlobaux.add(info);
                    }
                }

            } else {
                System.out.println("Aucun médicament trouvé pour : " + recherche);
            }

            System.out.print("Voulez-vous rechercher un autre médicament ? (oui/non) : ");
            choix = scanner.nextLine().trim().toLowerCase();

        } while (choix.equals("oui"));


        System.out.println("\n=== Résultats globaux de la recherche ===");

        if (resultatsGlobaux.isEmpty()) {
            System.out.println("Aucun résultat trouvé.");
        } else {
            for (Object resultat : resultatsGlobaux) {
                System.out.println("==================================");
                System.out.println(resultat);
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
    public static List<Medicament> rechercherMedicamentsSansOrdonnanceParNom(String nom) {
        List<Medicament> resultats = new ArrayList<>();
        for (Medicament medicament : Medicament.getMedicament()) {
            if (medicament.getSansOrdonnanceMedicament().equalsIgnoreCase("oui") &&
                    medicament.getNomMedicament().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(medicament);
            }
        }
        return resultats;
    }
}
