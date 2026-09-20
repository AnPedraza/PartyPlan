package com.example.ProyectoWeb.Repository;
import com.example.ProyectoWeb.Entities.reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    
    List<Reserva> findByUsuario_IdUsuario(Long idUsuario);
    List<Reserva> findByPlan_IdPlanAndFecha(Long idPlan, LocalDate fecha);
    List<Reserva> findByEstado(String estado);
}