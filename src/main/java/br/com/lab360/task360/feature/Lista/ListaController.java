package br.com.lab360.task360.feature.Lista;

import br.com.lab360.task360.data.entity.ListaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping("/quadro/{quadroId}")
    public List<ListaEntity> listarListasPorQuadro(@PathVariable Long quadroId) {
        return listaService.listarListasPorQuadro(quadroId);
    }

    @PostMapping("/quadro/{quadroId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ListaEntity criarLista(@PathVariable Long boardId, @RequestBody ListaEntity lista) {
        return listaService.criarLista(boardId, lista);
    }

    @PutMapping("/{listId}")
    public ListaEntity editarLista(@PathVariable Long listaId, @RequestBody ListaEntity listaAtualizada) {
        return listaService.editarLista(listaId, listaAtualizada);
    }

    @DeleteMapping("/{listId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirLista(@PathVariable Long listaId) {
        listaService.excluirLista(listaId);
    }

    @DeleteMapping("/quadro/{quadroId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirListasPorQuadro(@PathVariable Long quadroId) {
        listaService.excluirListasPorQuadro(quadroId);
    }
}

