package dev.vijay.restdemo.controllers;

import dev.vijay.restdemo.dtos.*;
import dev.vijay.restdemo.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    private List<Task> taskList = new ArrayList<>();

    /***
     * Method to return all the Tasks
     * @return All the Tasks
     */
    @GetMapping("/")
    public ResponseEntity<TaskAllResponseDTO> getAllTasks(){
        TaskAllResponseDTO response = new TaskAllResponseDTO();
        response.setTaskList(this.taskList);
        response.setStatus(HttpStatus.OK);
        response.setMessage("All Tasks");
        return ResponseEntity.ok(response);
    }

    /***
     * Method to get Task based on id
     * @param id of the Task
     * @return If found, Task is returned
     */
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        TaskResponseDTO response = new TaskResponseDTO();
        if(id < 0 || id >= taskList.size()){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task with Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.setStatus(HttpStatus.OK);
        response.setMessage("Task found");
        response.setTask(taskList.get(id.intValue()));
        return ResponseEntity.ok(response);
    }

    /***
     * Method to Create a new Task
     * @param taskCreateDTO contains the Task details such as name, due date and status
     * @return Task created is returned
     */
    @PostMapping("/")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskCreateDTO taskCreateDTO){
        TaskResponseDTO response = new TaskResponseDTO();
        Task task = taskCreateDTO.getTask();
        if(task == null){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Task to be created is empty/null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(task.getName() == null || task.getName().isEmpty()){
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Mandatory field Task name is missing/null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Task newTask;
        if(task.getDue_date() == null && task.getStatus() == null){
            newTask = new Task(task.getName());
        }
        else if(task.getDue_date() == null){
            newTask = new Task(task.getName(), task.getStatus());
        }
        else if(task.getStatus() == null){
            newTask = new Task(task.getName(), task.getDue_date());
        }
        else{
            newTask = task;
        }
        taskList.add(newTask);
        response.setTask(taskList.get(taskList.size() - 1));
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Task Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /***
     * Method to Update Task
     * @param id Task id to updated
     * @param taskUpdateRequestDTO contains due date and/or status values
     * @return Task updated is returned
     */
    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @RequestBody TaskUpdateRequestDTO taskUpdateRequestDTO){
        TaskResponseDTO response = new TaskResponseDTO();
        if(id < 0 || id >= taskList.size()){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task with Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        Task task = taskList.get(id.intValue());
        if(taskUpdateRequestDTO.getDue_date() != null){
            task.setDue_date(taskUpdateRequestDTO.getDue_date());
        }
        if(taskUpdateRequestDTO.getStatus() != null){
            task.setStatus(taskUpdateRequestDTO.getStatus());
        }
        taskList.set(id.intValue(), task);
        response.setStatus(HttpStatus.OK);
        response.setMessage("Task Updated");
        response.setTask(task);
        return ResponseEntity.ok(response);
    }

    /***
     * Method to delete Task
     * @param id of the Task to be deleted
     * @return Task deleted
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> deleteTask(@PathVariable Long id){
        TaskResponseDTO response = new TaskResponseDTO();
        if(id < 0 || id >= taskList.size()){
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Task with Id not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.setStatus(HttpStatus.OK);
        response.setMessage("Task Deleted");
        response.setTask(taskList.get(id.intValue()));
        taskList.remove(id.intValue());
        return ResponseEntity.ok().body(response);
    }
}
