package com.udea.festivos.entidades;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "festivo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Festivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 100)
    String nombre;

    @Column(nullable = false)
    Integer dia;

    @Column(nullable = false)
    Integer mes;

    @Column(nullable = false, name = "diaspascua")
    Integer diasPascua;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id", nullable = false)
    Tipo tipo;

    @Transient
    Date fecha;
}
