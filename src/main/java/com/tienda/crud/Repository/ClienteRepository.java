package com.tienda.crud.Repository;

import com.tienda.crud.Model.Cliente;
import org.springframework.context.annotation.Import;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email); // 🔥 Este es el que falta
}
