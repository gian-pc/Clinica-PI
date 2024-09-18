package com.example.ClinicaOdontologicaSpringMVC.service.impl;

import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.odontologo.OdontologoEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.paciente.DomicilioEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.paciente.PacienteEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.turno.TurnoEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Service.impl.OdontologoService;
import com.example.ClinicaOdontologicaSpringMVC.Service.impl.PacienteService;
import com.example.ClinicaOdontologicaSpringMVC.Service.impl.TurnoService;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.BadRequestException;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Order(2)
    @Test
    void alIntentarEliminarUnTurnoQueNoExisteEnLaBDD_ArrojaUnResourceNotFoundException() {
        assertThrows(ResourceNotFoundException.class, ()-> turnoService.eliminarTurno(2));
    }

    @Order(1)
    @Test
    void intentamosRegistrarUnTurnoSinPacienteYSinOdontologoRegistrado_ArrojaUnBadRequest() {
        try {
            turnoService.registrarTurno(new TurnoEntradaDto(LocalDateTime.of(2023,8,12,8,8,0),1,1));
        }catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(BadRequestException.class, ()->turnoService.registrarTurno(new TurnoEntradaDto(LocalDateTime.of(2023,8,12,8,8,0),1,1)));
    }

    @Order(3)
    @Test
    void listarTurnoConPacienteYOdontologoValidos (){
        DomicilioEntradaDto domicilioEntradaDto = new DomicilioEntradaDto("Calle",1234,"Localidad","Provincia");
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Denis","Bilicki",30959925,LocalDate.of(2023,8,12),domicilioEntradaDto);
        pacienteService.registrarPaciente(pacienteEntradaDto);

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("MB-123","Guillermo","Jaimito");
        odontologoService.registrarOdontologo(odontologoEntradaDto);

        try {
            turnoService.registrarTurno(new TurnoEntradaDto(LocalDateTime.of(2023,8,12,8,8,0),1,1));
        }catch (Exception e){
            e.printStackTrace();
        }

        assertFalse(turnoService.listarTurnos().isEmpty());
    }
}