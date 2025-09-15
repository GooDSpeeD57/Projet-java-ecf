package controleur;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;

import modele.*;
import exception.SaisieException;
import utilitaires.PersitSerializable;

public class MainSwing extends JFrame {

    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    // Composants principaux
    private JTabbedPane tabbedPane;
    private JPanel panelAccueil, panelClient, panelMedecin, panelMutuelle,panelOrdonnance, panelMedicament,panelHistorique;

    // Tables pour affichage des données
    private JTable tableClient, tableMedecin, tableMutuelle, tableMedicament, tableHistorique,tableOrdonnance;
    private DefaultTableModel modelClient, modelMedecin, modelMutuelle,modelOrdonnance, modelMedicament, modelHistorique;

    // Composants de saisie
    private JTextField txtNom, txtPrenom,txtAdresse,txtCodePostal,txtVille,txtTelephone, txtEmail,txtNss,txtDateNaissance,txtMutuelle,txtMedecinref;
    private JTextField txtRPPS,txtDepartement,txtTauxRb;
    private JTextField txtNomMedicament,txtCategoriMedicament,txtPrixMedicament,txtDateMiseCirculation,txtSansOrdonnanceMedicament;
    private JTextField txtRechercheNom,txtRecherchenSS,txtRechercheEmail,txtRechercheRpps,txtRechercheDepartement;
    private JTextField txtRechercheNomMedicament,txtRechercheCategorieMedicament;

    public MainSwing() {
        chargerDonnees();
        initComponents();
        chargerDonneesDansGUI();
    }

