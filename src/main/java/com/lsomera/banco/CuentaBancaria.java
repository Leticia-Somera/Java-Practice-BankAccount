package com.lsomera.banco;

public abstract class CuentaBancaria {
    private String titular;
    private TipoDeCuenta tipoDeCuenta;
    protected double saldo;

    public CuentaBancaria(String titular, TipoDeCuenta tipo, double saldo) {
        this.titular = titular;
        this.tipoDeCuenta = tipo;
        this.saldo = saldo;
    }

    public CuentaBancaria(String titular, double saldo) {
        this(titular, TipoDeCuenta.AHORRO, saldo);
    }

    public CuentaBancaria() {
        this("", TipoDeCuenta.AHORRO, 0);
    }

    public void sacarDinero(double cantidad) {
        if (cantidad < 0) {
            return;
        }
        saldo -= cantidad;
    }

    public void ingresarDinero(double cantidad) {
        if (cantidad < 0) {
            return;
        }
        saldo += cantidad;
    }

    protected void cambiarTipoDeCuenta(TipoDeCuenta nuevoTipo) {
        tipoDeCuenta = nuevoTipo;
    }

    public double obtenerSaldo() {
        return saldo;
    }

    public abstract void informarSobreCondicionesLegales();
}
