package br.com.lab360.task360.feature.User;

import br.com.lab360.task360.data.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<UserEntity> listarUsuarios() {
        return userRepository.findAll();
    }

    public UserEntity obterUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity criarUsuario(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity editarUsuario(Long userId, UserEntity userAtualizado) {
        UserEntity userExistente = userRepository.findById(userId).orElse(null);

        if (userExistente != null) {
            userExistente.setUsername(userAtualizado.getUsername());
            userExistente.setPassword(userAtualizado.getPassword());
            userExistente.setNomeCompleto(userAtualizado.getNomeCompleto());
            userExistente.setEmail(userAtualizado.getEmail());
            // Atualize outros campos de perfil e configurações de conta conforme necessário
            return userRepository.save(userExistente);
        }
        return null;
    }

    public void excluirUsuario(Long userId) {
        userRepository.deleteById(userId);
    }
}
    /*
    public List listarUsuarios() throws JsonProcessingException {
        return userRepository.listarUsuarios();
    }
     public UserEntity criarUsuario(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public UserEntity criarUsuario(String json) throws JsonProcessingException {
        Map<String, String> jsonMap = new ObjectMapper().readValue(json, HashMap.class);
        UserEntity user = new UserEntity();
        user.setUsername(jsonMap.get("username"));
        user.setPassword(jsonMap.get("password"));
        //return userRepository.save(user);
        return null;
    }*/
