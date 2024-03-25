package tech.speckit.todolist.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.speckit.todolist.domain.service.dto.TaskDto;
import tech.speckit.todolist.domain.exception.ProjectNotFoundException;
import tech.speckit.todolist.domain.model.ProjectEntity;
import tech.speckit.todolist.domain.model.TaskEntity;
import tech.speckit.todolist.domain.model.mapper.TaskMapper;
import tech.speckit.todolist.gateway.KafkaNotificationsGateway;
import tech.speckit.todolist.repository.ProjectsRepository;
import tech.speckit.todolist.repository.TasksRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final TaskMapper taskMapper;
    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;
    private final KafkaNotificationsGateway kafkaNotificationsGateway;

    @Override
    public List<TaskDto> findAll() {
        return tasksRepository.findAll()
                .stream()
                .map(taskMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(TaskDto taskDto) {
        ProjectEntity project = projectsRepository.findById(taskDto.getProjectId()).orElseThrow(
                ProjectNotFoundException::new
        );

        TaskEntity taskEntity = taskMapper.mapToEntity(taskDto);
        taskEntity.setProject(project);
        TaskEntity saved = tasksRepository.save(taskEntity);

        kafkaNotificationsGateway.sendTaskInfo(saved);
    }
}
