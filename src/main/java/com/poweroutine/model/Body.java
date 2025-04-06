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
@Table(name = "body", schema = "power_routine")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "body")
    private Set<Ejercice> ejercicios = new LinkedHashSet<>();

}