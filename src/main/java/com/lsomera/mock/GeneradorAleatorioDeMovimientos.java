package com.lsomera.mock;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
Clase que genera una lista de movimientos bancarios típicos de forma aleatoria.
Esta clase tendrá un único método público con dos parámetros, uno de tipo int con el número de movimientos deseado, y otro de tipo String en el ue se le indicará el tipp de movimiento
Los tipos de movimientos disponibles serán:
- Transferencia: "Transferencia de x moneda"
- Ingreso: "Ingreso de x moneda"
- Retirada: Retirada de x moneda"
- Pago con tarjeta: "Pago con tarjeta de x moneda"
- Nomina: "Ingreso nómina de x moneda"
- Pago recibo: "Pago de recibo de x moneda"
- Se generará una lista con el número de movimientos indicados por parámetro en el que cada movimiento será de uno de los anteriores tipos seleccionado de modo aleatorio y en el que la cantidad de dinero será un número double aleatorio entre 1.00 y 3000.00
 */
public class GeneradorAleatorioDeMovimientos {

    private static final String TRANSFERENCIA = "Transferencia de ";
    private static final String INGRESO = "Transferencia de ";
    private static final String RETIRADA = "Retirada de ";
    private static final String PAGO_CON_TARJETA = "Pago con tarjeta de ";
    private static final String NOMINA = "Ingreso nómina de ";
    private static final String PAGO_RECIBO = "Pago de recibo de ";

    public ArrayList<String> obtenerMovimientos(int numeroDeMovimientos, String moneda) {
        ArrayList<String> movimientos = new ArrayList<>();
        for (int i = 0; i < numeroDeMovimientos; i++) {
            int numeroDeMovimiento = obtenerIntAleatorio(1,6);
            String tipoDeMovimiento;
            switch (numeroDeMovimiento) {
                case 1:
                    tipoDeMovimiento = TRANSFERENCIA;
                case 2:
                    tipoDeMovimiento = INGRESO;
                case 3:
                    tipoDeMovimiento = RETIRADA;
                case 4:
                    tipoDeMovimiento = PAGO_CON_TARJETA;
                case 5:
                    tipoDeMovimiento = NOMINA;
                    break;
                default:
                    tipoDeMovimiento = PAGO_RECIBO;
            }
            double cantidadAleatorio = obtenerDoubleAleatorio(1.0, 3000.0);
            String movimiento = tipoDeMovimiento + String.format("%.2f", cantidadAleatorio) + " " + moneda; //Esto transforma nuestro double aleatorio en un String con dos cifras decimales
            movimientos.add(movimiento);
        }
        return movimientos;
    }

    private int obtenerIntAleatorio(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    private double obtenerDoubleAleatorio(double minimo, double maximo) {
        return ThreadLocalRandom.current().nextDouble(minimo, maximo + 1.0);
    }

}

