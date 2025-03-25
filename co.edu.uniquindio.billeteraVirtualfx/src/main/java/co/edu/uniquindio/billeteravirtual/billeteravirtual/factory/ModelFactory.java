package co.edu.uniquindio.billeteravirtual.billeteravirtual.factory;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.BilleteraVirtual;

public class ModelFactory {

    private static ModelFactory instance;
    private BilleteraVirtual billeteraVirtual;

    public ModelFactory(){
        hotel = inicializarDatos();
    }

    public ModelFactory getInstance(){
        if (instance == null){
            instance = new ModelFactory();
        }

        return instance;
    }

    private void inicializarDatos() {

}
