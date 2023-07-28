package screenmatch.modelos;

public class Audio {
    private String titulo;
    private int duracao;
    private int totalReproducao;
    private int curtidas;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public int getTotalReproducao() {
        return totalReproducao;
    }
    public void setTotalReproducao(int totalReproducao) {
        this.totalReproducao = totalReproducao;
    }
    public int getCurtidas() {
        return curtidas;
    }
    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }
    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void curte() {
        this.curtidas++;
    }

    public void reproduz() {
        totalReproducao++;
    }
}
