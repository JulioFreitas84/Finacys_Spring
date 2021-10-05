package trilha.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trilha.back.entity.CategoryModel;
import trilha.back.entity.EntryModel;

import java.util.List;
import java.util.stream.Collectors;

// Criação da classes DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryApplicationServerDto {

    private String name;
    private String description;
    private String type;
    private String amount;
    private String date;
    private String paid;
    private Boolean pendent;
    private CategoryModel categoryId ;

//O construtor da classe Dto é o objeto que ela vai refatoras
    public EntryApplicationServerDto(EntryModel entry) {
        this.name = entry.getName();
        this.description = entry.getDescription();
        this.type = entry.getType();
        this.amount = entry.getAmount();
        this.date = entry.getDate();
        this.paid = entry.getPaid();
        this.pendent = entry.getPendent();
    }

    //Metodo dentro da classe serviço que retorne uma lista
    //STREAM simula um FOR - MAP mapea os objetos - COLLECT cria uma lista
    public static List<EntryApplicationServerDto> convert(List<EntryModel> entries){
        return entries.stream().map(EntryApplicationServerDto::new).collect(Collectors.toList());
    }
}