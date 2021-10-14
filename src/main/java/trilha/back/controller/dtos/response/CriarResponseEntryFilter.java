package trilha.back.controller.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarResponseEntryFilter {
    @JsonProperty("data_lancamento_filter")
    private String date;
    @JsonProperty("amount_filter")
    private String amount;
    @JsonProperty("paid_filter")
    private boolean paid;

    public CriarResponseEntryFilter(String date, String amount, boolean paid) {
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
