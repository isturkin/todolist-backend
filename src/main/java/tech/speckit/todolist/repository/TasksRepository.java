package tech.speckit.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.speckit.todolist.domain.model.TaskEntity;

public interface TasksRepository extends JpaRepository<TaskEntity, Long> {
}
