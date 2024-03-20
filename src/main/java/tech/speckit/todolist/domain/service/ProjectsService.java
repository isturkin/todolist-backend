package tech.speckit.todolist.domain.service;

import tech.speckit.todolist.controller.dto.ProjectDto;

import java.util.List;

public interface ProjectsService {

    void create(ProjectDto projectDto);

    List<ProjectDto> getProjects();
}
