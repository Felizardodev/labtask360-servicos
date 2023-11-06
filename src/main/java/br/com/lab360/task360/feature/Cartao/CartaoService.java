package br.com.lab360.task360.feature.Cartao;

import br.com.lab360.task360.data.entities.CartaoEntity;
import br.com.lab360.task360.data.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public List<CartaoEntity> listarCartoes() {
        return cartaoRepository.findAll();
    }

    public CartaoEntity obterCartaoPorId(Long id) {
        return cartaoRepository.findById(id).orElse(null);
    }

    public CartaoEntity criarCartao(CartaoEntity card) {
        return cartaoRepository.save(card);
    }

    public CartaoEntity atualizarCartao(Long id, CartaoEntity card) {
        card.setId(id);
        return cartaoRepository.save(card);
    }

    public void excluirCartao(Long id) {
        cartaoRepository.deleteById(id);
    }
}

