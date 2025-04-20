package com.poweroutine.model;


import com.poweroutine.utils.IntegerListConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rutine_user", schema = "power_routine")
public class RutineUserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "id_rutine")
    private Integer idRutine;

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

    public void setRutine(RutineModel rutine) {
        idRutine = rutine.getId();
        name = rutine.getName();
        idBody = rutine.getIdBody();
        idEjercices = rutine.getIdEjercices();
        image = rutine.getImage();
        rutineIncompatible = rutine.getRutineIncompatible();
        type = rutine.getType();
        complement = rutine.getComplement();
        muscle_principal = rutine.getMuscle_principal();
        dayweek = rutine.getDayweek();
    }

}