package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

abstract class CafeDecorator implements ICoffee {
    protected ICoffee decoratedCafe;

    public CafeDecorator(ICoffee cafe) {
        this.decoratedCafe = cafe;
    }

    public String getDescripcion() {
        return decoratedCafe.getDescripcion();
    }

    public double getCosto() {
        return decoratedCafe.getCosto();
    }
}

