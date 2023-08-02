import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.modelos.Endereco;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaCEP {
    public static void main(String[] args) {
        String busca = "";
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        List<Endereco> listaEnderecos = new ArrayList<>();

        System.out.println("Digite SAIR para encerrar o programa");
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("\nDigite um CEP: ");
            busca = scanner.next();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://viacep.com.br/ws/" + busca.replace("-", "") + "/json/"))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Endereco endereco = gson.fromJson(json, Endereco.class);

                listaEnderecos.add(endereco);
                System.out.println("Endereço adicionado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro de requisição: " + e.getMessage());
            }
        }

        try {
            FileWriter writer = new FileWriter("Enderecos.json");
            writer.write(gson.toJson(listaEnderecos));
            writer.close();
            System.out.println("\nArquivo criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}
