package trilha.back.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {

    @JsonProperty("nome_da_categoria_request")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
