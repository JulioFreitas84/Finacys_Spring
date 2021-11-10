package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import trilha.back.entity.Category;

@Data
@Builder
public class CriarEntryRequest {

//Cliente envia essas informações pelo Postman ou Swagger

    @JsonProperty("id_response")
    private Long id;
    @JsonProperty("name_response")
    private String name;
    @JsonProperty("description_reponse")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("date")
    private String date;
    @JsonProperty("paid")
    private boolean paid = false;
    @JsonProperty("pendent")
    private boolean pendent = false;

    private Category category;
}
