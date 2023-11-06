package br.com.lab360.task360.feature.Anexo;

import br.com.lab360.task360.data.entities.AnexosEntity;
import br.com.lab360.task360.data.repositories.AnexosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AnexosService {

    @Autowired
    private AnexosRepository anexosRepository;

    public List<AnexosEntity> listarAnexos() {
        return anexosRepository.findAll();
    }

    public AnexosEntity criarAnexo(AnexosEntity anexos) {
        return anexosRepository.save(anexos);
    }

    public AnexosEntity obterAnexoPorId(Long id) {
        return anexosRepository.findById(id).orElse(null);
    }

    public void excluirAnexo(Long id) {
        anexosRepository.deleteById(id);
    }
}
