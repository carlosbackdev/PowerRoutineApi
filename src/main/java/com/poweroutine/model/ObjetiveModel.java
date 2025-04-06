package com.poweroutine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "objetive", schema = "power_routine")
public class ObjetiveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    @Column(name = "range_rep", length = 10)
    private String rangeRep;

}