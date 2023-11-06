package br.com.lab360.task360.feature.Quadro;

import br.com.lab360.task360.data.entities.QuadroEntity;
import br.com.lab360.task360.data.entities.UserEntity;
import br.com.lab360.task360.data.repositories.QuadroRepository;
import br.com.lab360.task360.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;
    private UserRepository userRepository;

    public List<QuadroEntity> listarQuadros() {
        return quadroRepository.findAll();
    }

    public QuadroEntity criarQuadro(QuadroEntity quadro) {
        return quadroRepository.save(quadro);
    }

    public QuadroEntity obterQuadroPorId(Long id) {
        return quadroRepository.findById(id).orElse(null);
    }

    public void excluirQuadro(Long id) {
        quadroRepository.deleteById(id);
    }

    public void adicionarMembro(Long quadroId, Long userId) {
        QuadroEntity quadro = quadroRepository.findById(quadroId).orElse(null);
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (quadro != null && user != null) {
            quadro.getMembros().add(user);
            quadroRepository.save(quadro);
        }
    }
}
