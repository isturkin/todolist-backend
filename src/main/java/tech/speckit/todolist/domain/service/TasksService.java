package tech.speckit.todolist.domain.service;

import tech.speckit.todolist.domain.service.dto.TaskDto;

import java.util.List;

public interface TasksService {

    List<TaskDto> findAll();

    void create(TaskDto taskDto);
}
