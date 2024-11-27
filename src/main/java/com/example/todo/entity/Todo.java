package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

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
    @Column(nullable = false, columnDefinition = "todo_status DEFAULT 'TODO'")
    private TodoStatus status;

    public Todo(Long id) {
        this.id = id;
    }

    public Todo() {

    }
}
