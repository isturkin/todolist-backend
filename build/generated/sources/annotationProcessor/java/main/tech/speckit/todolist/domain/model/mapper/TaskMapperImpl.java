package tech.speckit.todolist.domain.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.speckit.todolist.controller.dto.TaskDto;
import tech.speckit.todolist.domain.model.ProjectEntity;
import tech.speckit.todolist.domain.model.TaskEntity;
import tech.speckit.todolist.domain.model.TaskStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T11:07:38+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.8 (BellSoft)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity mapToEntity(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setText( taskDto.getText() );
        if ( taskDto.getStatus() != null ) {
            taskEntity.setStatus( Enum.valueOf( TaskStatus.class, taskDto.getStatus() ) );
        }

        return taskEntity;
    }

    @Override
    public TaskDto mapToDto(TaskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setProjectId( entityProjectId( entity ) );
        taskDto.setText( entity.getText() );
        if ( entity.getStatus() != null ) {
            taskDto.setStatus( entity.getStatus().name() );
        }

        return taskDto;
    }

    private Long entityProjectId(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }
        ProjectEntity project = taskEntity.getProject();
        if ( project == null ) {
            return null;
        }
        Long id = project.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
