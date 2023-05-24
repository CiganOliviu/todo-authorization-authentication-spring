package com.example.demo.dtos;

import com.example.demo.models.Status;
import com.example.demo.models.Type;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private String name;
    private String estimation;
    private String description;
    private Status status;
    private Type type;
}
