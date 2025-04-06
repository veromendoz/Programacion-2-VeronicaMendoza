package co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.mappers;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.mapping.dto.CuentaDto;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.Cuenta;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.service.IBilleteraVirtualMapping;

import java.util.List;

public class BilleteraVirtualMappingImpl implements IBilleteraVirtualMapping {
    public List<CuentaDto> getCuentasDto(List<Cuenta> listaCuentas) {
        return List.of();
    }
}
