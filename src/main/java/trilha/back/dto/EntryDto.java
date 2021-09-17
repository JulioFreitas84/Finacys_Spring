package trilha.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDto {

    private String name;
    private String description;
    private String type;
    private String amount;
    private String date;
    private String paid;
    private Boolean pendent;
    private Category categoryId ;

    public EntryDto(Entry entry) {
        this.name = entry.getName();
        this.description = entry.getDescription();
        this.type = entry.getType();
        this.amount = entry.getAmount();
        this.date = entry.getDate();
        this.paid = entry.getPaid();
        this.pendent = entry.getPendent();
    }

    //STREAM simula um FOR - MAP mapea os objetos - COLLECT cria uma lista
    public static List<EntryDto> convert(List<Entry> entries){
        return entries.stream().map(EntryDto::new).collect(Collectors.toList());
    }
}