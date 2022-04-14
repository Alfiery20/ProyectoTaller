package BEANS;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Requerimiento {

    private String id;
    private String nombre;
    private String estado;
    private String descripcion;
    private Integer moduloID;
}
