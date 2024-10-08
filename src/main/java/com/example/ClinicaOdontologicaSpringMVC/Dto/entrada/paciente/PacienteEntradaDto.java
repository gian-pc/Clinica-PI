package com.example.ClinicaOdontologicaSpringMVC.Dto.entrada.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteEntradaDto {
    @Size(max = 50, message = "El nombre debe tener un máximo de 50 caracteres")
    @NotNull(message = "El nombre del paciente no debe ser nulo")
    @NotBlank(message = "El nombre del paciente no debe estar vacío")
    private String nombre;
    @Size(max = 50, message = "El apellido debe terner un máximo de 50 caraacteres")
    @NotNull(message = "El apellido del paciente no debe ser nulo")
    @NotBlank(message = "El apellido del paciente no debe estar vacío")
    private String apellido;

    @Digits(integer = 10, fraction = 0, message = "El DNI debe ser numérico")
    @Min(value = 10000, message = "El DNI debe tener al menos 5 dígitos")
    @Max(value = 999999999, message = "El DNI no debe tener más de 9 dígitos")
    private int dni;

    @FutureOrPresent(message = "La fecha no puede ser anterior a la fecha actual")
    @NotNull(message = "debe especificar la fecha de ingreso del paciente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private DomicilioEntradaDto domicilio;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioEntradaDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioEntradaDto domicilio) {
        this.domicilio = domicilio;
    }

}
