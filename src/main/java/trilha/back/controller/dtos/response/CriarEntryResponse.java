package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CriarEntryResponse {

    //É oque eu quero que o cliente veja no verbo GET
    @JsonProperty("id_response")
    private Long id;
    @JsonProperty("name_response")
    private String name;
    @JsonProperty("description_reponse")
    private String description;
}