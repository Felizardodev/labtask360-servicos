package br.com.lab360.task360.feature.Lista;

import br.com.lab360.task360.data.entity.ListaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<ListaEntity, Long> {
    List<ListaEntity> findByQuadroId(Long quadroId);
    void deleteByQuadroId(Long quadroId);
}

