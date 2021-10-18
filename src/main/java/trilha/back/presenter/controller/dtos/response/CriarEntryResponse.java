package trilha.back.presenter.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEntryResponse {

    @JsonProperty("name_response")
    private String name;
    @JsonProperty("description_reponse")
    private String description;

    public CriarEntryResponse(String name, String description) {
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
}
