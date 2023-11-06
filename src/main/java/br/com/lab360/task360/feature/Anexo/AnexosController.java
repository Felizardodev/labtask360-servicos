package br.com.lab360.task360.feature.Anexo;

import br.com.lab360.task360.data.entities.AnexosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/anexos")
public class AnexosController {

    @Autowired
    private AnexosService anexosService;

    @GetMapping
    public List<AnexosEntity> listarAnexos() {
        return anexosService.listarAnexos();
    }

    @GetMapping("/{anexoId}")
    public AnexosEntity obterAnexoPorId(@PathVariable Long anexoId) {
        return anexosService.obterAnexoPorId(anexoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnexosEntity criarAnexo(@RequestBody AnexosEntity anexo) {
        return anexosService.criarAnexo(anexo);
    }

    @DeleteMapping("/{anexoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAnexo(@PathVariable Long anexoId) {
        anexosService.excluirAnexo(anexoId);
    }
}

