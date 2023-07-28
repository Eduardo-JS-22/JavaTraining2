package screenmatch.modelos;
import screenmatch.calculos.Avaliavel;

public class Filme extends Titulo implements Avaliavel {
    private String diretor;

    public Filme(String nomeFilme, int anoLancamento, int duracao) {
        super(nomeFilme, anoLancamento);
        this.setDuracaoEmMinutos(duracao);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getAvaliacao() {
        return (int) ((super.getSomaDasAvaliacoes() / super.getTotalDeAvaliacoes()) / 2);
    }

    @Override
    public String toString() {
        return "Filme: %s (%d)".formatted(this.getNomeTitulo(), this.getAnoDeLancamento());
    }
}
