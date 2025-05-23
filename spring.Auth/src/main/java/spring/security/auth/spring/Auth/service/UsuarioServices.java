package spring.security.auth.spring.Auth.service;

import org.springframework.stereotype.Service;
import spring.security.auth.spring.Auth.model.Role;
import spring.security.auth.spring.Auth.model.Usuario;
import spring.security.auth.spring.Auth.repository.UsuarioRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServices {

    private UsuarioRepository repository;

    public Usuario criarUser(Usuario usuario){
        repository.save(usuario);
        return usuario;
    }

    public void deletarUsuario(UUID id){
        repository.deleteById(id);
    }

    public Usuario listarUsuario(UUID id){
        return repository.findById(id).orElse(null);
    }

    public List<Usuario> listarTodos(){
       return repository.findAll();
    }

    public List<Usuario> listarPorRole(Role role){
        return repository.findByRole(role);
    }
}
