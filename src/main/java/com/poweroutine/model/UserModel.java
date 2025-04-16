package com.poweroutine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "usuario", schema = "power_routine")
@Data
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer idLevelRange;
    private Integer idObjetive;
    private Integer daysWeek;


    @ManyToMany
    @JoinTable(
            name = "usuario_rutina",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rutina")
    )
    @JsonIgnore
    private Set<RutineModel> rutinas;


    public void vaciar(){
        name = null;
        email = null;
        password = null;
        daysWeek = null;
        idObjetive = null;
        idLevelRange = null;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idLevelRange=" + idLevelRange +
                ", idObjetive=" + idObjetive +
                ", daysWeek=" + daysWeek +
                ", rutinas=" + rutinas +
                '}';
    }
}
