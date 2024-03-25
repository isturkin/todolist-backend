package tech.speckit.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.speckit.todolist.domain.service.dto.GoalDto;
import tech.speckit.todolist.domain.service.goals.GoalsService;

@RequiredArgsConstructor
@RequestMapping("/goals")
@RestController
public class GoalsController {

    private final GoalsService goalsService;

    @PostMapping
    public void setGoal(@RequestBody GoalDto goalDto) {
        goalsService.setGoal(goalDto);
    }
}
