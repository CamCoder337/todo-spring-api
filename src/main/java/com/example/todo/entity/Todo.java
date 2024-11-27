package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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

    @Setter
    @Column(nullable = false)
    private int priority = 0;

    @Setter
    @Enumerated(EnumType.STRING)
    @Value("TODO")
    @Column(nullable = false)
    private TodoStatus status;

    public Todo(Long id) {
        this.id = id;
    }

    public Todo() {

    }
}
