package co.edu.uniquindio.cafeteria.cafeteria.model;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public  class CafeSimple implements ICoffee {

    @Override
    public String getDescripcion() {
        return "Simple Coffe";
    }

    @Override
    public double getCosto() {
        return 2.0;
    }
}
