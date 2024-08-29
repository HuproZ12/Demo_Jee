package Exercice_02;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class Chat {
    private String nom;
    private String race;
    private String repasFavoris;
    private String naissance;
}