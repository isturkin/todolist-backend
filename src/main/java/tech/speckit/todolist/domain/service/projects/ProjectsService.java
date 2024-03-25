package tech.speckit.todolist.domain.service.projects;

import tech.speckit.todolist.domain.service.dto.ProjectDto;

import java.util.List;

public interface ProjectsService {

    void create(ProjectDto projectDto);

    List<ProjectDto> getProjects();
}
