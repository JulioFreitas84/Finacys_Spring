package trilha.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @JsonIgnore
    public List<Entry> getEntry(){
        return entry;
    }


}
