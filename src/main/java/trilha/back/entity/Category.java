package trilha.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_cat", nullable = false)
    private String name;
    @Column(name = "description_cat")
    private String description;
    @OneToMany(mappedBy = "categoryId")
    private List<Entry> entry;

    public Category(){
    }

    public Category(Long id, String name, String description, List<Entry> entry) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ent=" + entry +
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

    @JsonIgnore
    public List<Entry> getEnt() {
        return entry;
    }

    public void setEnt(List<Entry> ent) {
        this.entry = ent;
    }
}
