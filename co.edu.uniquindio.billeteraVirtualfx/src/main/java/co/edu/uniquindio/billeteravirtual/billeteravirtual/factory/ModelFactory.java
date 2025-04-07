package co.edu.uniquindio.billeteravirtual.billeteravirtual.factory;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.mappers.BilleteraVirtualMappingImpl;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.service.IBilleteraVirtualMapping;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.service.IModelFactoryService;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.utils.DataUtil;

import java.util.List;

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

    @Override
    public List<CuentaDto> obtenerCuenta() {
        return mapper.getCuentasDto(billeteraVirtual.getListaCuentas());
    }

    @Override
    public boolean agregarCuenta(CuentaDto cuentaDto) {
        return billeteraVirtual.crearCuenta(mapper.cuentaDtoToCuenta(cuentaDto));
    }
    @Override
    public boolean actualizarCuenta(CuentaDto cuentaDto) {
        return billeteraVirtual.actualizarCuenta(mapper.cuentaDtoToCuenta(cuentaDto));
    }
    @Override
    public boolean eliminarCuenta(String idCuenta) {
        return billeteraVirtual.eliminarCuenta(idCuenta);
    }


}