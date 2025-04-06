package com.poweroutine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_level_range")
    @JsonIgnore
    private LevelRange idLevelRange;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_objetive")
    @JsonIgnore
    private ObjetiveModel idObjetive;

    @Column(name = "days_week")
    private Integer daysWeek;

    @ManyToMany
    @JoinTable(
            name = "usuario_rutina",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rutina")
    )
    @JsonIgnore
    private Set<Rutine> rutinas;

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", daysWeek=" + daysWeek +
                '}';
    }
    public void vaciar(){
        name = null;
        email = null;
        password = null;
        daysWeek = null;
    }
}
