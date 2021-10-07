package trilha.back.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEntryResponse {

    @JsonProperty("id_da_Response_Entry")
    private Long id;

    public CriarEntryResponse(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
