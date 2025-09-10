package controleur;

import exception.SaisieException;
import vue.Menu2;

public class Main2 {
    public static void main(String[] args) {
        try {
            Menu2.lancerApplication();
//            Main.chargement();
            Menu2.menuPrincipal();

            }catch (SaisieException e){
            System.err.println("il y a comme un probleme : "+e.getMessage());
        }

    }

}
