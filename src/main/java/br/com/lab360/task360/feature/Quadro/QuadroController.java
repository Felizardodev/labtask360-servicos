package br.com.lab360.task360.feature.Quadro;

import br.com.lab360.task360.data.entities.QuadroEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class QuadroController {
    private QuadroService quadroService;

    @PostMapping("/{quadrodId}/membros/{userId}")
    public void adicionarMembroAoQuadro(@PathVariable Long quadrodId, @PathVariable Long userId) {
        quadroService.adicionarMembro(quadrodId, userId);
    }

    @PutMapping("/{quadrodId}/completarPorcentagem")
    public QuadroEntity atualizarPorcentagemDeConclusao(@PathVariable Long quadrodId, @RequestParam int completarPorcentagem) {
        return quadroService.atualizarPorcentagemDeConclusao(quadrodId, completarPorcentagem);
    }
}

