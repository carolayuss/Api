package com.tienda.crud.Repository;

import com.tienda.crud.Model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
}
