package br.com.lab360.task360.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter

public class QuadroEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String descricao;

        @OneToMany(mappedBy = "quadro", cascade = CascadeType.ALL)
        private List<AtividadesEntity> atividades;

        private LocalDate data;

        private List<UserEntity> membros;

        @OneToMany(mappedBy = "quadro", cascade = CascadeType.ALL)
        private List<AtividadesEntity> anexos;
        private int completarporcentagem;
    }
