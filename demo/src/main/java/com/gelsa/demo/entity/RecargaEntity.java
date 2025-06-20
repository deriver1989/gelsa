package com.gelsa.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="recarga")

public class RecargaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorRecarga;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private PersonaEntity id_persona;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    private OperadorEntity id_operador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(Double valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public PersonaEntity getId_persona() {
        return id_persona;
    }

    public void setId_persona(PersonaEntity id_persona) {
        this.id_persona = id_persona;
    }

    public OperadorEntity getId_operador() {
        return id_operador;
    }

    public void setId_operador(OperadorEntity id_operador) {
        this.id_operador = id_operador;
    }
}
