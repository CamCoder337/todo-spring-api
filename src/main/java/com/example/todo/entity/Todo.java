package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private String status;

}
