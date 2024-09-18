package com.example.ClinicaOdontologicaSpringMVC.Repository;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
