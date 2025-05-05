package com.poweroutine.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "body", schema = "power_routine")
public class BodyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String image;

}