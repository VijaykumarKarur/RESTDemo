package dev.vijay.restdemo.dtos;

import dev.vijay.restdemo.models.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDTO extends BaseResponse {
    private Task task;
}
