package com.poweroutine.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ejercice", schema = "power_routine")
public class EjerciceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String descripcion;
    @Column(name = "id_body")
    private  Integer idBody;
    @Column(name = "id_muscle")
    private  Integer idMuscle;
    private String image;
    private String material;
    private boolean basic;
}