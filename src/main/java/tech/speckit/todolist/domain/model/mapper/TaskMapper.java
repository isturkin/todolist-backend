package tech.speckit.todolist.domain.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.speckit.todolist.controller.dto.TaskDto;
import tech.speckit.todolist.domain.model.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntity mapToEntity(TaskDto taskDto);
    @Mapping(source = "entity.project.id", target = "projectId")
    TaskDto mapToDto(TaskEntity entity);
}
