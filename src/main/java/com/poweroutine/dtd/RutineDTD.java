package com.poweroutine.dtd;

import com.poweroutine.model.RutineModel;
import com.poweroutine.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RutineDTD {
    private ArrayList<RutineModel> rutinas;
    private String respuesta;
    private UserModel userModel;

    public RutineDTD(ArrayList<RutineModel> rutinas, String respuesta) {
        this.rutinas = rutinas;
        this.respuesta = respuesta;
    }
    public RutineDTD(ArrayList<RutineModel> rutinas, UserModel userModel) {
        this.rutinas = rutinas;
        this.userModel = userModel;
    }

    public void addRutine(RutineModel rutineModel) {
        if (this.rutinas == null) {
            this.rutinas = new ArrayList<>();
        }
        this.rutinas.add(rutineModel);
    }
}
