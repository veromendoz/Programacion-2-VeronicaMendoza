package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class LecheDecorator extends CafeDecorator{

    public LecheDecorator(ICoffee cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return decoratedCafe.getDescripcion() + ", Leche";
    }

    @Override
    public double getCosto() {
        return decoratedCafe.getCosto() + 0.5;
    }

}
