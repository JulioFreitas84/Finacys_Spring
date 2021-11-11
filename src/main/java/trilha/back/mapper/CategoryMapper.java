package trilha.back.mapper;

import org.mapstruct.Mapper;
import trilha.back.controller.dtos.request.CriarCategoriaRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CriarCategoriaResponse modelCategoryToResponse(Category save);

    Category requestToModel(CriarCategoriaRequest category);
}
