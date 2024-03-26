package tech.speckit.todolist.gateway.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.speckit.todolist.domain.model.TaskEntity;
import tech.speckit.todolist.gateway.dto.TaskInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-26T11:05:52+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.8 (BellSoft)"
)
@Component
public class TaskInfoMapperImpl implements TaskInfoMapper {

    @Override
    public TaskInfo mapToDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskInfo taskInfo = new TaskInfo();

        taskInfo.setTaskId( taskEntity.getId() );

        return taskInfo;
    }
}
