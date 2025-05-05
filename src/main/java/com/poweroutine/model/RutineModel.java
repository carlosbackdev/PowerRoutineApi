package com.poweroutine.model;

import com.poweroutine.utils.IntegerListConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "rutine", schema = "power_routine")
public class RutineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "id_body")
    @Convert(converter = IntegerListConverter.class)

    private List<Integer> idBody;
    @Column(name = "id_ejercices")

    @Convert(converter = IntegerListConverter.class)
    private List<Integer> idEjercices;

    private String image;

    @Column(name = "rutine_incompatible")
    @Convert(converter = IntegerListConverter.class)
    private List<Integer> rutineIncompatible;

    private String type;

    @Convert(converter = IntegerListConverter.class)
    private List<Integer> complement;

    @Convert(converter = IntegerListConverter.class)
    private List<Integer> muscle_principal;

    private String dayweek;

}