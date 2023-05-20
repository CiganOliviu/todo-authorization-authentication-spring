package com.example.todoapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Tasks")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TaskId")
    private int id;

    private String title;
    private String description;
}
