package controleur;

import exception.SaisieException;


import java.util.Map;
import java.util.List;


import modele.*;
import utilitaires.PersitSerializable;

import modele.Clients;


public class Main {
    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    public Main() throws SaisieException {
    }

    public static void main(String[] args) throws SaisieException {
        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        List<Mutuelles> mutuelles = (List<Mutuelles>) donnees.getOrDefault("mutuelles", new java.util.ArrayList<>());
        List<Medicaments> medicaments = (List<Medicaments>) donnees.getOrDefault("medicaments", new java.util.ArrayList<>());
        List<Medecins> medecins = (List<Medecins>) donnees.getOrDefault("medecins", new java.util.ArrayList<>());
        List<Pharmaciens> pharmaciens = (List<Pharmaciens>) donnees.getOrDefault("pharmaciens", new java.util.ArrayList<>());
        List<Clients> clients = (List<Clients>) donnees.getOrDefault("clients", new java.util.ArrayList<>());

        Clients .setClients(clients);
        Mutuelles.setMutuelles(mutuelles);
        Medicaments.setMedicaments(medicaments);
        Medecins.setMedecins(medecins);
        Pharmaciens.setPharmaciens(pharmaciens);

//        Clients c1 = new Clients("martin", "Luc", "12 Rue des Lilas", "57000", "Metz", "06 12 34 56 78", "luc.martin@example.com", "123456789012345", "15/06/1980", "Mutuelle A", "Dr Shiva‑Marie Khorsand Taefehnorooz");
//        Clients c2 = new Clients("Durand", "Sophie", "5 Avenue Foch", "57100", "Thionville", "06 23 45 67 89", "sophie.durand@example.com", "234567890123456", "22/11/1975", "Mutuelle B", "Dr Eric Partouche");
//        Clients c3 = new Clients("Leroy", "Pierre", "8 Rue de la Gare", "54110", "Dombasle-sur-Meurthe", "06 34 56 78 90", "pierre.leroy@example.com", "345678901234567", "03/03/1990", "Mutuelle C", "Dr JACQUIER‑MERCIER Marie");
//        Clients c4 = new Clients("Moreau", "Claire", "20 Boulevard des Vosges", "54520", "Laxou", "06 45 67 89 01", "claire.moreau@example.com", "456789012345678", "19/09/1985", "Mutuelle D", "Dr TOURPE Dominique");
//        Clients c5 = new Clients("Dubois", "Julien", "14 Rue Anatole France", "54210", "Saint‑Nicolas‑de‑Port", "06 56 78 90 12", "julien.dubois@example.com", "567890123456789", "10/12/1978", "Mutuelle E", "Dr LIGIER Romain");
//        Clients c6 = new Clients("Petit", "Amélie", "3 Place Saint‑Louis", "57600", "Forbach", "06 67 89 01 23", "amelie.petit@example.com", "678901234567890", "30/05/1982", "Mutuelle F", "Dr Cécile Flye‑Sainte‑Marie");
//        Clients c7 = new Clients("Rousseau", "Antoine", "2 Rue Michel Debré", "57600", "Forbach", "06 78 90 12 34", "antoine.rousseau@example.com", "789012345678901", "25/08/1972", "Mutuelle G", "Dr Ingrid Chiaro");
//        Clients c8 = new Clients("Faure", "Laura", "7 Rue des Grands Champs", "57070", "Vantoux", "06 89 01 23 45", "laura.faure@example.com", "890123456789012", "14/02/1992", "Mutuelle H", "Jean‑Louis Mougenel");
//        Clients c9 = new Clients("Gauthier", "Nicolas", "1A Rue de Verdun", "57120", "Pierrevillers", "06 90 12 34 56", "nicolas.gauthier@example.com", "901234567890123", "05/07/1988", "Mutuelle I", "Dr Alisson ANCEL");
//        Clients c10 = new Clients("Laurent", "Élodie", "20a Rue de la Gare", "57300", "Hagondange", "06 01 23 45 67", "elodie.laurent@example.com", "012345678901234", "12/10/1995", "Mutuelle J", "Dr Claire PIERRON");
//        Medecins m1 = new Medecins("Bertrand", "Anne", "1 Bis avenue Coteaux", "57155", "Marly", "03 87 69 00 22", "bertrand.anne@example.com", "10002402179");
//        Medecins m2 = new Medecins("Breton", "Jean‑Christophe", "8 Grand'Rue", "57525", "Talange", "03 87 71 48 42", "breton.jc@example.com", "10002383924");
//        Medecins m3 = new Medecins("Albrecht", "Corinne", "1 Bis avenue Coteaux", "57155", "Marly", "03 87 62 38 81", "albrecht.corinne@example.com", "10002378361");
//        Medecins m4 = new Medecins("Piroué", "Elsa", "8 rue Messageries", "57000", "Metz", "03 87 63 26 60", "piroue.elsa@example.com", "10003769360");
//        Medecins m5 = new Medecins("Grosdidier", "Laurène", "1 Bis avenue Coteaux", "57155", "Marly", "03 87 63 39 77", "grosdidier.laurene@example.com", "10101379872");
//        Medecins m6 = new Medecins("Masserann", "Jean Luc", "6 rue Coislin", "57000", "Metz", "03 87 75 21 63", "masserann.jl@example.com", "10002550118");
//        Medecins m7 = new Medecins("Courtalon", "Didier", "12 rue Devilly", "57070", "Metz", "03 87 65 23 23", "courtalon.didier@example.com", "10002357019");
//        Medecins m8 = new Medecins("Dugny", "Christophe", "148 bis rue de Marly", "57950", "Montigny‑lès‑Metz", "03 87 65 79 93", "dugny.christophe@example.com", "10002394921");
//        Medecins m9 = new Medecins("Pellerini", "André", "9 rue de Chatelaillon", "57515", "Alsting", "03 87 00 33 57", "pellerini.andre@example.com", "10002366945");
//        Medecins m10 = new Medecins("Blaise", "Guy", "1 rue du Poitou", "57110", "Yutz", "03 82 56 21 63", "blaise.guy@example.com", "10002364601");
//        Pharmaciens p1 = new Pharmaciens("Brunner", "Jennifer", "10101069606");
//        Pharmaciens p2 = new Pharmaciens("Peltier", "Jean‑Julien", "10001204113");
//        Pharmaciens p3 = new Pharmaciens("Marconato", "Isabelle", "10001195113");
//        Pharmaciens p4 = new Pharmaciens("Schillinger", "Sarah", "10101010101");
//        Pharmaciens p5 = new Pharmaciens("Rowdo", "Lorene", "10010101010");
//        Mutuelles mu1 = new Mutuelles("Caisse Régional Crédit Agricole Mutuelle Lorraine","56 Avenue André Malraux","57000","Metz","09 64 40 37 11","contact@ca-mutu-elle-lorraine.fr","57",70);
//        Mutuelles mu2 = new Mutuelles("Mutuelle Nationale Territoriale - Section Metz","1 rue du Pont Moreau","57000","Metz","03 87 37 58 32","service@mnt.fr","57",75);
//        Mutuelles mu3 = new Mutuelles("MNT (Mutuelle Nationale Territoriale) - Agence Mitterrand","16 avenue François Mitterrand","57000","Metz","09 72 72 02 02","metz@mnt.fr","57",75);
//        Mutuelles mu4 = new Mutuelles("Mutlor - Les Mutuelles de Lorraine","11 Rue du Colonel Merlin","54400","Longwy","03 82 25 79 00","contact@mutlor.fr","57",65);
//        Mutuelles mu5 = new Mutuelles("Mutlor - Les Mutuelles de Lorraine (Nancy)","6 Rue de la Visitation","54000","Nancy","+33 3 83 36 77 07","nancy@mutlor.fr","54",65);
//        Medicaments me1 = new Medicaments("Doliprane", "Antalgique", 2.50, "2021-01-15", 150, "Oui");
//        Medicaments me2 = new Medicaments("Amoxicilline", "Antibiotique", 8.90, "2020-06-30", 75, "Non");
//        Medicaments me3 = new Medicaments("Spasfon", "Antispasmodique", 3.20, "2019-11-10", 120, "Oui");
//        Medicaments me4 = new Medicaments("Ibuprofène", "Anti-inflammatoire", 4.10, "2022-03-01", 200, "Oui");
//        Medicaments me5 = new Medicaments("Ventoline", "Bronchodilatateur", 15.00, "2018-05-25", 50, "Non");
//        Medicaments me6 = new Medicaments("Xanax", "Anxiolytique", 12.75, "2017-09-12", 30, "Non");
//        Medicaments me7 = new Medicaments("Efferalgan", "Antalgique", 2.90, "2020-12-20", 180, "Oui");
//        Medicaments me8 = new Medicaments("Aspirine", "Anticoagulant", 3.00, "2016-07-14", 90, "Oui");
//        Medicaments me9 = new Medicaments("Zyrtec", "Antihistaminique", 6.50, "2021-04-08", 110, "Oui");
//        Medicaments me10 = new Medicaments("Levothyrox", "Hormonothérapie", 9.60, "2015-02-01", 60, "Non");


        for (Clients clients1 : Clients.getClients()) {
            System.out.println("\n==================================\n");
            System.out.println(clients1);
        }
        System.out.println("==================================");
        for (Medecins medecins1 : Medecins.getMedecins()) {
            System.out.println("\n==================================\n");
            System.out.println(medecins1);
        }
        System.out.println("==================================");
        for (Pharmaciens pharmaciens1 : Pharmaciens.getPharmaciens()) {
            System.out.println("\n==================================\n");
            System.out.println(pharmaciens1);
        }
        System.out.println("==================================");
        for (Mutuelles mutuelles1 : Mutuelles.getMutuelles()) {
            System.out.println("\n==================================\n");
            System.out.println(mutuelles1);
        }
        System.out.println("==================================");
        for (Medicaments medicaments1 : Medicaments.getMedicaments()) {
            System.out.println("\n==================================\n");
            System.out.println(medicaments1);
        }
        System.out.println("\n==================================\n");
        System.out.println("Sauvegarde en cours...");
        donnees.put("clients", Clients.getClients());
        donnees.put("mutuelles", Mutuelles.getMutuelles());
        donnees.put("medicaments", Medicaments.getMedicaments());
        donnees.put("pharmaciens", Pharmaciens.getPharmaciens());
        donnees.put("medecins", Medecins.getMedecins());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
    }
}