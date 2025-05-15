package io.github.cornos_espaciais.entities;

import java.util.List;

public class GerenciadorDeColisao {
    private static Float[] coletarPosicoes(Ator ator) {
        Float[] pontas = new Float[4];

        pontas[0] = ator.getxPosition() + (ator.getSprite().getWidth() / 2);    // Recupera a ponta direita
        pontas[1] = ator.getxPosition() - (ator.getSprite().getWidth() / 2);    // Recupera a ponta esquerda
        pontas[2] = ator.getyPosition() + (ator.getSprite().getHeight() / 2);   // Recupera a ponta superior
        pontas[3] = ator.getyPosition() - (ator.getSprite().getHeight() / 2);   // Recupera a ponta inferior

        return pontas;
    }

    public static boolean colisaoEntreAtorEProjetil(Ator ator, List<Ator> projetil) {
        Float[] pontasAtor = coletarPosicoes(ator);

        for (Ator proj : projetil) {
            Float[] pontasProjetil = coletarPosicoes(proj);
            if (pontasAtor[0] >= pontasProjetil[1] && pontasAtor[1] <= pontasProjetil[0] &&
                pontasAtor[2] >= pontasProjetil[3] && pontasAtor[3] <= pontasProjetil[2] &&
                proj.getAtivo()) {
                proj.dispose();
                return true;
            }
        }
        return false;
    }
}
