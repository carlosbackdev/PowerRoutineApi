package com.poweroutine.dtd;

import com.poweroutine.model.EjerciceModel;
import com.poweroutine.model.RutineModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjerciceDTD {
    private ArrayList<EjerciceModel> ejercices;
    private String respuesta;

    public void addEjercice(EjerciceModel ejerciceModel) {
        if (this.ejercices == null) {
            this.ejercices = new ArrayList<>();
        }
        this.ejercices.add(ejerciceModel);
    }

}
