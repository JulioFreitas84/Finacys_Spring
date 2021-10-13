package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaResponse {

    @JsonProperty("numero_do_id_categoria")
    private Long id;
    @JsonProperty("name_category")
    private String name;
    @JsonProperty("descricao_category")
    private String description;

    public CriarCategoriaResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public CriarCategoriaResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