    private void chargerDonnees() {
        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
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

    private void initComponents() {
        setTitle("Système de Gestion de Pharmacie");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Gestionnaire de fermeture avec sauvegarde
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sauvegarderEtQuitter();
            }
        });

        // Création du menu
        creerMenu();

        // Création des onglets
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));

        creerPanelAccueil();
        creerPanelClient();
        creerPanelMedecin();
        creerPanelMutuelle();
        creerPanelMedicament();
        creerPanelOrdonnance();
        creerPanelHistorique();

        tabbedPane.addTab("Accueil", panelAccueil);
        tabbedPane.addTab("Clients", panelClient);
        tabbedPane.addTab("Médecins", panelMedecin);
        tabbedPane.addTab("Mutuelles", panelMutuelle);
        tabbedPane.addTab("Médicaments", panelMedicament);
        tabbedPane.addTab("Historique", panelHistorique);
        tabbedPane.addTab("Ordonnance", panelOrdonnance);

        add(tabbedPane);

        // Style général
    }


    private void creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem itemQuitter = new JMenuItem("Quitter");

        itemSauvegarder.addActionListener(e -> sauvegarder());
        itemQuitter.addActionListener(e -> sauvegarderEtQuitter());

        menuFichier.add(itemSauvegarder);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);

        JMenu menuAide = new JMenu("Aide");
        JMenuItem itemAPropos = new JMenuItem("À propos");
        itemAPropos.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Système de Gestion de Pharmacie\nVersion 1.0\n\nDéveloppé avec Java Swing Par Julien Taesch",
                        "À propos",
                        JOptionPane.INFORMATION_MESSAGE)
        );
        menuAide.add(itemAPropos);

        menuBar.add(menuFichier);
        menuBar.add(menuAide);
        setJMenuBar(menuBar);
    }

    private void creerPanelAccueil() {
        panelAccueil = new JPanel(new BorderLayout());
        panelAccueil.setBackground(new Color(240, 248, 255));

        // Panel de bienvenue
        JPanel panelBienvenue = new JPanel();
        panelBienvenue.setBackground(new Color(240, 248, 255));
        panelBienvenue.setLayout(new BoxLayout(panelBienvenue, BoxLayout.Y_AXIS));

        JLabel lblTitre = new JLabel("Bienvenue dans le Système de Pharmacie");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitre.setForeground(new Color(34, 89, 7));

        JLabel lblSousTitre = new JLabel("Gestion complète de votre Pharmacie");
        lblSousTitre.setFont(new Font("Arial", Font.ITALIC, 16));
        lblSousTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSousTitre.setForeground(new Color(99, 180, 70));

        panelBienvenue.add(Box.createVerticalGlue());
        panelBienvenue.add(lblTitre);
        panelBienvenue.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBienvenue.add(lblSousTitre);
        panelBienvenue.add(Box.createVerticalGlue());

        // Panel des statistiques
        JPanel panelStats = new JPanel(new GridLayout(2, 2, 10, 10));
        panelStats.setBorder(new TitledBorder("Statistiques"));
        panelStats.setBackground(new Color(240, 248, 255));

        JLabel lblNbClient = new JLabel("Clients : " + Client.getClient().size(), SwingConstants.CENTER);
        JLabel lblNbMedicament = new JLabel("Médicaments : " + Medicament.getMedicament().size(), SwingConstants.CENTER);
        JLabel lblNbMedecin = new JLabel("Médecins : " + Medecin.getMedecin().size(), SwingConstants.CENTER);
        JLabel lblNbMutuelle = new JLabel("Mutelle : " + Mutuelle.getMutuelle().size(), SwingConstants.CENTER);

        Font fontStats = new Font("Arial", Font.BOLD, 14);
        lblNbClient.setFont(fontStats);
        lblNbMedicament.setFont(fontStats);
        lblNbMedecin.setFont(fontStats);
        lblNbMutuelle.setFont(fontStats);

        panelStats.add(lblNbClient);
        panelStats.add(lblNbMedicament);
        panelStats.add(lblNbMedecin);
        panelStats.add(lblNbMutuelle);

        panelAccueil.add(panelBienvenue, BorderLayout.CENTER);
        panelAccueil.add(panelStats, BorderLayout.SOUTH);
    }

    private void creerPanelClient() {
        panelClient = new JPanel(new BorderLayout());

        // Panel de saisie
        JPanel panelSaisieClient = new JPanel(new GridBagLayout());
        panelSaisieClient.setBorder(new TitledBorder("Nouveau Client"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Champs de saisie
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieClient.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNom = new JTextField(15);
        panelSaisieClient.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Prénom"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtPrenom = new JTextField(15);
        panelSaisieClient.add(txtPrenom, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Adresse"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtAdresse = new JTextField(15);
        panelSaisieClient.add(txtAdresse, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieClient.add(new JLabel("Code Postal"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtCodePostal = new JTextField(15);
        panelSaisieClient.add(txtCodePostal, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Ville"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtVille = new JTextField(15);
        panelSaisieClient.add(txtVille, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieClient.add(new JLabel("Telephone Fixe/Portable"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTelephone = new JTextField(15);
        panelSaisieClient.add(txtTelephone, gbc);

        gbc.gridx = 2; gbc.gridy = 0; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Email"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(15);
        panelSaisieClient.add(txtEmail, gbc);

        gbc.gridx = 2; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Numéro de Sécurite Social"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNss = new JTextField(15);
        panelSaisieClient.add(txtNss, gbc);

        gbc.gridx = 2; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieClient.add(new JLabel("Date de Naissance"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtDateNaissance = new JTextField(15);
        panelSaisieClient.add(txtDateNaissance, gbc);

        gbc.gridx = 2; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Mutuelle"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtMutuelle = new JTextField(15);
        panelSaisieClient.add(txtMutuelle, gbc);

        gbc.gridx = 2; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE;
        panelSaisieClient.add(new JLabel("Médecin Réferent "), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtMedecinref = new JTextField(15);
        panelSaisieClient.add(txtMedecinref, gbc);

        // Boutons
        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnVider = new JButton("Vider");

        btnAjouter.addActionListener(e -> ajouterClient());
        btnVider.addActionListener(e -> viderChampsClient());

        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnVider);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panelSaisieClient.add(panelBoutons, gbc);

        // Panel de recherche
        JPanel panelRechercheClient = new JPanel(new GridBagLayout());
        panelRechercheClient.setBorder(new TitledBorder("Recherche"));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRechercheClient.add(new JLabel("Par nom:"), gbc);
        gbc.gridx = 1;
        txtRechercheNom = new JTextField(15);
        panelRechercheClient.add(txtRechercheNom, gbc);
        gbc.gridx = 2;
        JButton btnRechercheNom = new JButton("🔍");
        btnRechercheNom.addActionListener(e -> rechercherClientParNom());
        panelRechercheClient.add(btnRechercheNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRechercheClient.add(new JLabel("Par email:"), gbc);
        gbc.gridx = 1;
        txtRechercheEmail = new JTextField(15);
        panelRechercheClient.add(txtRechercheEmail, gbc);
        gbc.gridx = 2;
        JButton btnRechercheEmail = new JButton("🔍");
        btnRechercheEmail.addActionListener(e -> rechercherClientParEmail());
        panelRechercheClient.add(btnRechercheEmail, gbc);

        JButton btnAfficherTous = new JButton("Afficher tous");
        btnAfficherTous.addActionListener(e -> chargerClient());
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
        panelRechercheClient.add(btnAfficherTous, gbc);

        // Panel supérieur
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        panelSuperior.add(panelSaisieClient);
        panelSuperior.add(panelRechercheClient);

        // Table des clients
        String[] colonnesClient = {"Nom", "Prénom", "Adresse","Code Postal","Ville","Télephone","Email","N° de Sécurité Social","Date de Naissance",
                "Mutuelle","MedecinRef"};
        modelClient = new DefaultTableModel(colonnesClient, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableClient = new JTable(modelClient);
        tableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollClient = new JScrollPane(tableClient);
        scrollClient.setBorder(new TitledBorder(" Liste des Clients"));

        panelClient.add(panelSuperior, BorderLayout.NORTH);
        panelClient.add(scrollClient, BorderLayout.CENTER);
    }

    private void creerPanelMedecin() {
        panelMedecin = new JPanel(new BorderLayout());

        // Panel de saisie medecin
        JPanel panelSaisieMedecin = new JPanel(new GridBagLayout());
        panelSaisieMedecin.setBorder(new TitledBorder("Nouveau Médecin"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Champs de saisie
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMedecin.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNom = new JTextField(15);
        panelSaisieMedecin.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMedecin.add(new JLabel("Prénom"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtPrenom = new JTextField(15);
        panelSaisieMedecin.add(txtPrenom, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMedecin.add(new JLabel("Adresse"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtAdresse = new JTextField(15);
        panelSaisieMedecin.add(txtAdresse, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMedecin.add(new JLabel("Code Postal"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtCodePostal = new JTextField(15);
        panelSaisieMedecin.add(txtCodePostal, gbc);

        gbc.gridx = 2; gbc.gridy = 0; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMedecin.add(new JLabel("Ville"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtVille = new JTextField(15);
        panelSaisieMedecin.add(txtVille, gbc);

        gbc.gridx = 2; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMedecin.add(new JLabel("Telephone Fixe/Portable"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTelephone = new JTextField(15);
        panelSaisieMedecin.add(txtTelephone, gbc);

        gbc.gridx = 2; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMedecin.add(new JLabel("Email"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(15);
        panelSaisieMedecin.add(txtEmail, gbc);

        gbc.gridx = 2; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMedecin.add(new JLabel("Numéro de Répertoire Partagé des Professionnels de Sante "), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtRPPS = new JTextField(15);
        panelSaisieMedecin.add(txtRPPS, gbc);

        JPanel panelBoutonsMedecin = new JPanel(new FlowLayout());
        JButton btnAjouterMedecin = new JButton("Ajouter");
        JButton btnViderMedecin = new JButton("Vider");

        btnAjouterMedecin.addActionListener(e -> ajouterMedecin());
        btnViderMedecin.addActionListener(e -> viderChampsMedecin());

        panelBoutonsMedecin.add(btnAjouterMedecin);
        panelBoutonsMedecin.add(btnViderMedecin);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panelSaisieMedecin.add(panelBoutonsMedecin, gbc);

        // Panel de recherche medecin
        JPanel panelRechercheMedecin = new JPanel(new GridBagLayout());
        panelRechercheMedecin.setBorder(new TitledBorder("Recherche"));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRechercheMedecin.add(new JLabel("Par ISBN:"), gbc);
        gbc.gridx = 1;
        txtRechercheNom = new JTextField(15);
        panelRechercheMedecin.add(txtRechercheNom, gbc);
        gbc.gridx = 2;
        JButton btnRechercheNom = new JButton("🔍");
        btnRechercheNom.addActionListener(e -> Medecin.rechercherParNom(txtRechercheNom.getText()));
        panelRechercheMedecin.add(btnRechercheNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRechercheMedecin.add(new JLabel("Par Numéro de Répertoire Partagé des Professionnels de Sante :"), gbc);
        gbc.gridx = 1;
        txtRechercheRpps = new JTextField(15);
        panelRechercheMedecin.add(txtRechercheRpps, gbc);
        gbc.gridx = 2;
        JButton btnRechercheRpps = new JButton("🔍");
        btnRechercheRpps.addActionListener(e -> Medecin.rechercherParRpps(txtRechercheRpps.getText()));
        panelRechercheMedecin.add(btnRechercheRpps, gbc);

        JButton btnAfficherTousMedecins = new JButton("📋 Afficher tous");
        btnAfficherTousMedecins.addActionListener(e -> chargerMedecin());
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
        panelRechercheMedecin.add(btnAfficherTousMedecins, gbc);

        JPanel panelSuperiorLivre = new JPanel(new GridLayout(1, 2));
        panelSuperiorLivre.add(panelSaisieMedecin);
        panelSuperiorLivre.add(panelRechercheMedecin);

        // Table des Medecins
        String[] colonnesMedecins = {"Nom", "Prénom", "Adresse","Code Postal","Ville","Télephone","Email","RPPS"};
        modelMedecin = new DefaultTableModel(colonnesMedecins, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableMedecin = new JTable(modelMedecin);
        tableMedecin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollMedecin = new JScrollPane(tableMedecin);
        scrollMedecin.setBorder(new TitledBorder("Liste des Médecins"));

        panelMedecin.add(panelSuperiorLivre, BorderLayout.NORTH);
        panelMedecin.add(scrollMedecin, BorderLayout.CENTER);
    }

    private void creerPanelMutuelle() {
        panelMutuelle = new JPanel(new BorderLayout());

        // Panel de saisie mutuelle
        JPanel panelSaisieMutuelle = new JPanel(new GridBagLayout());
        panelSaisieMutuelle.setBorder(new TitledBorder("Nouvelle Mutuelle"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Champs de saisie
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMutuelle.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNom = new JTextField(15);
        panelSaisieMutuelle.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMutuelle.add(new JLabel("Adresse"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtAdresse = new JTextField(15);
        panelSaisieMutuelle.add(txtAdresse, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMutuelle.add(new JLabel("Code Postal"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtCodePostal = new JTextField(15);
        panelSaisieMutuelle.add(txtCodePostal, gbc);

        gbc.gridx = 2; gbc.gridy = 0; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMutuelle.add(new JLabel("Ville"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtVille = new JTextField(15);
        panelSaisieMutuelle.add(txtVille, gbc);

        gbc.gridx = 2; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieMutuelle.add(new JLabel("Telephone Fixe/Portable"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTelephone = new JTextField(15);
        panelSaisieMutuelle.add(txtTelephone, gbc);

        gbc.gridx = 2; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMutuelle.add(new JLabel("Email"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(15);
        panelSaisieMutuelle.add(txtEmail, gbc);

        gbc.gridx = 2; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMutuelle.add(new JLabel("Département "), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtDepartement = new JTextField(15);
        panelSaisieMutuelle.add(txtDepartement, gbc);

        gbc.gridx = 2; gbc.gridy = 4; gbc.fill = GridBagConstraints.NONE;
        panelSaisieMutuelle.add(new JLabel("Taux de Rembourement"), gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTauxRb = new JTextField(15);
        panelSaisieMutuelle.add(txtTauxRb, gbc);


        JPanel panelBoutonsMutuelle = new JPanel(new FlowLayout());
        JButton btnAjouterMutuelle = new JButton("Ajouter");
        JButton btnViderMutuelle = new JButton("Vider");

        btnAjouterMutuelle.addActionListener(e -> ajouterMutuelle());
        btnViderMutuelle.addActionListener(e -> viderChampsMutuelle());

        panelBoutonsMutuelle.add(btnAjouterMutuelle);
        panelBoutonsMutuelle.add(btnViderMutuelle);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panelSaisieMutuelle.add(panelBoutonsMutuelle, gbc);

        // Panel de recherche mutuelle
        JPanel panelRechercheMutuelle = new JPanel(new GridBagLayout());
        panelRechercheMutuelle.setBorder(new TitledBorder("Recherche"));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRechercheMutuelle.add(new JLabel("Par Nom:"), gbc);
        gbc.gridx = 1;
        txtRechercheNom = new JTextField(15);
        panelRechercheMutuelle.add(txtRechercheNom, gbc);
        gbc.gridx = 2;
        JButton btnRechercheNom = new JButton("🔍");
        btnRechercheNom.addActionListener(e -> rechercherMutuelleparNom());
        panelRechercheMutuelle.add(btnRechercheNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRechercheMutuelle.add(new JLabel("Par Numéro de Répertoire Partagé des Professionnels de Sante :"), gbc);
        gbc.gridx = 1;
        txtRechercheDepartement = new JTextField(15);
        panelRechercheMutuelle.add(txtRechercheDepartement, gbc);
        gbc.gridx = 2;
        JButton btnRechercheDepartement = new JButton("🔍");
        btnRechercheDepartement.addActionListener(e -> rechercherMutelleparDepartement());
        panelRechercheMutuelle.add(btnRechercheDepartement, gbc);


        JPanel panelSuperiorMutuelle = new JPanel(new GridLayout(1, 2));
        panelSuperiorMutuelle.add(panelSaisieMutuelle);
        panelSuperiorMutuelle.add(panelRechercheMutuelle);

        // Table des Mutuelle
        String[] colonnesMutuelle = {"Nom","Adresse","Code Postal","Ville","Télephone","Email","Département","Remboursement"};
        modelMutuelle = new DefaultTableModel(colonnesMutuelle, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableMutuelle = new JTable(modelMutuelle);
        tableMutuelle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollMutuelle = new JScrollPane(tableMutuelle);
        scrollMutuelle.setBorder(new TitledBorder("Liste des Mutuelle"));

        panelMutuelle.add(panelSuperiorMutuelle, BorderLayout.NORTH);
        panelMedecin.add(scrollMutuelle, BorderLayout.CENTER);
    }
    private void creerPanelOrdonnance() {
        panelOrdonnance = new JPanel(new BorderLayout());

        // Panel de création d'ordonnance
        JPanel panelCreationOrdonnance = new JPanel(new FlowLayout());
        panelCreationOrdonnance.setBorder(new TitledBorder("➕ Nouvelle Ordonnance"));

        JButton btnNouvelleOrdo = new JButton("📋 Créer un prêt");
        btnNouvelleOrdo.setFont(new Font("Arial", Font.BOLD, 14));
        btnNouvelleOrdo.addActionListener(e -> ouvrirDialogueCreationOrdo());

        JButton btnActualiserOrdo = new JButton("🔄 Actualiser");
        btnActualiserOrdo.addActionListener(e -> chargerOrdo());

        panelCreationOrdonnance.add(btnNouvelleOrdo);
        panelCreationOrdonnance.add(btnActualiserOrdo);

        // Table des Ordonnances
        String[] colonnesOrdo = {"Nom", "Prenom", "Médecin Nom","Medecin Prénom", "Mutuelle"};
        modelOrdonnance = new DefaultTableModel(colonnesOrdo, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableOrdonnance = new JTable(modelOrdonnance);
        tableOrdonnance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollOrdonnance = new JScrollPane(tableOrdonnance);
        scrollOrdonnance.setBorder(new TitledBorder("📋 Liste des Prêts"));

        panelOrdonnance.add(panelCreationOrdonnance, BorderLayout.NORTH);
        panelOrdonnance.add(scrollOrdonnance, BorderLayout.CENTER);
    }

    private void creerPanelRapports() {
        panelRapports = new JPanel(new BorderLayout());

        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnRapportAbonnes = new JButton("👥 Rapport Abonnés");
        JButton btnRapportLivres = new JButton("📚 Rapport Livres");
        JButton btnRapportPrets = new JButton("📋 Rapport Prêts");

        btnRapportAbonnes.addActionListener(e -> genererRapportAbonnes());
        btnRapportLivres.addActionListener(e -> genererRapportLivres());
        btnRapportPrets.addActionListener(e -> genererRapportPrets());

        panelBoutons.add(btnRapportAbonnes);
        panelBoutons.add(btnRapportLivres);
        panelBoutons.add(btnRapportPrets);

        JTextArea textAreaRapport = new JTextArea();
        textAreaRapport.setEditable(false);
        textAreaRapport.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollRapport = new JScrollPane(textAreaRapport);
        scrollRapport.setBorder(new TitledBorder("📊 Rapport"));

        panelRapports.add(panelBoutons, BorderLayout.NORTH);
        panelRapports.add(scrollRapport, BorderLayout.CENTER);
    }

    // Méthodes de chargement des données
    private void chargerDonneesDansGUI() {
        chargerClient();
        chargerMedecin();
        chargerMutuelle();
        chargerMedicament
    }

    private void chargerClient() {
        modelClient.setRowCount(0); // Vide les anciennes lignes

        for (Client client : Client.getClient()) {
            modelClient.addRow(new Object[]{
                    client.getNom(),
                    client.getPrenom(),
                    client.getAdresse(),
                    client.getCodePostal(),
                    client.getVille(),
                    client.getTelephone(),
                    client.getEmail(),
                    client.getNSs(),
                    client.getDateNaissance(),
                    client.getMutuelle(),
                    client.getMedecinRef()
            });
        }
    }

    private void chargerMedecin() {
        modelMedecin.setRowCount(0);
        for (Medecin medecin : Medecin.getMedecin()) {
            modelMedecin.addRow(new Object[]{
                    medecin.getNom(),
                    medecin.getPrenom(),
                    medecin.getAdresse(),
                    medecin.getCodePostal(),
                    medecin.getVille(),
                    medecin.getTelephone(),
                    medecin.getEmail(),
                    medecin.getRPPS()
            });
        }
    }


    private void chargerPrets() {
        modelPrets.setRowCount(0);
        for (Livreprete pret : Livreprete.getLivrepretes()) {
            modelPrets.addRow(new Object[]{
                    pret.getLivre().getTitre(),
                    pret.getAbonnes().getNom() + " " + pret.getAbonnes().getPrenom(),
                    pret.getEmploye().getNom() + " " + pret.getEmploye().getPrenom(),
                    pret.getDatePret(),
                    pret.getDateRetour()
            });
        }
    }

    // Méthodes d'action
    private void ajouterClient() {
        try {

            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String adresse = txtAdresse.getText().trim();
            String codePostal = txtCodePostal.getText().trim();
            String ville = txtVille.getText().trim();
            String telephone = txtTelephone.getText().trim();
            String email = txtEmail.getText().trim();
            String nSs = txtNss.getText().trim();
            String dateNaissance = txtDateNaissance.getText().trim();
            String mutuelle = txtMutuelle.getText().trim();
            String medecinRef = txtMedecinref.getText().trim();


            if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || codePostal.isEmpty() ||
                    ville.isEmpty() || telephone.isEmpty() || email.isEmpty() || nSs.isEmpty() ||
                    dateNaissance.isEmpty() || mutuelle.isEmpty() || medecinRef.isEmpty()) {

                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }


            new Client(nom, prenom, adresse, codePostal, ville,
                    telephone, email, nSs, dateNaissance, mutuelle, medecinRef);

            // Mise à jour de l'interface
            chargerClient();          // Recharge la table des clients
            viderChampsClient();      // Vide les champs du formulaire

            JOptionPane.showMessageDialog(this, "Client ajouté avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (SaisieException e) {
            // Affiche un message d'erreur si une validation échoue
            JOptionPane.showMessageDialog(this, "Erreur de saisie : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Erreur inattendue
            JOptionPane.showMessageDialog(this, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void ajouterMedecin() {
        try {
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String adresse = txtAdresse.getText().trim();
            String codePostal = txtCodePostal.getText().trim();
            String ville = txtVille.getText().trim();
            String telephone = txtTelephone.getText().trim();
            String email = txtEmail.getText().trim();
            String rPPS = txtRPPS.getText().trim();

            // Vérification des champs obligatoires
            if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || codePostal.isEmpty() ||
                    ville.isEmpty() || telephone.isEmpty() || email.isEmpty() || rPPS.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Création du médecin (validation dans le constructeur)
            new Medecin(nom, prenom, adresse, codePostal, ville, telephone, email, rPPS);

            chargerMedecin();
            viderChampsMedecin();

            JOptionPane.showMessageDialog(this, "Médecin ajouté avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (SaisieException e) {
            // Exception levée lors des validations dans le constructeur ou setteurs
            JOptionPane.showMessageDialog(this, "Erreur de saisie : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur inattendue : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void viderChampsClient() {
        txtNom.setText("");
        txtPrenom.setText("");
        txtAdresse.setText("");
        txtCodePostal.setText("");
        txtVille.setText("");
        txtTelephone.setText("");
        txtEmail.setText("");
        txtNss.setText("");
        txtDateNaissance.setText("");
        txtMutuelle.setText("");
        txtMedecinref.setText("");
    }

    private void viderChampsMedecin() {
        txtNom.setText("");
        txtPrenom.setText("");
        txtAdresse.setText("");
        txtCodePostal.setText("");
        txtVille.setText("");
        txtTelephone.setText("");
        txtEmail.setText("");
        txtRPPS.setText("");
    }


    // Méthodes de recherche
    private void rechercherClientParNom() {
        String nom = txtRechercheNom.getText().trim();

        if (nom.isEmpty()) {
            chargerClient();  // recharge tous les clients si le champ est vide
            return;
        }

        modelClient.setRowCount(0);  // vide la table avant d’ajouter les résultats

        List<Client> resultats = Client.rechercherClientParNom(nom);  // ta méthode métier

        for (Client c : resultats) {
            modelClient.addRow(new Object[]{
                    c.getNom(),
                    c.getPrenom(),
                    c.getAdresse(),
                    c.getCodePostal(),
                    c.getVille(),
                    c.getTelephone(),
                    c.getEmail(),
                    c.getNSs(),
                    c.getDateNaissance(),
                    c.getMutuelle(),
                    c.getMedecinRef()
            });
        }
    }


    private void rechercherClientParEmail() {
        String email = txtRechercheEmail.getText().trim();
        if (email.isEmpty()) {
            chargerClient();
            return;
        }

        modelClient.setRowCount(0);
        List<Client> resultats = Client.rechercherClientParEmail(email);
        for (Client c : resultats) {
            modelClient.addRow(new Object[]{
                    c.getNom(),
                    c.getPrenom(),
                    c.getAdresse(),
                    c.getCodePostal(),
                    c.getVille(),
                    c.getTelephone(),
                    c.getEmail(),
                    c.getNSs(),
                    c.getDateNaissance(),
                    c.getMutuelle(),
                    c.getMedecinRef()
            });
        }
    }

    private void rechercherClientParNss() {
        String nss = txtRechercheNss.getText().trim();

        if (nss.isEmpty()) {
            chargerClient();
            return;
        }

        modelClient.setRowCount(0);

        List<Client> resultats = Client.rechercherClientParNss(nss);

        for (Client c : resultats) {
            modelClient.addRow(new Object[]{
                    c.getNom(),
                    c.getPrenom(),
                    c.getAdresse(),
                    c.getCodePostal(),
                    c.getVille(),
                    c.getTelephone(),
                    c.getEmail(),
                    c.getNSs(),
                    c.getDateNaissance(),
                    c.getMutuelle(),
                    c.getMedecinRef()
            });
        }
    }

    private void rechercherLivreParISBN() {
        String isbn = txtRechercheISBN.getText().trim();
        if (isbn.isEmpty()) {
            chargerLivres();
            return;
        }

        modelLivres.setRowCount(0);
        Livre livre = Livre.rechercherParISBN(isbn);
        if (livre != null) {
            modelLivres.addRow(new Object[]{
                    livre.getIsbn(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getQuantitedisponible()
            });
        }
    }

    private void rechercherLivreParTitre() {
        String titre = txtRechercheTitre.getText().trim();
        if (titre.isEmpty()) {
            chargerLivres();
            return;
        }

        try {
            modelLivres.setRowCount(0);
            List<Livre> resultats = Livre.rechercherParTitre(titre);
            for (Livre livre : resultats) {
                modelLivres.addRow(new Object[]{
                        livre.getIsbn(),
                        livre.getTitre(),
                        livre.getAuteur(),
                        livre.getQuantitedisponible()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la recherche: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rechercherLivreParAuteur() {
        String auteur = txtRechercheAuteur.getText().trim();
        if (auteur.isEmpty()) {
            chargerLivres();
            return;
        }

        modelLivres.setRowCount(0);
        List<Livre> resultats = Livre.rechercherParAuteur(auteur);
        for (Livre livre : resultats) {
            modelLivres.addRow(new Object[]{
                    livre.getIsbn(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getQuantitedisponible()
            });
        }
    }

    // Dialogue de création de prêt
    private void ouvrirDialogueCreationPret() {
        JDialog dialogPret = new JDialog(this, "📋 Créer un Prêt", true);
        dialogPret.setSize(600, 500);
        dialogPret.setLocationRelativeTo(this);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Variables pour stocker les sélections
        final Livre[] livreSelectionne = {null};
        final Abonnes[] abonneSelectionne = {null};
        final Employe[] employeSelectionne = {null};

        // Panel de sélection du livre
        JPanel panelLivre = new JPanel(new BorderLayout());
        panelLivre.setBorder(new TitledBorder("📚 Sélection du Livre"));

        String[] colonnesLivresPret = {"ISBN", "Titre", "Auteur", "Stock"};
        DefaultTableModel modelLivresPret = new DefaultTableModel(colonnesLivresPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableLivresPret = new JTable(modelLivresPret);
        tableLivresPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Charger uniquement les livres disponibles
        for (Livre livre : Livre.getLivres()) {
            if (livre.getQuantitedisponible() > 0) {
                modelLivresPret.addRow(new Object[]{
                        livre.getIsbn(),
                        livre.getTitre(),
                        livre.getAuteur(),
                        livre.getQuantitedisponible()
                });
            }
        }

        JScrollPane scrollLivresPret = new JScrollPane(tableLivresPret);
        scrollLivresPret.setPreferredSize(new Dimension(550, 100));
        panelLivre.add(scrollLivresPret, BorderLayout.CENTER);

        // Panel de sélection de l'abonné
        JPanel panelAbonne = new JPanel(new BorderLayout());
        panelAbonne.setBorder(new TitledBorder("👥 Sélection de l'Abonné"));

        String[] colonnesAbonnesPret = {"Nom", "Prénom", "Email"};
        DefaultTableModel modelAbonnesPret = new DefaultTableModel(colonnesAbonnesPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableAbonnesPret = new JTable(modelAbonnesPret);
        tableAbonnesPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (Abonnes abonne : Abonnes.getAbonnes()) {
            modelAbonnesPret.addRow(new Object[]{
                    abonne.getNom(),
                    abonne.getPrenom(),
                    abonne.getMail()
            });
        }

        JScrollPane scrollAbonnesPret = new JScrollPane(tableAbonnesPret);
        scrollAbonnesPret.setPreferredSize(new Dimension(550, 100));
        panelAbonne.add(scrollAbonnesPret, BorderLayout.CENTER);

        // Panel de sélection de l'employé
        JPanel panelEmploye = new JPanel(new BorderLayout());
        panelEmploye.setBorder(new TitledBorder("👨‍💼 Sélection de l'Employé"));

        String[] colonnesEmployesPret = {"Nom", "Prénom", "Identifiant"};
        DefaultTableModel modelEmployesPret = new DefaultTableModel(colonnesEmployesPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableEmployesPret = new JTable(modelEmployesPret);
        tableEmployesPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (Employe employe : Employe.getEmployees()) {
            modelEmployesPret.addRow(new Object[]{
                    employe.getNom(),
                    employe.getPrenom(),
                    employe.getIdentifiant()
            });
        }

        JScrollPane scrollEmployesPret = new JScrollPane(tableEmployesPret);
        scrollEmployesPret.setPreferredSize(new Dimension(550, 100));
        panelEmploye.add(scrollEmployesPret, BorderLayout.CENTER);

        // Panel des tables
        JPanel panelTables = new JPanel();
        panelTables.setLayout(new BoxLayout(panelTables, BoxLayout.Y_AXIS));
        panelTables.add(panelLivre);
        panelTables.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTables.add(panelAbonne);
        panelTables.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTables.add(panelEmploye);

        // Panel des boutons
        JPanel panelBoutonsPret = new JPanel(new FlowLayout());
        JButton btnCreer = new JButton("✅ Créer le Prêt");
        JButton btnAnnuler = new JButton("❌ Annuler");

        btnCreer.addActionListener(e -> {
            int ligneSelectionnee;

            // Vérifier sélection du livre
            ligneSelectionnee = tableLivresPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un livre!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String isbnSelectionne = (String) modelLivresPret.getValueAt(ligneSelectionnee, 0);
            livreSelectionne[0] = Livre.rechercherParISBN(isbnSelectionne);

            // Vérifier sélection de l'abonné
            ligneSelectionnee = tableAbonnesPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un abonné!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String emailSelectionne = (String) modelAbonnesPret.getValueAt(ligneSelectionnee, 2);
            for (Abonnes abonne : Abonnes.getAbonnes()) {
                if (abonne.getMail().equals(emailSelectionne)) {
                    abonneSelectionne[0] = abonne;
                    break;
                }
            }

            // Vérifier sélection de l'employé
            ligneSelectionnee = tableEmployesPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un employé!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String identifiantSelectionne = (String) modelEmployesPret.getValueAt(ligneSelectionnee, 2);
            for (Employe employe : Employe.getEmployees()) {
                if (employe.getIdentifiant().equals(identifiantSelectionne)) {
                    employeSelectionne[0] = employe;
                    break;
                }
            }

            // Créer le prêt
            try {
                new Livreprete(livreSelectionne[0], abonneSelectionne[0], employeSelectionne[0]);
                chargerPrets();
                chargerLivres(); // Mettre à jour les stocks
                dialogPret.dispose();
                JOptionPane.showMessageDialog(this,
                        "Prêt créé avec succès!\n\n" +
                                "Livre: " + livreSelectionne[0].getTitre() + "\n" +
                                "Abonné: " + abonneSelectionne[0].getNom() + " " + abonneSelectionne[0].getPrenom() + "\n" +
                                "Employé: " + employeSelectionne[0].getNom() + " " + employeSelectionne[0].getPrenom(),
                        "Succès", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogPret, "Erreur lors de la création du prêt: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAnnuler.addActionListener(e -> dialogPret.dispose());

        panelBoutonsPret.add(btnCreer);
        panelBoutonsPret.add(btnAnnuler);

        panelPrincipal.add(panelTables, BorderLayout.CENTER);
        panelPrincipal.add(panelBoutonsPret, BorderLayout.SOUTH);

        dialogPret.add(panelPrincipal);
        dialogPret.setVisible(true);
    }

    // Méthodes de rapport
    private void genererRapportAbonnes() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES ABONNÉS ===\n\n");
        rapport.append("Nombre total d'abonnés: ").append(Abonnes.getAbonnes().size()).append("\n\n");

        for (Abonnes abonne : Abonnes.getAbonnes()) {
            rapport.append("Nom: ").append(abonne.getNom()).append(" ").append(abonne.getPrenom()).append("\n");
            rapport.append("Email: ").append(abonne.getMail()).append("\n");
            rapport.append("Date d'inscription: ").append(abonne.getDateNow()).append("\n");
            rapport.append("─────────────────────────────────────\n");
        }

        afficherRapport(rapport.toString());
    }

    private void genererRapportLivres() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES LIVRES ===\n\n");
        rapport.append("Nombre total de livres: ").append(Livre.getLivres().size()).append("\n");

        int stockTotal = 0;
        int livresDisponibles = 0;

        for (Livre livre : Livre.getLivres()) {
            stockTotal += livre.getQuantitedisponible();
            if (livre.getQuantitedisponible() > 0) {
                livresDisponibles++;
            }
        }

        rapport.append("Stock total: ").append(stockTotal).append(" exemplaires\n");
        rapport.append("Livres disponibles: ").append(livresDisponibles).append("\n");
        rapport.append("Livres en rupture: ").append(Livre.getLivres().size() - livresDisponibles).append("\n\n");

        rapport.append("DÉTAIL PAR LIVRE:\n");
        rapport.append("─────────────────────────────────────\n");

        for (Livre livre : Livre.getLivres()) {
            rapport.append("ISBN: ").append(livre.getIsbn()).append("\n");
            rapport.append("Titre: ").append(livre.getTitre()).append("\n");
            rapport.append("Auteur: ").append(livre.getAuteur()).append("\n");
            rapport.append("Stock: ").append(livre.getQuantitedisponible());
            if (livre.getQuantitedisponible() == 0) {
                rapport.append(" ⚠️ RUPTURE");
            }
            rapport.append("\n─────────────────────────────────────\n");
        }

        afficherRapport(rapport.toString());
    }

    private void genererRapportPrets() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES PRÊTS ===\n\n");
        rapport.append("Nombre total de prêts: ").append(Livreprete.getLivrepretes().size()).append("\n\n");

        if (Livreprete.getLivrepretes().isEmpty()) {
            rapport.append("Aucun prêt enregistré dans le système.\n");
        } else {
            rapport.append("DÉTAIL DES PRÊTS:\n");
            rapport.append("─────────────────────────────────────\n");

            int numPret = 1;
            for (Livreprete pret : Livreprete.getLivrepretes()) {
                rapport.append("PRÊT #").append(numPret++).append("\n");
                rapport.append("Livre: ").append(pret.getLivre().getTitre()).append("\n");
                rapport.append("ISBN: ").append(pret.getLivre().getIsbn()).append("\n");
                rapport.append("Abonné: ").append(pret.getAbonnes().getNom()).append(" ").append(pret.getAbonnes().getPrenom()).append("\n");
                rapport.append("Email: ").append(pret.getAbonnes().getMail()).append("\n");
                rapport.append("Employé: ").append(pret.getEmploye().getNom()).append(" ").append(pret.getEmploye().getPrenom()).append("\n");
                rapport.append("Date de prêt: ").append(pret.getDatePret()).append("\n");
                rapport.append("Date de retour prévue: ").append(pret.getDateRetour()).append("\n");
                rapport.append("─────────────────────────────────────\n");
            }
        }

        afficherRapport(rapport.toString());
    }

    private void afficherRapport(String rapport) {
        JDialog dialogRapport = new JDialog(this, "📊 Rapport", true);
        dialogRapport.setSize(600, 500);
        dialogRapport.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea(rapport);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setCaretPosition(0);

        JScrollPane scroll = new JScrollPane(textArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnFermer = new JButton("❌ Fermer");
        btnFermer.addActionListener(e -> dialogRapport.dispose());
        panelBoutons.add(btnFermer);

        panel.add(panelBoutons, BorderLayout.SOUTH);

        dialogRapport.add(panel);
        dialogRapport.setVisible(true);
    }

    // Méthodes de sauvegarde
    private void sauvegarder() {
        donnees.put("abonnes", Abonnes.getAbonnes());
        donnees.put("employes", Employe.getEmployees());
        donnees.put("livres", Livre.getLivres());
        donnees.put("prets", Livreprete.getLivrepretes());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
        JOptionPane.showMessageDialog(this, "Données sauvegardées avec succès!", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sauvegarderEtQuitter() {
        int choix = JOptionPane.showConfirmDialog(this,
                "Voulez-vous sauvegarder avant de quitter?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (choix == JOptionPane.YES_OPTION) {
            sauvegarder();
            System.exit(0);
        } else if (choix == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        // Si CANCEL, on ne fait rien
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        // Créer quelques données de test si nécessaire
        initialiserDonneesTest();

        SwingUtilities.invokeLater(() -> {
            new MainSwing().setVisible(true);
        });
    }

    private static void initialiserDonneesTest() {
        // Créer quelques employés de test s'il n'y en a pas
        if (Employe.getEmployees().isEmpty()) {
            new Employe("Martin", "Sophie", "EMP001");
            new Employe("Dubois", "Pierre", "EMP002");
        }
    }
}