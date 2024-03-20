package tech.speckit.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.speckit.todolist.controller.dto.TaskDto;
import tech.speckit.todolist.domain.service.TasksService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TasksController {

    private final TasksService tasksService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return tasksService.findAll();
    }

    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {
        tasksService.create(taskDto);
    }
}
