package com.poweroutine.dtd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTD {
    private String respuesta;
    private boolean sucessful;
}
