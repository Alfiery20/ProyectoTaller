package BEANS;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Requerimiento {

    private Integer id;
    private String nombre;
    private String estado;
    private String descripcion;
    private Integer moduloID;
}
