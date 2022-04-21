package BEANS;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TrabajadorxProyecto {
    private String proyectoId;
    private String trabajadorId;
}

