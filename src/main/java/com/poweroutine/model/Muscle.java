package com.poweroutine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "muscle", schema = "power_routine")
public class Muscle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "muscle")
    private Set<Ejercice> ejercicios = new LinkedHashSet<>();
}