package com.example.demo.controllers;

import com.example.demo.dtos.TaskDto;
import com.example.demo.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService taskService) {
        this.service = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTaskById(Long.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(service.createTask(taskDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Integer id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(service.updateTask(Long.valueOf(id), taskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable Integer id) {
        return ResponseEntity.ok(service.removeTask(Long.valueOf(id)));
    }
}
