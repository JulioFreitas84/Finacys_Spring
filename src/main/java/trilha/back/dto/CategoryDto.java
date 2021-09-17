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
public class CategoryDto {

    private String name;
    private String description;
    private List<Entry> entry;

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.description = category.getDescription();
    }
        //STREAM simula um FOR - MAP mapea os objetos - COLLECT cria uma lista
    public static List<CategoryDto> convert(List<Category> categories){
        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }
}
