package dev.vijay.restdemo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskUpdateRequestDTO {
    private LocalDate due_date;
    private Boolean status;
}
