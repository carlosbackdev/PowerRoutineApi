package com.poweroutine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "rutine", schema = "power_routine")
public class Rutine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private Integer type;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_level_range")
    private LevelRange levelRange;

    @ManyToMany
    @JoinTable(
            name = "rutina_body",
            joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_body")
    )
    private Set<Body> cuerpos;

    @ManyToMany
    @JoinTable(
            name = "rutina_ejercicio",
            joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_ejercicio")
    )
    private Set<Ejercice> ejercicios;

    @ManyToMany
    @JoinTable(
            name = "rutina_incompatible",
            joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_incompatible")
    )
    private Set<Rutine> incompatibles;

    @ManyToMany(mappedBy = "rutinas")
    @JsonIgnore
    private Set<UserModel> usuarios;
}