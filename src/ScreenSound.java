import screenmatch.modelos.Musica;
import screenmatch.modelos.Podcast;
import screenmatch.modelos.Preferencias;

public class ScreenSound {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao ScreenSound!");

        Musica musica1 = new Musica();
        musica1.setTitulo("Radio Ga Ga");
        musica1.setDuracao(344);
        musica1.setArtista("Queen");
        musica1.setAlbum("The Works");
        musica1.setGenero("Rock");

        for (int i = 0; i < 5000; i++) {
            musica1.reproduz();
        }
        for (int i = 0; i < 1000; i++) {
            musica1.curte();
        }

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("ABC");
        podcast1.setHost("ABC");
        podcast1.setDescricao("ABC");

        for (int i = 0; i < 100; i++) {
            podcast1.reproduz();
        }
        for (int i = 0; i < 50; i++) {
            podcast1.curte();
        }

        Preferencias preferencias = new Preferencias();
        preferencias.inclui(musica1);
        preferencias.inclui(podcast1);
    }
}
