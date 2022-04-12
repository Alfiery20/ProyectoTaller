package BEANS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    private String situacion;

}
