package io.github.cornos_espaciais.entities;

import java.util.List;

public class GerenciadorDeColisao {
    private Jogador jogador;
    private List<Projetil> projeteis;
    private List<Asteroide> asteroides;

    public GerenciadorDeColisao(Jogador jogador, List<Asteroide> asteroides) {
        this.jogador = jogador;
        this.projeteis = jogador.getPROJETEIS();
        this.asteroides = asteroides;
    }

    public void colisao(){
        for(Projetil proj : projeteis) {
            for (Asteroide asteroide : asteroides){
                if
                (
                    (proj.getY()  >= asteroide.getY() - (float) (asteroide.getSprite().getHeight() / 2)) &&
                    (proj.getY() <= asteroide.getY() + (float) (asteroide.getSprite().getHeight() / 2)) &&
                    (proj.getX()  >= asteroide.getX() - (float) (asteroide.getSprite().getWidth() / 2)) &&
                    (proj.getX() <= asteroide.getX() + (float) (asteroide.getSprite().getWidth() / 2))
                )
                {
                    if (proj.isAtivo()) {
                        asteroide.dano();
                    }
                    proj.dispose();
                }
            }
        }
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<Projetil> getProjeteis() {
        return projeteis;
    }

    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    public void setAsteroides(List<Asteroide> asteroides) {
        this.asteroides = asteroides;
    }
}
