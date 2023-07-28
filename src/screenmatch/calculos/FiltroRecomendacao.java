package screenmatch.calculos;

import screenmatch.modelos.Titulo;

public class FiltroRecomendacao {
    public void filtraRecomendacao(Avaliavel avaliavel) {
        if (avaliavel.getAvaliacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (avaliavel.getAvaliacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
