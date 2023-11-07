package br.com.lab360.task360.feature.Cartao;

import br.com.lab360.task360.data.entities.CartaoEntity;
import br.com.lab360.task360.data.entities.ChecklistItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/cartoes")

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
    public CartaoEntity criarCartao(@RequestBody CartaoEntity cartao) {
        return cartaoService.criarCartao(cartao);
    }

    @PutMapping("/{id}")
    public CartaoEntity atualizarCartao(@PathVariable Long id, @RequestBody CartaoEntity cartao) {
        return cartaoService.atualizarCartao(id, cartao);
    }

    @DeleteMapping("/{id}")
    public void excluirCartao(@PathVariable Long id) {
        cartaoService.excluirCartao(id);
    }
    @PutMapping("/{id}/mover/{novaListaId}")
    public CartaoEntity moverCartaoParaNovaLista(@PathVariable Long id, @PathVariable Long novaListaId) {
        return cartaoService.moverCartaoParaNovaLista(id, novaListaId);
    }

    @PutMapping("/{id}/atribuir/{usuarioId}")
    public CartaoEntity atribuirResponsavel(@PathVariable Long id, @PathVariable Long usuarioId) {
        return cartaoService.atribuirResponsavel(id, usuarioId);
    }
    @PutMapping("/{id}/desatribuir")
    public CartaoEntity desatribuirResponsavel(@PathVariable Long id) {
        return cartaoService.desatribuirResponsavel(id);
    }

    @PostMapping("/{id}/checklist/adicionar")
    public CartaoEntity adicionarChecklistItem(@PathVariable Long id, @RequestBody ChecklistItemEntity novoItem) {
        return cartaoService.adicionarChecklistItem(id, novoItem);
    }

    @PutMapping("/{id}/checklist/editar/{checklistItemId}")
    public CartaoEntity editarChecklistItem(@PathVariable Long id, @PathVariable Long checklistItemId, @RequestBody ChecklistItemEntity itemAtualizado) {
        return cartaoService.editarChecklistItem(id, checklistItemId, itemAtualizado);
    }

    @DeleteMapping("/{id}/checklist/remover/{checklistItemId}")
    public CartaoEntity removerChecklistItem(@PathVariable Long id, @PathVariable Long checklistItemId) {
        return cartaoService.removerChecklistItem(id, checklistItemId);
    }

    @PutMapping("/{id}/adicionar-link")
    public CartaoEntity adicionarLink(@PathVariable Long id, @RequestBody String link) {
        return cartaoService.adicionarLink(id, link);
    }

    @PutMapping("/{id}/adicionar-anexo")
    public CartaoEntity adicionarAnexo(@PathVariable Long id, @RequestBody String anexo) {
        return cartaoService.adicionarAnexo(id, anexo);
    }

    @PutMapping("/{id}/remover-anexo")
    public CartaoEntity removerAnexo(@PathVariable Long id, @RequestBody String anexo) {
        return cartaoService.removerAnexo(id, anexo);
    }
}

