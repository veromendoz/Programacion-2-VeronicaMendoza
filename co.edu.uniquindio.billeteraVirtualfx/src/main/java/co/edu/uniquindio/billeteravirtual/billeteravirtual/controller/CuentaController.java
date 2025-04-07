package co.edu.uniquindio.billeteravirtual.billeteravirtual.controller;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.factory.ModelFactory;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;

import java.util.List;

public class CuentaController {
    ModelFactory modelFactory;
    public CuentaController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<CuentaDto> obtenerCuenta() {
        return modelFactory.obtenerCuenta();
    }
}