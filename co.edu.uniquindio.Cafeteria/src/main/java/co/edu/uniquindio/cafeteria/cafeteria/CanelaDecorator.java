package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class CanelaDecorator extends CafeDecorator {
    public CanelaDecorator(ICoffee coffee) {
        super(coffee);
    }
}
