package com.tienda.crud.Repository;

import com.tienda.crud.Model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    Optional<Promocion> findByNombre(String nombre);
}

