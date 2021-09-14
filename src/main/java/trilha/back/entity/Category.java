package trilha.back.entity;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", orphanRemoval = true)
    private List<Entry> ent = new ArrayList<>();

    public Category(){
    }

    public Category(Long id, String name, String description, List<Entry> ent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ent = ent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ent=" + ent +
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

    public List<Entry> getEnt() {
        return ent;
    }

    public void setEnt(List<Entry> ent) {
        this.ent = ent;
    }
}
