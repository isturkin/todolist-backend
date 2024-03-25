package tech.speckit.todolist.domain.service.goals;

import org.springframework.stereotype.Service;
import tech.speckit.todolist.domain.service.dto.GoalDto;

@Service
public class DefaultGoalsService implements GoalsService {
    @Override
    public void setGoal(GoalDto goalDto) {
        // setting goal logic
    }
}
