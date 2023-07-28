package screenmatch.modelos;

public class Preferencias {
    public void inclui(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println("\n%s é considerado sucesso e preferido por todos.".formatted(audio.getTitulo()));
        } else {
            System.out.println("\n%s também é um dos que todo mundo está curtindo.".formatted(audio.getTitulo()));
        }
    }
}
