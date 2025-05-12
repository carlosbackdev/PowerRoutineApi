package com.poweroutine.dtd;

import com.poweroutine.model.UserCompletesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCompletesDTD {
    private List<UserCompletesModel> userCompletesModel;
    private String respuesta;
}
