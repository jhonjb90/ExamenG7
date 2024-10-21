package pe.proyecto.ExamenG7.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "direccion")
@Getter
@Setter
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String avenida;
    private String numero;
    private String distrito;
    private String provincia;
    private String departamento;
}
