package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class WhiskyDecorator extends CafeDecorator {
    public WhiskyDecorator(ICoffee cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return decoratedCafe.getDescripcion() + ", Whisky";
    }

    @Override
    public double getCosto() {
        return decoratedCafe.getCosto() + 0.5;
    }
}
