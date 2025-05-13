package io.github.cornos_espaciais.entities;

import java.util.List;

public class GerenciadorDeColisao {
    public static boolean colisaoEntreAtores(Ator ator1, Ator ator2) {
        Float[] alturaAtor1 = {
            ator1.getyPosition() + (ator1.getSprite().getHeight() / 2),
            ator1.getyPosition() - (ator1.getSprite().getHeight() / 2)
        };
        Float[] larguraAtor1 = {
            ator1.getxPosition() + (ator1.getSprite().getWidth() / 2),
            ator1.getxPosition() - (ator1.getSprite().getWidth() / 2)
        };

        Float[] alturaAtor2 = {
            ator2.getyPosition() + (ator2.getSprite().getHeight() / 2),
            ator2.getyPosition() - (ator2.getSprite().getHeight() / 2)
        };
        Float[] larguraAtor2 = {
            ator2.getxPosition() + (ator2.getSprite().getWidth() / 2),
            ator2.getxPosition() - (ator2.getSprite().getWidth() / 2)
        };

        if (alturaAtor1[1] <= alturaAtor2[1] && alturaAtor1[2] >= alturaAtor2[2] &&
            larguraAtor1[1] <= larguraAtor2[1] && larguraAtor1[2] >= larguraAtor2[2]) {
            System.out.println("Colisão entre atores detectada");
            return true;
        }

        return false;
    }
}
