package br.com.lab360.task360.data.repositories;

import br.com.lab360.task360.data.entities.AtividadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadesEntity, Long> {
    // Métodos personalizados, se necessário
}