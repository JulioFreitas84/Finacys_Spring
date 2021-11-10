package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarCategoriaResponse {

    @JsonProperty("numero_do_id_categoria")
    private Long id;
    @JsonProperty("name_categoria")
    private String name;
    @JsonProperty("descricao_categoria")
    private String description;
}
