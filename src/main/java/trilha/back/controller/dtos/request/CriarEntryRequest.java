package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEntryRequest {

    @JsonProperty("data_lancamento")
    private String date;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("paid")
    private boolean paid;

    public CriarEntryRequest(String date, String amount, boolean paid) {
        this.date = date;
        this.amount = amount;
        this.paid = paid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
