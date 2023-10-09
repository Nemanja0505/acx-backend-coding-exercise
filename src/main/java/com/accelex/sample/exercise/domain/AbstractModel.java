package com.accelex.sample.exercise.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "persisted_at", updatable = false)
    private LocalDateTime persistedAt = LocalDateTime.now();

    private Boolean deleted = false;

    @Version
    private int version;

}
