package screenmatch.modelos;

import screenmatch.calculos.Avaliavel;

public class Serie extends Titulo implements Avaliavel {
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodios;

    public Serie(String nomeSerie, int anoLancamento, int temporadas, int episodiosTemporada) {
        super(nomeSerie, anoLancamento);
        this.setTemporadas(temporadas);
        this.setEpisodiosPorTemporada(episodiosTemporada);
    }

    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }
    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodios;
    }

    @Override
    public void imprimeTitulo() {
        System.out.println("""
                Filme: %s
                Ano de Lançamento: %d
                Duração: %d minutos
                Avaliação: %.2f
                """.formatted(this.nomeTitulo, this.anoDeLancamento, getDuracaoEmMinutos(), super.retornaMediaAvaliacao()));
    }

    @Override
    public int getAvaliacao() {
        return (int) ((super.getSomaDasAvaliacoes() / super.getTotalDeAvaliacoes()) / 2);
    }

    @Override
    public String toString() {
        return "Série: %s (%d)".formatted(this.getNomeTitulo(), this.getAnoDeLancamento());
    }
}
