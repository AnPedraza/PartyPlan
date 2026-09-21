package com.example.ProyectoWeb.Repository;

import com.example.ProyectoWeb.Entities.reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface reservaRepository extends JpaRepository<reserva, Long> {

    List<reserva> findByUsuario_Id(Long idUsuario);

    List<reserva> findByPlan_IdAndFecha(Long idPlan, LocalDate fecha);

    List<reserva> findByEstado(String estado);
}
