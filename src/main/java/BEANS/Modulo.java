package BEANS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Modulo {
    private Integer id;
    private String nombre;
    private String duracion;
    private String tipo;
    private String proyectoID;
}
