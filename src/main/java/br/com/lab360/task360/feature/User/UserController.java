package br.com.lab360.task360.feature.User;

import br.com.lab360.task360.data.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/criar-usuario")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity criarUsuario(@RequestBody (required = true) String json) throws JsonProcessingException {
        return service.criarUsuario(json);
    }
    @GetMapping("/consultar-usuarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Map> consultarUsuarios() throws JsonProcessingException {
        return service.listarUsuarios();
    }
}
