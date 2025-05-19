package co.edu.uniquindio.cafeteria.cafeteria;

import co.edu.uniquindio.cafeteria.cafeteria.Services.ICoffee;

public class AzucarDecorator extends CafeDecorator{

        public AzucarDecorator(ICoffee cafe) {
            super(cafe);
        }

        @Override
        public String getDescripcion() {
            return decoratedCafe.getDescripcion() + ", Azucar";
        }

        @Override
        public double getCosto() {
            return decoratedCafe.getCosto() + 0.3;
        }
}
