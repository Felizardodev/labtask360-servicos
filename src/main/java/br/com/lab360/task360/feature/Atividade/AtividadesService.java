package br.com.lab360.task360.feature.Atividade;

import br.com.lab360.task360.data.entities.AtividadesEntity;
import br.com.lab360.task360.data.repositories.AtividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadesService {

    @Autowired
    private AtividadesRepository atividadesRepository;

    public List<AtividadesEntity> listarAtividades() {
        return atividadesRepository.findAll();
    }

    public AtividadesEntity criarAtividade(AtividadesEntity atividades) {
        return atividadesRepository.save(atividades);
    }

    public AtividadesEntity obterAtividadePorId(Long id) {
        return atividadesRepository.findById(id).orElse(null);
    }

    public void excluirAtividade(Long id) {
        atividadesRepository.deleteById(id);
    }

    public void marcarAtividadeComoConcluida(Long atividadesId) {
        AtividadesEntity atividades = atividadesRepository.findById(atividadesId).orElse(null);

        if (atividades != null) {
            atividades.setCompletado(true);
            atividadesRepository.save(atividades);
        }
    }
}

