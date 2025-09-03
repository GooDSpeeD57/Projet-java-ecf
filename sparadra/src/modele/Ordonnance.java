package modele;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ordonnance implements Serializable {
    private static final long serialVersionUID = 1L;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static List<Ordonnance> ordonnance = new ArrayList<Ordonnance>();

    private Medecins medecin;
    private Clients client;
    private Medicaments medicament;
}
