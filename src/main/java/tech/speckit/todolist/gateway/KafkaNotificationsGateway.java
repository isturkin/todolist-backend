package tech.speckit.todolist.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tech.speckit.todolist.avro.TaskInfoEvent;
import tech.speckit.todolist.domain.model.TaskEntity;
import tech.speckit.todolist.domain.service.NotificationsGateway;
import tech.speckit.todolist.gateway.dto.TaskInfo;
import tech.speckit.todolist.gateway.mapper.TaskInfoEventMapper;
import tech.speckit.todolist.gateway.mapper.TaskInfoMapper;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaNotificationsGateway implements NotificationsGateway {

    private final KafkaTemplate<String, TaskInfoEvent> taskInfoProducer;
    private final TaskInfoEventMapper taskInfoEventMapper;

    @Override
    public void sendTaskInfo(TaskEntity taskEntity) {
        try {
            taskInfoProducer.send("common.avro.notifications", String.valueOf(taskEntity.getId()),
                    taskInfoEventMapper.mapToDto(taskEntity));
        } catch (Exception ex) {
            log.error("Error occurred during sending to Kafka", ex);
        }
    }
}
