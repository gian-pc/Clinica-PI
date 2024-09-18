package com.example.ClinicaOdontologicaSpringMVC.Service;


import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.paciente.PacienteEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.salida.paciente.PacienteSalidaDto;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {

    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    PacienteSalidaDto buscarPacientePorId(int id);

    void eliminarPaciente(int id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteModificacionEntradaDto pacienteModificado) throws ResourceNotFoundException;

}
