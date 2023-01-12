/*
Clase que emula las funcionalidades de un cajero automático.
La clase tendrá una variable de instancia llamada cuentaBancariaActual de tipo de CuentaBancaria
La clase tendrá un constructor que tendrá como parámetros un String que identifica al usuario y otro String que contiene una contraseña
Como se trata de una emulación, en lugar de conectar con la base de datos del banco para que nos devuleva la cuenta bancaria del usuario lo que debera hacer es crear un objeto de la clase CuentaBancaria con un nombre cualquiera y un saldo aleatorio
Esta clase tendrá los siguientes métodos:

- mostrarSaldo(): mostrará por pantalla el saldo de la cuenta bancaria
- ingresarDinero (): preguntará al usuario cuánto dinero quiere ingresar y lo ingresará en cuentaBancariaActual
- sacarDindero(): preguntará al usuario cuánto dinero quiere sacar y lo sacará de cuentaBancariaActual
- consultarUltimosMovimientos(): este método de momento no hará nada
- salir(): dará las gracias al usuario por usar sus servicios

* */

package com.lsomera.cajero;

import com.lsomera.banco.CuentaAhorro;
import com.lsomera.banco.CuentaBancaria;
import com.lsomera.mock.GeneradorAleatorioDeMovimientos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CajeroAutomatico {

    private CuentaBancaria cuentaBancariaActual;

    protected CajeroAutomatico(String identificador, String password) {
        double cantidadAleatoria = ThreadLocalRandom.current().nextDouble(0, 50000);
        cuentaBancariaActual = new CuentaAhorro("Nombre cualquiera", cantidadAleatoria);
    }

    protected void mostrarSaldo() {
        System.out.println("Su saldo es " + cuentaBancariaActual.obtenerSaldo());
    }

    protected void ingresarDinero() {
        System.out.println("Cuánto dinero quiere sacar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.ingresarDinero(cantidad);
    }

    protected void sacarDinero() {
        System.out.println("Cuánto dinero quiere sacar?");
        Scanner scanner = new Scanner(System.in);
        double cantidad = scanner.nextDouble();
        cuentaBancariaActual.sacarDinero(cantidad);
    }

    protected void consultarUltimosMovimientos() {
        GeneradorAleatorioDeMovimientos generadorAleatorioDeMovimientos = new GeneradorAleatorioDeMovimientos();
        System.out.println("Cuántos movimientos quiere consultar?");
        Scanner scanner= new Scanner(System.in);
        int numeroDeMovimientos = scanner.nextInt();
        ArrayList<String> movimientos = generadorAleatorioDeMovimientos.obtenerMovimientos(numeroDeMovimientos, "euros");
        mostrarMovimientos(movimientos);
    }

    private void mostrarMovimientos(ArrayList<String> movimientos) {
        for (String movimiento: movimientos) {
            System.out.println(movimiento);
        }
    }

    protected void salir() {
        System.out.println("Muchas gracias por utilizar nuetsros servicios");
    }

    protected void mostrarCondicionesLegales() {
        cuentaBancariaActual.informarSobreCondicionesLegales();
    }
}


