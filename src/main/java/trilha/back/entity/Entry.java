package trilha.back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Boolean paid;
    @Column(name = "pendent")
    private Boolean pendent;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categoryId ;

}


