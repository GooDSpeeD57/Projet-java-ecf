package controleur;

import exception.SaisieException;
import vue.Menu2;

public class Main2 {
    public static void main(String[] args) {
        try {
            Menu2.lancerApplication();
            }catch (SaisieException e){
            System.err.println("il y a comme un probleme : "+e.getMessage());
        }

    }

}
//public class RegexConstantes {
//    public static final String REGEX_MOTS = "^(?=.*[A-Za-zÀ-ÿ])[A-Za-zÀ-ÿ\\s\\-]+$";
//    public static final String REGEX_NSS = "^[12]\\d{2}(0[1-9]|1[0-2]|2[0-9])\\d{8}\\d{2}$";
//    public static final String REGEX_DATE_NAISSANCE = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
//    public static final String REGEX_EMAIL = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
//    public static final String REGEX_CODE_POSTAL = "\\d{5}";
//    public static final String REGEX_TELEPHONE = "^(?:\\+33\\s?[1-9](?:\\s?\\d{2}){4}|0[1-9](?:\\s?\\d{2}){4})$";
//    public static final String REGEX_ADRESSE = "^\\d{1,4}\\s*(bis|ter)?\\s*(rue|avenue|av|boulevard|bd|chemin|allée|impasse|route|place)\\s+.+$";
//    public static final String REGEX_VILLE = "^[\\p{L}][\\p{L} \\-']*$";
//    public static final String REGEX_RPPS = "^10\\d{11}$";
//}
//import java.util.List;
//import java.util.function.Predicate;
//
//public class ValidateurChamps {
//
//    private static final List<String> REGEX_LIST = List.of(
//            RegexConstantes.REGEX_MOTS,
//            RegexConstantes.REGEX_NSS,
//            RegexConstantes.REGEX_DATE_NAISSANCE,
//            RegexConstantes.REGEX_EMAIL,
//            RegexConstantes.REGEX_CODE_POSTAL,
//            RegexConstantes.REGEX_TELEPHONE,
//            RegexConstantes.REGEX_ADRESSE,
//            RegexConstantes.REGEX_VILLE,
//            RegexConstantes.REGEX_RPPS
//    );
//
//    // Retourne un prédicat qui teste si l'input correspond à AU MOINS UNE regex
//    public static Predicate<String> getValidateur() {
//        return input -> REGEX_LIST.stream().anyMatch(regex -> input.matches(regex));
//    }
//
//    // Variante : tester toutes les regex (souvent inutile, mais possible)
//    public static Predicate<String> getValidateurAll() {
//        return input -> REGEX_LIST.stream().allMatch(regex -> input.matches(regex));
//    }
//
//    // Exemple d'utilisation
//    public static void main(String[] args) {
//        Predicate<String> validateur = getValidateur();
//
//        System.out.println(validateur.test("75000"));           // true (code postal)
//        System.out.println(validateur.test("jean.dupont@mail.com")); // true (email)
//        System.out.println(validateur.test("Bonjour"));          // true (mot)
//        System.out.println(validateur.test("abcdef"));           // false (ne correspond à rien)
//    }
//}
//public static boolean validerChamp(String input, String typeChamp) {
//    return switch (typeChamp.toLowerCase()) {
//        case "email" -> input.matches(RegexConstantes.REGEX_EMAIL);
//        case "nss" -> input.matches(RegexConstantes.REGEX_NSS);
//        case "ville" -> input.matches(RegexConstantes.REGEX_VILLE);
//        // etc.
//        default -> false;
//    };
//}
