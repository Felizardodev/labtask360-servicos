package br.com.lab360.task360.data.repositories;

import br.com.lab360.task360.data.entities.QuadroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuadroRepository extends JpaRepository<QuadroEntity, Long> {
    // Métodos personalizados, se necessário
}
