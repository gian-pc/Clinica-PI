package com.example.ClinicaOdontologicaSpringMVC.Service;



import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.turno.TurnoEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.salida.turno.TurnoSalidaDto;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.BadRequestException;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException;
    List<TurnoSalidaDto> listarTurnos();
    TurnoSalidaDto buscarTurnoPorId(int id);
    void eliminarTurno(int id) throws ResourceNotFoundException;
    TurnoSalidaDto modificarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto) throws ResourceNotFoundException;


}
