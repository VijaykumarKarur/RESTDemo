package dev.vijay.restdemo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private String name;
    private LocalDate due_date;
    private Boolean status;

    public Task(String name) {
        this.name = name;
        this.due_date = LocalDate.now().plusDays(7);
        this.status = false;
    }

    public Task(String name, LocalDate due_date) {
        this.name = name;
        this.due_date = due_date;
        this.status = false;
    }

    public Task(String name, Boolean status) {
        this.name = name;
        this.due_date = LocalDate.now().plusDays(7);
        this.status = status;
    }
}
