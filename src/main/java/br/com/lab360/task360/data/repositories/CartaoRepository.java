package br.com.lab360.task360.data.repositories;

import br.com.lab360.task360.data.entities.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {
}

