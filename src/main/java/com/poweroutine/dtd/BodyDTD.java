package com.poweroutine.dtd;

import com.poweroutine.model.BodyModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodyDTD {
    private List<BodyModel> bodys = new ArrayList<>();
    private String respuesta;

    public void addBody(BodyModel bodyModel) {
        this.bodys.add(bodyModel);
    }
}
