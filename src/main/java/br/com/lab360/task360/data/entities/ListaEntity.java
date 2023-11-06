package br.com.lab360.task360.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "listas")
@Getter
@Setter

public class ListaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private QuadroEntity quadro;
}
