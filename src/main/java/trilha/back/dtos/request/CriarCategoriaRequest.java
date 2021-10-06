package trilha.back.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaRequest {

    @JsonProperty("nome_da_categoria_request")
    private String name;

    @JsonProperty("descricao")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
