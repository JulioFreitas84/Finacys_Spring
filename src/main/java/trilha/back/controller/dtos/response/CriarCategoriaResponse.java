package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaResponse {

    @JsonProperty("id_category")
    private Long id;
    @JsonProperty("name_category")
    private String name;
    @JsonProperty("descricao_category")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
