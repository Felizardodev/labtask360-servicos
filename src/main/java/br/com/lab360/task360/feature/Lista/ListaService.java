package br.com.lab360.task360.feature.Lista;

import br.com.lab360.task360.data.entity.ListaEntity;
import br.com.lab360.task360.data.entity.QuadroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public List<ListaEntity> listarListasPorQuadro(Long quadroId) {
        return listaRepository.findByQuadroId(quadroId);
    }

    public ListaEntity criarLista(Long quadroId, ListaEntity lista) {
        QuadroEntity quadro = new QuadroEntity();
        quadro.setId(quadroId);
        lista.setQuadro(quadro);
        return listaRepository.save(lista);
    }

    public ListaEntity editarLista(Long listaId, ListaEntity listaAtualizada) {
        ListaEntity listaExistente = listaRepository.findById(listaId).orElse(null);

        if (listaExistente != null) {
            listaExistente.setNome(listaAtualizada.getNome());
            return listaRepository.save(listaExistente);
        }

        return null;
    }

    public void excluirLista(Long listaId) {
        listaRepository.deleteById(listaId);
    }

    public void excluirListasPorQuadro(Long quadroId) {
        listaRepository.deleteByQuadroId(quadroId);
    }
}

