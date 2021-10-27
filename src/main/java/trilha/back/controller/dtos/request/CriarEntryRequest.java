package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarEntryRequest {


    @JsonProperty("id_response")
    private Long id;
    @JsonProperty("name_response")
    private String name;
    @JsonProperty("description_reponse")
    private String description;

    public CriarEntryRequest(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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
/* @JsonProperty("data_lancamento")
    private String date;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("paid")
    private boolean paid; */

}
