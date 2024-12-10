package com.nttdata.bootcamp57.oauthservice.repository;

import com.nttdata.bootcamp57.oauthservice.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
        Usuario findByUsername(String username);
}
