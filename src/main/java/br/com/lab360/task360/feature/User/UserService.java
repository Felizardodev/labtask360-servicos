package br.com.lab360.task360.feature.User;

import br.com.lab360.task360.data.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List listarUsuarios() throws JsonProcessingException {
        return userRepository.listarUsuarios();
    }
    /* public UserEntity criarUsuario(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    } */

    public UserEntity criarUsuario(String json) throws JsonProcessingException {
        Map<String, String> jsonMap = new ObjectMapper().readValue(json, HashMap.class);
        UserEntity user = new UserEntity();
        user.setUsername(jsonMap.get("username"));
        user.setPassword(jsonMap.get("password"));
        //return userRepository.save(user);
        return null;
    }

}
