package com.lsomera.cajero;

/*Programa que emula la interfaz de un cajero automático. El programa presentará las siguientes opciones al usuario.

Elija una de las siguientes opciones:
- Escriba 1 para consultar su saldo
- Escriba 2 para ingresar dinero
- Escriba 3 para sacar dinero
- Escriba 4 para consultar sus últimos movimientos
- Escriba 5 para consultar las condiciones legales

Una vez escrita la opción, pulse la tecla Enter

Una vez que el usuario ha elegido la opción, el programa mostrará por pantalla el número correspondiente a la opción elegida

*/

import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {

        System.out.println("Por favor introduzca su número de identificación");
        Scanner scanner = new Scanner(System.in);
        String identificador = scanner.nextLine();
        System.out.println("Por favor introduzca su contraseña");
        String password = scanner.nextLine();
        CajeroAutomatico cajero = new CajeroAutomatico(identificador, password);

        int opcionSeleccionada;
        do {
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("Escriba 1 para consultar su saldo");
            System.out.println("Escriba 2 para ingresar dinero");
            System.out.println("Escriba 3 para sacar dinero");
            System.out.println("Escriba 4 para consultar sus últimos movimientos");
            System.out.println("Escriba 5 para consultar las condiciones legales");
            System.out.println("Para salir escriba cualquier otro número");

            opcionSeleccionada = scanner.nextInt();

            switch (opcionSeleccionada) {
                case 1:
                    cajero.mostrarSaldo();
                    break;
                case 2:
                    cajero.ingresarDinero();
                    break;
                case 3:
                    cajero.sacarDinero();
                    break;
                case 4:
                    cajero.consultarUltimosMovimientos();
                    break;
                case 5:
                    cajero.mostrarCondicionesLegales();
                    break;
                default:
                    cajero.salir();
            }
        } while (opcionSeleccionada == 1
                || opcionSeleccionada == 2
                || opcionSeleccionada == 3
                || opcionSeleccionada == 4
                || opcionSeleccionada == 5);

    }
}


