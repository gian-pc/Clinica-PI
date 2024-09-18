package com.example.ClinicaOdontologicaSpringMVC.Service;



import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.odontologo.OdontologoEntradaDto;
import com.example.ClinicaOdontologicaSpringMVC.Dto.salida.odontologo.OdontologoSalidaDto;
import com.example.ClinicaOdontologicaSpringMVC.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IOdontologoService {

    List<OdontologoSalidaDto> listarOdontologo();

    OdontologoSalidaDto registrarOdontologo (OdontologoEntradaDto odontologoEntradaDto);

    OdontologoSalidaDto buscarOdontologoPorid (int id);

    void eliminarOdontologo (int id) throws ResourceNotFoundException;

    OdontologoSalidaDto ModificarOdntologo (OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) throws ResourceNotFoundException;
}
