package com.poweroutine.dtd;

import com.poweroutine.model.MuscleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuscleDTD {
    private List<MuscleModel> muscles;
    private String respuesta;
}
