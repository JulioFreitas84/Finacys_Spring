package trilha.back.controller.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarRequestEntryFilter {
    @JsonProperty("data_lançamento")
    private String date;
    @JsonProperty("amountt")
    private String amount;
    @JsonProperty("paid")
    private String paid;

    public CriarRequestEntryFilter(String date, String amount, String paid) {
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

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
