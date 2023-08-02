package screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Endereco {
    @SerializedName("cep")
    private String cep;
    @SerializedName("logradouro")
    private String rua;
    @SerializedName("bairro")
    private String bairro;
    @SerializedName("localidade")
    private String cidade;
    @SerializedName("uf")
    private String estado;

    public Endereco(String cep, String rua, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return """
                Cep: %s
                Rua: %s
                Bairro: %s
                Cidade: %s
                Estado: %s
                """.formatted(cep, rua, bairro, cep, estado);
    }
}
