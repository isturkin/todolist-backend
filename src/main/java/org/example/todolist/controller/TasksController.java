package org.example.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.slf4j.MDCContextMap;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;
import org.example.todolist.controller.dto.TaskDto;
import org.example.todolist.domain.service.TasksService;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TasksController {

    private final TasksService tasksService;

    @GetMapping
    public List<TaskDto> getTasks() {
        return tasksService.findAll();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable("taskId") Long taskId) {
        return tasksService.findById(taskId);
    }

    @PostMapping
    public void createTask(@RequestBody TaskDto taskDto) {
        MDC.put("correlationId" + new Random().nextInt(), taskDto.toString());
        tasksService.create(taskDto);
    }

    @PostMapping("/{taskId}")
    public void start(@PathVariable("taskId") Long taskId) {
        tasksService.startWork(taskId);
    }
}
