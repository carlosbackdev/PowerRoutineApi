package com.poweroutine.dtd;

import com.poweroutine.model.RutineModel;
import com.poweroutine.model.RutineUserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RutineUserDTD {
    private List<RutineUserModel> rutinas;
    private String respuesta;

}
