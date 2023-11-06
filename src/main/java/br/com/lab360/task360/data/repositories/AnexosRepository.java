package br.com.lab360.task360.data.repositories;

import br.com.lab360.task360.data.entities.AnexosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexosRepository extends JpaRepository<AnexosEntity, Long> {
}
