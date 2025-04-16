package com.poweroutine.dtd;

import com.poweroutine.model.RutineModel;
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

    public void addRutine(RutineModel rutineModel) {
        if (this.rutinas == null) {
            this.rutinas = new ArrayList<>();
        }
        this.rutinas.add(rutineModel);
    }
}
