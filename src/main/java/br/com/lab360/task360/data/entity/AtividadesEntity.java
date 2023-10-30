package br.com.lab360.task360.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atividades")
@Getter
@Setter

public class AtividadesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean completado;

    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private QuadroEntity quadro;
}