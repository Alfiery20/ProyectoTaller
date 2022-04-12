package BEANS;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Proyecto {
    private String id;
    private String nombre;
    private String duracion;
    private double presupuesto;
    private String etado;
    private Date fechaIni;
    private Date fechaTer;
    private String tipo;
    private String clienteDNI;
}
