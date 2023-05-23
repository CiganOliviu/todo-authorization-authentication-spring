package com.example.demo.services;

import com.example.demo.dtos.TaskDto;
import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    public List<TaskDto> getAllTasks() {
        Iterable<Task> tasks = taskRepository.findAll();
        List<TaskDto> taskDtos = new ArrayList<>();

        tasks.forEach(task -> taskDtos.add(TaskDto.builder().id(Math.toIntExact(task.getId()))
                .name(task.getName()).estimation(task.getEstimation()).build()));

        return taskDtos;
    }
}
