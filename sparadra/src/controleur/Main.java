package controleur;

import exception.SaisieException;

import java.lang.ref.Cleaner;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

import modele.*;
import utilitaires.PersitSerializable;

import modele.Clients;


public class Main {
    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    public Main() throws SaisieException {
    }

    public static void main(String[] args)throws SaisieException {
        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        List<Mutuelles> mutuelles = (List<Mutuelles>) donnees.getOrDefault("mutuelles", new java.util.ArrayList<>());
        List<Medicaments> medicaments = (List<Medicaments>) donnees.getOrDefault("medicaments", new java.util.ArrayList<>());
        List<Medecins> medecins = (List<Medecins>) donnees.getOrDefault("medecins", new java.util.ArrayList<>());
        List<Pharmaciens> pharmaciens = (List<Pharmaciens>) donnees.getOrDefault("pharmacien", new java.util.ArrayList<>());
        List<Clients> clients = (List<Clients>) donnees.getOrDefault("client", new java.util.ArrayList<>());

    Clients c1 = new Clients("Martin", "Luc", "12 Rue des Lilas", "57000", "Metz", "06 12 34 56 78", "luc.martin@example.com", "123456789012345", "15/06/1980", "Mutuelle A", "Dr Shiva‑Marie Khorsand Taefehnorooz");
    Clients c2 = new Clients("Durand", "Sophie", "5 Avenue Foch", "57100", "Thionville", "06 23 45 67 89", "sophie.durand@example.com", "234567890123456", "22/11/1975", "Mutuelle B", "Dr Eric Partouche");
    Clients c3 = new Clients("Leroy", "Pierre", "8 Rue de la Gare", "54110", "Dombasle-sur-Meurthe", "06 34 56 78 90", "pierre.leroy@example.com", "345678901234567", "03/03/1990", "Mutuelle C", "Dr JACQUIER‑MERCIER Marie");
    Clients c4 = new Clients("Moreau", "Claire", "20 Boulevard des Vosges", "54520", "Laxou", "06 45 67 89 01", "claire.moreau@example.com", "456789012345678", "19/09/1985", "Mutuelle D", "Dr TOURPE Dominique");
    Clients c5 = new Clients("Dubois", "Julien", "14 Rue Anatole France", "54210", "Saint‑Nicolas‑de‑Port", "06 56 78 90 12", "julien.dubois@example.com", "567890123456789", "10/12/1978", "Mutuelle E", "Dr LIGIER Romain");
    Clients c6 = new Clients("Petit", "Amélie", "3 Place Saint‑Louis", "57600", "Forbach", "06 67 89 01 23", "amelie.petit@example.com", "678901234567890", "30/05/1982", "Mutuelle F", "Dr Cécile Flye‑Sainte‑Marie");
    Clients c7 = new Clients("Rousseau", "Antoine", "2 Rue Michel Debré", "57600", "Forbach", "06 78 90 12 34", "antoine.rousseau@example.com", "789012345678901", "25/08/1972", "Mutuelle G", "Dr Ingrid Chiaro");
    Clients c8 = new Clients("Faure", "Laura", "7 Rue des Grands Champs", "57070", "Vantoux", "06 89 01 23 45", "laura.faure@example.com", "890123456789012", "14/02/1992", "Mutuelle H", "Jean‑Louis Mougenel");
    Clients c9 = new Clients("Gauthier", "Nicolas", "1A Rue de Verdun", "57120", "Pierrevillers", "06 90 12 34 56", "nicolas.gauthier@example.com", "901234567890123", "05/07/1988", "Mutuelle I", "Dr Alisson ANCEL");
    Clients c10 = new Clients(" Laurent", "Élodie", "20a Rue de la Gare", "57300", "Hagondange", "06 01 23 45 67", "elodie.laurent@example.com", "012345678901234", "12/10/1995", "Mutuelle J", "Dr Claire PIERRON");

    for (Clients c : Clients.getClients())

    {
        System.out.println("==================================");
        System.out.println(clients);
    }
    }
}