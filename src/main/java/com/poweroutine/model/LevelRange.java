package com.poweroutine.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "level_range", schema = "power_routine")
public class LevelRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private Integer level;

    @Column(name = "range_series", length = 10)
    private String rangeSeries;
}