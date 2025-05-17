package io.github.cornos_espaciais.entities;

import java.util.Iterator;
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

    public static boolean colisaoEntreAtores(Ator ator1, Ator ator2) {
        Float[] pontasAtor = coletarPosicoes(ator1);
        Float[] pontasAtor2 = coletarPosicoes(ator2);

        if (pontasAtor[0] >= pontasAtor2[1] && pontasAtor[1] <= pontasAtor2[0] &&
            pontasAtor[2] >= pontasAtor2[3] && pontasAtor[3] <= pontasAtor2[2] &&
            ator2.getAtivo()) {
            ator2.dispose();
            return true;
        }
        return false;
    }

    public static boolean colisaoEntreAtorEAtores(Ator ator, List<Ator> atores) {
        Iterator<Ator> atoresIterator = atores.iterator();
        while (atoresIterator.hasNext()) {
            Ator next = atoresIterator.next();
            if (colisaoEntreAtores(ator, next)) {
                return true;
            }
        }

        return false;
    }
}
