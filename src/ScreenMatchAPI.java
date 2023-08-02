import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.modelos.Titulo;
import screenmatch.modelos.TituloOMDb;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScreenMatchAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um Nome de Filme para Buscar: ");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=94546b6f"))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOMDb meuTituloOMDb = gson.fromJson(json, TituloOMDb.class);
                Titulo meuTitulo = new Titulo(meuTituloOMDb);

                System.out.println(meuTitulo);
                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("\nErro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro: " + e.getMessage());
            }
        }

        System.out.println(titulos);
        FileWriter writer = new FileWriter("Titulo.json");
        writer.write(gson.toJson(titulos));
        writer.close();
        System.out.println("\nO programa finalizou por inteiro!");
    }
}
