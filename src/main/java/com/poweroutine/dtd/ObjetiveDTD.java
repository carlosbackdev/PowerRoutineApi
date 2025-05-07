package com.poweroutine.dtd;

import com.poweroutine.model.ObjetiveModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjetiveDTD {
    private List<ObjetiveModel> objetives;
    private String respuesta;
}
