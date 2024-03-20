package tech.speckit.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.speckit.todolist.domain.model.ProjectEntity;

public interface ProjectsRepository extends JpaRepository<ProjectEntity, Long> {
}
