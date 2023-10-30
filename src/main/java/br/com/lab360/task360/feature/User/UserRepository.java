package br.com.lab360.task360.feature.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(nativeQuery = true, value= "SELECT * FROM USER_ENTITY")
    List listarUsuarios();
}
