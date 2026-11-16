package sn.ucad.biblioapi;

import java.time.LocalDateTime;

// Renvoyé par GET /info : Jackson le convertit en JSON.
public record Info(String application, String version, LocalDateTime heureServeur) {

}
