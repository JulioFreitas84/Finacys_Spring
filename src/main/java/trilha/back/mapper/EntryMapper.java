package trilha.back.mapper;

import org.mapstruct.Mapper;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Entry;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    CriarCategoriaResponse modelToResponse(Entry save);

}
