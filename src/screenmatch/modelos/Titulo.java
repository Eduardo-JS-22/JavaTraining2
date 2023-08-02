package screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    protected String nomeTitulo;
    @SerializedName("Year")
    protected int anoDeLancamento;
    private boolean disponivelNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    protected int duracaoEmMinutos;

    public Titulo(String nomeTitulo, int anoDeLancamento) {
        this.nomeTitulo = nomeTitulo;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOMDb meuTituloOMDb) {
        this.nomeTitulo = meuTituloOMDb.title();
        try{
            this.anoDeLancamento = Integer.parseInt(meuTituloOMDb.year());
            this.duracaoEmMinutos = Integer.valueOf(meuTituloOMDb.runtime().substring(0, 3).replace(" ", ""));
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public void setDisponivelNoPlano(boolean disponivelNoPlano) {
        this.disponivelNoPlano = disponivelNoPlano;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public String getNomeTitulo() {
        return nomeTitulo;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public boolean isDisponivelNoPlano() {
        return disponivelNoPlano;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public double getSomaDasAvaliacoes() {

        return somaDasAvaliacoes;
    }
    public int getTotalDeAvaliacoes() {

        return totalDeAvaliacoes;
    }

    public void imprimeTitulo() {
        System.out.println("""
                Filme: %s
                Ano de Lançamento: %d
                Duração: %d minutos
                Avaliação: %.2f
                """.formatted(nomeTitulo, anoDeLancamento, duracaoEmMinutos, retornaMediaAvaliacao()));
    }

    public void avaliaTitulo(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double retornaMediaAvaliacao() {
        if (somaDasAvaliacoes != 0) {
            return somaDasAvaliacoes/totalDeAvaliacoes;
        } else {
            return 0.0;
        }
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNomeTitulo().compareTo(outroTitulo.getNomeTitulo());
    }

    @Override
    public String toString() {
        return "Titulo: %s, Ano: %d, Duração: %d minutos".formatted(nomeTitulo, anoDeLancamento, duracaoEmMinutos);
    }
}
