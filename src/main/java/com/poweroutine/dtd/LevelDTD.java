package com.poweroutine.dtd;

import com.poweroutine.model.LevelRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDTD {
    private List<LevelRange> levels;
    private String respuesta;

}
