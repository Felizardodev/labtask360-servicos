package br.com.lab360.task360.feature.User;

import br.com.lab360.task360.data.entity.UserEntity;
import br.com.lab360.task360.data.repositories.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    //@Query(nativeQuery = true, value= "SELECT * FROM USER_ENTITY")
    //List listarUsuarios();
}
