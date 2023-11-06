package br.com.lab360.task360.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_users")
@Getter
@Setter

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long id;
    @Column private String username;
    @Column private String password;
    @Column private String nomeCompleto;
    @Column private String email;
}