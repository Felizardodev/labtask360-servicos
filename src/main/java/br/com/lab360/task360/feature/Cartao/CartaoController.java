package br.com.lab360.task360.feature.Cartao;

import br.com.lab360.task360.data.entities.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartoes")

public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @GetMapping
    public List<CartaoEntity> listarCartoes() {
        return cartaoService.listarCartoes();
    }

    @GetMapping("/{id}")
    public CartaoEntity obterCartaoPorId(@PathVariable Long id) {
        return cartaoService.obterCartaoPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartaoEntity criarCartao(@RequestBody CartaoEntity card) {
        return cartaoService.criarCartao(card);
    }

    @PutMapping("/{id}")
    public CartaoEntity atualizarCartao(@PathVariable Long id, @RequestBody CartaoEntity card) {
        return cartaoService.atualizarCartao(id, card);
    }

    @DeleteMapping("/{id}")
    public void excluirCartao(@PathVariable Long id) {
        cartaoService.excluirCartao(id);
    }
}

