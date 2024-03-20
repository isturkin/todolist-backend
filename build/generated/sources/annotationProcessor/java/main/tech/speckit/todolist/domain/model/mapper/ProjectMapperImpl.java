package tech.speckit.todolist.domain.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.speckit.todolist.controller.dto.ProjectDto;
import tech.speckit.todolist.domain.model.ProjectEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T10:59:49+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.8 (BellSoft)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectEntity mapToEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setName( projectDto.getName() );
        projectEntity.setPriority( projectDto.getPriority() );

        return projectEntity;
    }

    @Override
    public ProjectDto mapToDto(ProjectEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setName( entity.getName() );
        if ( entity.getPriority() != null ) {
            projectDto.setPriority( entity.getPriority() );
        }

        return projectDto;
    }
}
