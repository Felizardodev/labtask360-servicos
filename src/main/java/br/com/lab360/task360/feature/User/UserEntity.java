package br.com.lab360.task360.feature.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    private Long id;

    private String username;
    private String password;
}