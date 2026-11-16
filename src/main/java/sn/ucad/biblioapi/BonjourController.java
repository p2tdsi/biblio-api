package sn.ucad.biblioapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

// TODO ch03 (TP 1, étape 3) : faire de cette classe un contrôleur REST.
public class BonjourController {

    // TODO ch03 (étape 6) : déclarer un Logger SLF4J et journaliser les appels.
    private static final Logger log = LoggerFactory.getLogger(BonjourController.class);

    // TODO ch03 (étape 3) : GET /bonjour        -> "Bonjour, bienvenue sur BiblioAPI !"
    // TODO ch03 (étape 3) : GET /bonjour/perso  -> "Bonjour Amina !" pour ?nom=Amina,
    //                       "Bonjour inconnu !" sans paramètre (@RequestParam avec valeur par défaut)
     @GetMapping("/bonjour")
     public String bonjour() {
         return "Bonjour, bienvenue sur BiblioAPI !";
     }

    // Étape 3 : GET /bonjour/perso?nom=...
    @GetMapping("/bonjour/perso")
    public String bonjourPerso(@RequestParam(defaultValue = "inconnu") String nom) {
        return "Bonjour " + nom + " !";
    }
    // TODO ch03 (étape 4) : GET /info           -> le record Info (nom, version, heure du serveur)
    @GetMapping("/info")
    public Info info() {
        return new Info("BiblioAPI", "0.0.1-SNAPSHOT", LocalDateTime.now());
    }
    // TODO ch03 (étape 5) : GET /bonjour/{nom}  -> le nom lu dans le chemin (@PathVariable)
    @GetMapping("/bonjour/{nom}")
    public String bonjourPath(@PathVariable String nom) {
        return "Bonjour " + nom + " !";
    }
}
