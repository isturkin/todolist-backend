package tech.speckit.todolist.gateway.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.speckit.todolist.avro.TaskInfoEvent;
import tech.speckit.todolist.domain.model.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskInfoEventMapper {

    @Mapping(source = "id", target = "taskId")
    TaskInfoEvent mapToDto(TaskEntity taskEntity);
}