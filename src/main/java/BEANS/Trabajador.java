package BEANS;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Trabajador {
    private String id;
    private String DNI;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String situacion;
    private String tipo;
    private String contra;
}
