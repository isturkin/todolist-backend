package org.example.todolist.domain.service;

import com.github.benmanes.caffeine.cache.Cache;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.example.todolist.config.MetricsHelper;
import org.example.todolist.controller.dto.TaskDto;
import org.example.todolist.domain.model.TaskStatus;
import org.example.todolist.repository.ProjectsRepository;
import org.example.todolist.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.example.todolist.domain.exception.ProjectNotFoundException;
import org.example.todolist.domain.exception.TaskNotFoundException;
import org.example.todolist.domain.model.ProjectEntity;
import org.example.todolist.domain.model.TaskEntity;
import org.example.todolist.domain.model.mapper.TaskMapper;
import org.example.todolist.gateway.KafkaNotificationsGateway;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final TaskMapper taskMapper;
    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;
    private final KafkaNotificationsGateway kafkaNotificationsGateway;
    private final Cache<Long, TaskEntity> tasksCache;
    private final MetricsHelper metricsHelper;

    @PostConstruct
    public void initCache() {
        List<TaskEntity> taskEntities = tasksRepository.findAll();
        taskEntities.forEach(it -> {
            tasksCache.put(it.getId(), it);
                }
        );
        System.out.println("CACHE SIZE: " + tasksCache.estimatedSize());
    }

    @Override
    public List<TaskDto> findAll() {
        return tasksRepository.findAll()
                .stream()
                .map(taskMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findById(Long taskId) {
        TaskEntity cached = tasksCache.getIfPresent(taskId);
        if (cached != null) {
            return taskMapper.mapToDto(cached);
        } else {
            return taskMapper.mapToDto(tasksRepository.findById(taskId).orElseThrow(TaskNotFoundException::new));
        }
    }

    @Override
    public void create(TaskDto taskDto) {
        ProjectEntity project = projectsRepository.findById(taskDto.getProjectId()).orElseThrow(
                ProjectNotFoundException::new
        );

        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskEntity.setProject(project);
        TaskEntity saved = tasksRepository.save(taskEntity);
        tasksCache.put(saved.getId(), saved);

        metricsHelper.buildTaskCounter().increment();

//        kafkaNotificationsGateway.sendTaskInfo(saved);
    }

    @Transactional
    @Override
    public void startWork(Long taskId) {
        TaskEntity taskEntity = tasksRepository.findById(taskId).orElseThrow(
                TaskNotFoundException::new
        );

        taskEntity.setStatus(TaskStatus.IN_PROGRESS);
        tasksRepository.save(taskEntity);
    }
}
