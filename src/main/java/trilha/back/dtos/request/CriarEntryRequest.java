package trilha.back.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEntryRequest {

    @JsonProperty("id_da_Request_Entry")
    private Long id;

    public CriarEntryRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
