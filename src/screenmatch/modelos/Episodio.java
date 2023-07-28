package screenmatch.modelos;

import screenmatch.calculos.Avaliavel;

public class Episodio implements Avaliavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public Episodio(String nomeEpisodio, int numeroEpisodio, Serie serie) {
        this.setNome(nomeEpisodio);
        this.setNumero(numeroEpisodio);
        this.setSerie(serie);
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Serie getSerie() {
        return serie;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }
    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    @Override
    public int getAvaliacao() {
        if (totalVisualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
