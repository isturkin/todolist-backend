package tech.speckit.todolist.domain.model.mapper;

import org.mapstruct.Mapper;
import tech.speckit.todolist.domain.service.dto.ProjectDto;
import tech.speckit.todolist.domain.model.ProjectEntity;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectEntity mapToEntity(ProjectDto projectDto);

    ProjectDto mapToDto(ProjectEntity entity);
}
