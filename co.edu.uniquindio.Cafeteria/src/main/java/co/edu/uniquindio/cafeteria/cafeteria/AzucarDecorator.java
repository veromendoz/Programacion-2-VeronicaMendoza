package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class AzucarDecorator extends CafeDecorator{

    public AzucarDecorator(ICoffee coffee) {
        super(coffee);
    }
}
