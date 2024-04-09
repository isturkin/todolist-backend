package org.example.todolist.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class TaskDto {

    private String text;
    private String status;
    private Long projectId;
}
