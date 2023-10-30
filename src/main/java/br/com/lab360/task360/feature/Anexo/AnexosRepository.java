package br.com.lab360.task360.feature.Anexo;

import br.com.lab360.task360.data.entity.AnexosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexosRepository extends JpaRepository<AnexosEntity, Long> {
    // Métodos personalizados, se necessário
}
