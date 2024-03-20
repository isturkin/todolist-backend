package tech.speckit.todolist.domain.service;

import tech.speckit.todolist.domain.model.TaskEntity;

public interface NotificationsGateway {

    void sendTaskInfo(TaskEntity taskEntity);
}
