package br.com.lab360.task360.feature.Cartao;

import br.com.lab360.task360.data.entities.CartaoEntity;
import br.com.lab360.task360.data.entities.ChecklistItemEntity;
import br.com.lab360.task360.data.entities.ListaEntity;
import br.com.lab360.task360.data.entities.UserEntity;
import br.com.lab360.task360.data.repositories.CartaoRepository;
import br.com.lab360.task360.data.repositories.ListaRepository;
import br.com.lab360.task360.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;
    private ListaRepository listaRepository;

    private UserRepository userRepository;

    public List<CartaoEntity> listarCartoes() {
        return cartaoRepository.findAll();
    }

    public CartaoEntity obterCartaoPorId(Long id) {
        return cartaoRepository.findById(id).orElse(null);
    }

    public CartaoEntity criarCartao(CartaoEntity cartao) {
        return cartaoRepository.save(cartao);
    }

    public CartaoEntity atualizarCartao(Long id, CartaoEntity cartao) {
        cartao.setId(id);
        return cartaoRepository.save(cartao);
    }
    public void excluirCartao(Long id) {
        cartaoRepository.deleteById(id);
    }
    public CartaoEntity moverCartaoParaNovaLista(Long cartaoId, Long novaListaId) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);
        ListaEntity novaLista = listaRepository.findById(novaListaId).orElse(null);

        if (cartao != null && novaLista != null) {
            cartao.setLista(novaLista);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão ou lista não encontrados.");
        }
    }
    public CartaoEntity atribuirResponsavel(Long cartaoId, Long usuarioId) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);
        UserEntity responsavel = userRepository.findById(usuarioId).orElse(null);

        if (cartao != null && responsavel != null) {
            cartao.setResponsavel(responsavel);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão ou usuário não encontrados.");
        }
    }
    public CartaoEntity desatribuirResponsavel(Long cartaoId) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);

        if (cartao != null) {
            cartao.setResponsavel(null);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão não encontrado.");
        }
    }

    public CartaoEntity adicionarChecklistItem(Long id, ChecklistItemEntity novoItem) {
        CartaoEntity cartao = cartaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cartão não encontrado."));
        novoItem.setConcluido(false); // Novos itens são inicialmente não concluídos
        cartao.getChecklist().add(novoItem);
        return cartaoRepository.save(cartao);
    }

    public CartaoEntity editarChecklistItem(Long id, Long checklistItemId, ChecklistItemEntity itemAtualizado) {
        CartaoEntity cartao = cartaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cartão não encontrado."));
        ChecklistItemEntity item = cartao.getChecklist().stream()
                .filter(checklistItem -> checklistItem.getId().equals(checklistItemId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Item do checklist não encontrado."));

        item.setNome(itemAtualizado.getNome());
        item.setConcluido(itemAtualizado.isConcluido());

        return cartaoRepository.save(cartao);
    }

    public CartaoEntity removerChecklistItem(Long id, Long checklistItemId) {
        CartaoEntity cartao = cartaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cartão não encontrado."));
        ChecklistItemEntity item = cartao.getChecklist().stream()
                .filter(checklistItem -> checklistItem.getId().equals(checklistItemId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Item do checklist não encontrado."));

        cartao.getChecklist().remove(item);
        return cartaoRepository.save(cartao);
    }

    public CartaoEntity adicionarLink(Long cartaoId, String link) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);

        if (cartao != null) {
            cartao.getLinks().add(link);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão não encontrado.");
        }
    }
    public CartaoEntity adicionarAnexo(Long cartaoId, String anexo) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);

        if (cartao != null) {
            cartao.getAnexos().add(anexo);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão não encontrado.");
        }
    }
    public CartaoEntity removerAnexo(Long cartaoId, String anexo) {
        CartaoEntity cartao = cartaoRepository.findById(cartaoId).orElse(null);

        if (cartao != null) {
            cartao.getAnexos().remove(anexo);
            return cartaoRepository.save(cartao);
        } else {
            throw new EntityNotFoundException("Cartão não encontrado.");
        }
    }
}