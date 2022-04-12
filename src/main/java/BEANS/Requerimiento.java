package BEANS;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Requerimiento {
    private Integer id;
    private String nombre;
    private String estado;
    private Integer moduloID;
}
