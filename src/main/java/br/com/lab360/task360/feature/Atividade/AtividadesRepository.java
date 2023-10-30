package br.com.lab360.task360.feature.Atividade;

import br.com.lab360.task360.data.entity.AtividadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadesEntity, Long> {
    // Métodos personalizados, se necessário
}
