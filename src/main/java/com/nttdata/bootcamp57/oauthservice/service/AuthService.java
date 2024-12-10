package com.nttdata.bootcamp57.oauthservice.service;

import com.nttdata.bootcamp57.oauthservice.dto.LoginResponse;
import com.nttdata.bootcamp57.oauthservice.model.Usuario;
import com.nttdata.bootcamp57.oauthservice.dto.LoginRequest;
import com.nttdata.bootcamp57.oauthservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService  {
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Value("${config.security.oauth.jwt.expiration_time}")
    private Integer timeOut;

    public AuthService(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse authenticateAndGenerateToken(LoginRequest loginRequest) {

        Usuario usuario = usuarioRepository.findByUsername(loginRequest.getUsername());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        // Verificar si la contraseña es correcta
        if (!passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return new LoginResponse(
                jwtService.generateToken(loginRequest.getUsername()),
                "Bearer",
                timeOut);
    }
}
