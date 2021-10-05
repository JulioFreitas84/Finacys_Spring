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
public class CategoryApplicationServerDto {

    private String name;
    private String description;
    private List<EntryModel> entry;

    //O construtor da classe Dto é o objeto que ela vai refatoras
    public CategoryApplicationServerDto(CategoryModel category) {
        this.name = category.getName();
        this.description = category.getDescription();
    }
        //STREAM simula um FOR - MAP mapea os objetos - COLLECT cria uma lista
    public static List<CategoryApplicationServerDto> convert(List<CategoryModel> categories){
        return categories.stream().map(CategoryApplicationServerDto::new).collect(Collectors.toList());
    }
}
