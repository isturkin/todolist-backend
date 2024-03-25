package tech.speckit.todolist.domain.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class GoalDto {

    private String text;
    private Instant expiredAt;
}
