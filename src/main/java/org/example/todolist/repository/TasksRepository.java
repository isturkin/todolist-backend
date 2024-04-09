package org.example.todolist.repository;

import org.example.todolist.domain.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TasksRepository extends JpaRepository<TaskEntity, Long> {

    @Modifying
    @Query(value = "UPDATE tasks SET estimation_in_hours = :newEstimation WHERE id = :taskId", nativeQuery = true)
    void updateEstimation(Long taskId, Integer newEstimation);
}
