package com.poweroutine.dtd;

import com.poweroutine.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTD {
    private UserModel usermodel;
    private String respuesta;

}
