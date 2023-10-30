package br.com.lab360.task360.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "anexos")
@Getter
@Setter

public class AnexosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "quadro_id")
    private QuadroEntity quadro;
}
