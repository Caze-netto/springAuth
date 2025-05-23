package spring.security.auth.spring.Auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.auth.spring.Auth.model.Role;
import spring.security.auth.spring.Auth.model.Usuario;
import spring.security.auth.spring.Auth.service.UsuarioServices;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioServices services;

    @PostMapping
    public ResponseEntity<Usuario> criarUser(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(services.criarUser(usuario));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletarUser(@PathVariable UUID id){
        services.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> listarUser(@PathVariable UUID id){
        if(services.listarUsuario(id) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(services.listarUsuario(id));
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Usuario>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(services.listarTodos());}

    @GetMapping("/listarPorRole/")
    public ResponseEntity<List<Usuario>> listarPorRole(@RequestParam Role role){
        return ResponseEntity.status(HttpStatus.OK).body(services.listarPorRole(role));
    }
 }
