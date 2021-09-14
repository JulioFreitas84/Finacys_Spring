package trilha.back.entity;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Entry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "amount")
    private String amount;
    @Column(name = "date")
    private String date;
    @Column(name = "paid")
    private String paid;
    @Column(name = "pendent")
    private Boolean pendent;
    @OneToMany
    @Column(name = "Category")
    private List<Category> categoryId;

    public Entry(){}

    public Entry(Long id, String name, String description, String type, String amount
            , String date, String paid, Boolean pendent, List<Category> categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
        this.pendent = pendent;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", paid='" + paid + '\'' +
                ", pendent=" + pendent +
                ", categoryId=" + categoryId +
                '}';
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public Boolean getPendent() {
        return pendent;
    }

    public void setPendent(Boolean pendent) {
        this.pendent = pendent;
    }

    public List<Category> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<Category> categoryId) {
        this.categoryId = categoryId;
    }
}


