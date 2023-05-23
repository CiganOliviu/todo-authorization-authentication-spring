package com.example.demo.services;

import com.example.demo.dtos.TaskDto;
import com.example.demo.exceptions.OperationException;
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

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new OperationException("Task does not exist"));

        return TaskDto.builder()
                .id(Math.toIntExact(task.getId()))
                .name(task.getName())
                .estimation(task.getEstimation())
                .build();
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = Task.builder()
                .name(taskDto.getName())
                .estimation(taskDto.getEstimation())
                .build();

        taskRepository.save(task);
        taskDto.setId(Math.toIntExact(task.getId()));

        return taskDto;
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new OperationException("Task does not exist"));

        task.setName(taskDto.getName() != null ? taskDto.getName() : task.getName());
        task.setEstimation(taskDto.getEstimation() != null ? taskDto.getEstimation() : task.getEstimation());
        taskRepository.save(task);

        taskDto.setId(Math.toIntExact(task.getId()));
        taskDto.setName(task.getName());
        taskDto.setEstimation(task.getEstimation());

        return taskDto;
    }

    public TaskDto removeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new OperationException("Task does not exist"));
        taskRepository.deleteById(id);

        return TaskDto.builder()
                .id(Math.toIntExact(task.getId()))
                .name(task.getName())
                .estimation(task.getEstimation()).build();
    }
}
