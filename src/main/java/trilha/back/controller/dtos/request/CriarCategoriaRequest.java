package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
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
