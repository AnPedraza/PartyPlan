package com.example.ProyectoWeb.Repository;

import com.example.ProyectoWeb.Entities.pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface pagoRepository extends JpaRepository<pago, Long> {
    
    Optional<pago> findByReserva_Id(Long idReserva);

}