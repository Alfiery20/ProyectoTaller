package BEANS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsablexProyecto {
    private Integer proyectoID;
    private Integer trabajadorID;
}
