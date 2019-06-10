package sample;

public class Calculadora {

    private double valorA;
    private double valorB;

    public Calculadora(double valorA, double valorB) {
        this.valorA = valorA;
        this.valorB = valorB;
    }

    public Calculadora() {
    }

    public double getValorA() {
        return valorA;
    }

    public void setValorA(double valorA) {
        this.valorA = valorA;
    }

    public double getValorB() {
        return valorB;
    }

    public void setValorB(double valorB) {
        this.valorB = valorB;
    }

    public double Somar() {
        return valorA + valorB;
    }

    public double Subtrair() {
        return valorA - valorB;
    }

    public double Multiplicar() {
        return valorA * valorB;
    }

    public double Dividir() {
        return valorA / valorB;
    }

    public double Somar(double valorA, double valorB) {
        return valorA + valorB;
    }

    public double Subtrair(double valorA, double valorB) {
        return valorA - valorB;
    }

    public double Multiplicar(double valorA, double valorB) {
        return valorA * valorB;
    }

    public double Dividir(double valorA, double valorB) {
        return valorA / valorB;
    }

    @Override
    public String toString() {
        return "Calculadora";
    }
}