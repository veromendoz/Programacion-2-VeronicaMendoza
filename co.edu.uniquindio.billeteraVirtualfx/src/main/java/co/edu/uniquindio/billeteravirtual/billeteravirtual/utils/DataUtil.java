package co.edu.uniquindio.billeteravirtual.billeteravirtual.utils;

import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.BilleteraVirtual;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.Cuenta;
import co.edu.uniquindio.billeteravirtual.billeteravirtual.model.builder.TipoCuenta;

public class DataUtil {
    public static BilleteraVirtual inicializarDatos() {
        BilleteraVirtual billeteraVirtual = new BilleteraVirtual();
        Cuenta cuenta1 = Cuenta.builder()
                .idCuenta("1")
                .nombreBanco("Bancolombia")
                .numeroCuenta("123")
                .tipoCuenta(TipoCuenta.AHORRO)
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .idCuenta("2")
                .nombreBanco("Bancolombia")
                .numeroCuenta("567")
                .tipoCuenta(TipoCuenta.CORRIENTE)
                .build();

        Cuenta cuenta3 = Cuenta.builder()
                .idCuenta("3")
                .nombreBanco("Bancolombia")
                .numeroCuenta("890")
                .tipoCuenta(TipoCuenta.AHORRO)
                .build();

        billeteraVirtual.getListaCuentas().add(cuenta1);
        billeteraVirtual.getListaCuentas().add(cuenta2);
        billeteraVirtual.getListaCuentas().add(cuenta3);

        return billeteraVirtual;
    }
}
