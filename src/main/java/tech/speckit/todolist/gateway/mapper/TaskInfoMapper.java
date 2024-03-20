package tech.speckit.todolist.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.speckit.todolist.domain.model.TaskEntity;
import tech.speckit.todolist.gateway.dto.TaskInfo;

@Mapper(componentModel = "spring")
public interface TaskInfoMapper {

    @Mapping(source = "id", target = "taskId")
    TaskInfo mapToDto(TaskEntity taskEntity);
}