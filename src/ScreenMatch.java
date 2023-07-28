import screenmatch.calculos.CalculadoraDeTempo;
import screenmatch.calculos.FiltroRecomendacao;
import screenmatch.modelos.Episodio;
import screenmatch.modelos.Filme;
import screenmatch.modelos.Serie;
import screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScreenMatch {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Super Mario Bros. O Filme", 2023, 92);
        filme1.setDisponivelNoPlano(true);

        Filme filme2 = new Filme("Chamando Todas as Locomotivas", 2005, 60);
        filme2.setDisponivelNoPlano(true);

        Filme filme3 = new Filme("A Grande Decoberta", 2008, 60);
        filme3.setDisponivelNoPlano(true);

        filme1.avaliaTitulo(9.92);
        filme1.avaliaTitulo(8.57);
        filme1.avaliaTitulo(7.46);
        filme1.imprimeTitulo();

        Serie serie = new Serie("Thomas e Seus Amigos", 1984, 5, 26);
        serie.setDisponivelNoPlano(true);
        serie.setMinutosPorEpisodios(6);
        serie.avaliaTitulo(9.98);
        serie.avaliaTitulo(8.67);
        serie.avaliaTitulo(8.42);
        serie.imprimeTitulo();

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.incluiTitulo(serie);
        calculadoraDeTempo.incluiTitulo(filme1);
        System.out.println("Duração total: " + calculadoraDeTempo.getTempoTotal() + " minutos.");

        Episodio episodio = new Episodio("Thomas Aprende uma Lição", 1, serie);
        episodio.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtraRecomendacao(filme1);
        filtro.filtraRecomendacao(serie);
        filtro.filtraRecomendacao(episodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println("\nTamanho da Lista: " + listaDeFilmes.size());
        for (int i = 0; i < listaDeFilmes.size(); i++) {
            System.out.println(listaDeFilmes.get(i).toString());
        }
        System.out.println(listaDeFilmes.toString());

        List<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie);
        System.out.println("\nLista de Titulos:");
        for (Titulo item: lista) {
            System.out.println("Titulo: " + item.getNomeTitulo());
            if (item instanceof Filme filme && filme.getAvaliacao() > 2) {
                System.out.println("Avaliação: " + filme.getAvaliacao());
            }
        }

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
