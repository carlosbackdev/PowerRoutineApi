package com.poweroutine.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_completes", schema = "power_routine")
public class UserCompletesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    //id mas musculo
    @Column(name = "id_item")
    private Integer idItem;
    private boolean completed;
}
