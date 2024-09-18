package com.example.ClinicaOdontologicaSpringMVC.Repository;


import com.example.ClinicaOdontologicaSpringMVC.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}