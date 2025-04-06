package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class CafeDecorator implements ICoffee {
    protected ICoffee decoratedCoffee;

    public CafeDecorator(ICoffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescripcion() {
        return decoratedCoffee.getDescripcion();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
}
