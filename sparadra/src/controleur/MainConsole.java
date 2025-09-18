package controleur;

import exception.SaisieException;

public class MainConsole {
    public static void main(String[] args) {
        try {
            Main.chargement();

            }catch (SaisieException e){
            System.err.println("il y a comme un probleme : "+e.getMessage());
        }

    }

}
