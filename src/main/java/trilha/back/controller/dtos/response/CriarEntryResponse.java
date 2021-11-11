package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CriarEntryResponse {

    //É oque eu quero que o cliente veja no verbo GET
    @JsonProperty("id_response")
    private Long id;
    @JsonProperty("name_response")
    private String name;
    @JsonProperty("description_reponse")
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