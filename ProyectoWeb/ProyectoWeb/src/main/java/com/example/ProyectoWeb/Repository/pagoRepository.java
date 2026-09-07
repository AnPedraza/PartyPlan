package com.example.ProyectoWeb.Repository;

import com.example.ProyectoWeb.Entities.pago;
import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    // Consultar el pago correspondiente a una reserva
    Optional<Pago> findByReserva_IdReserva(Long idReserva);
}