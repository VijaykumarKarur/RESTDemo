package dev.vijay.restdemo.dtos;

import dev.vijay.restdemo.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaskAllResponseDTO extends BaseResponse{
    private List<Task> taskList;
}
