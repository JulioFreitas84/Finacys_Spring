package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaRequest {

    @JsonProperty("nome_da_categoria_request")
    private String name;
    @JsonProperty("description_category_request")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
