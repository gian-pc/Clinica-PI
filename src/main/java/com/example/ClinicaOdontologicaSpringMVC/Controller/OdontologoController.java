package com.example.ClinicaOdontologicaSpringMVC.Controller;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Odontologo;
import com.example.ClinicaOdontologicaSpringMVC.Exception.ResourceNotFE;
import com.example.ClinicaOdontologicaSpringMVC.Service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }


    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Odontologo>> buscarPorId(@PathVariable Long id) throws ResourceNotFE {
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado);
        }else{
            throw new ResourceNotFE("Odontologo no encontrado");
        }
        //return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFE {
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarPorId(id);
        if(odontologoBuscado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Odontologo eliminado");
        }else{
            throw new ResourceNotFE("Odontologo no encontrado");
        }
    }
}
