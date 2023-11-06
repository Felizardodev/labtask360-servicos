package br.com.lab360.task360.data.entities;

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

        private LocalDate data;

        private List<UserEntity> membros;
    }
