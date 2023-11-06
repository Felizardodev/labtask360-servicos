package br.com.lab360.task360.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cartao")
@Getter
@Setter

public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuarioAtribuido;

}

