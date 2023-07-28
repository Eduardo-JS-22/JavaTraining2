package screenmatch.calculos;

import screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void incluiTitulo(Titulo titulo) {
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
