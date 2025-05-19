package co.edu.uniquindio.cafeteria.cafeteria.model;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public  class CafeSimple implements ICoffee {

    @Override
    public String getDescripcion() {
        return "Cafe Simple";
    }

    @Override
    public double getCosto() {
        return 2.0;
    }
}
