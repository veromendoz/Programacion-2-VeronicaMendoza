package co.edu.uniquindio.billeteravirtual.billeteravirtual.factory;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.mappers.BilleteraVirtualMappingImpl;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.service.IBilleteraVirtualMapping;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.DataUtil;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private BilleteraVirtual billeteraVirtual;
    private IBilleteraVirtualMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        billeteraVirtual = new BilleteraVirtual();
        mapper = new BilleteraVirtualMappingImpl();
        billeteraVirtual = DataUtil.inicializarDatos();
    }
}