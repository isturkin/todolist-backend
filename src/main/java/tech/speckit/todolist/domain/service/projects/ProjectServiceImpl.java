package tech.speckit.todolist.domain.service.projects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.speckit.todolist.domain.service.dto.ProjectDto;
import tech.speckit.todolist.domain.model.mapper.ProjectMapper;
import tech.speckit.todolist.repository.ProjectsRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectsService {

    private final ProjectsRepository projectsRepository;
    private final ProjectMapper projectMapper;

    @Override
    public void create(ProjectDto projectDto) {
        projectsRepository.save(projectMapper.mapToEntity(projectDto));
    }

    @Override
    public List<ProjectDto> getProjects() {
        return projectsRepository.findAll()
                .stream()
                .map(projectMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
