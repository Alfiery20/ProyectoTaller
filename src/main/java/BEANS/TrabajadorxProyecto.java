package BEANS;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrabajadorxProyecto {
    private Integer proyectoId;
    private Integer trabajadorId;
}

