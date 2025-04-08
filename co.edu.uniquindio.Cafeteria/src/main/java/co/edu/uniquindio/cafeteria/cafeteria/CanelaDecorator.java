package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class CanelaDecorator extends CafeDecorator {
    public CanelaDecorator(ICoffee cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return decoratedCafe.getDescripcion() + ", Canela";
    }

    @Override
    public double getCosto() {
        return decoratedCafe.getCosto() + 0.5;
    }

}
