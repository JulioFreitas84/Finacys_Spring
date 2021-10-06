package trilha.back.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaResponse {

    @JsonProperty("numero_do_id_categoria")
    private Long id;

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
