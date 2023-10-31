package br.com.lab360.task360.feature.Quadro;

import br.com.lab360.task360.data.entity.AnexosEntity;
import br.com.lab360.task360.data.entity.QuadroEntity;
import br.com.lab360.task360.data.entity.UserEntity;
import br.com.lab360.task360.feature.Anexo.AnexosRepository;
import br.com.lab360.task360.feature.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadroService {

    @Autowired
    private QuadroRepository quadroRepository;
    private UserRepository userRepository;
    private AnexosRepository anexosRepository;

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

    public AnexosEntity adicionarAnexo(Long quadroId, AnexosEntity anexos) {
        QuadroEntity quadro = quadroRepository.findById(quadroId).orElse(null);

        if (quadro != null) {
                anexos.setQuadro(quadro);
            return anexosRepository.save(anexos);
        }

        return null;
    }

    public QuadroEntity atualizarPorcentagemDeConclusao(Long boardId, int completarPorcentagem) {
        QuadroEntity quadro = quadroRepository.findById(boardId).orElse(null);

        if (quadro != null) {
            quadro.setCompletarporcentagem(completarPorcentagem);
            return quadroRepository.save(quadro);
        }
        return null;
    }
}
