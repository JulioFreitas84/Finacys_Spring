package trilha.back.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public Entry(long id, String julio_freitas, String description, String type, String amount, String date, boolean paid, boolean pendent, Object category) {

    }
}


