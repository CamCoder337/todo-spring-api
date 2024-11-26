package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createdBy;
    private String createdDate;
}
