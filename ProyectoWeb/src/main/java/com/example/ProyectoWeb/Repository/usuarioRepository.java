package com.example.ProyectoWeb.Repository;
import com.example.ProyectoWeb.Entities.usuario;
import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    boolean existsByCorreo(String correo);
}