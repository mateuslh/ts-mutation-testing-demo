package com.mateuslh.calc;

/**
 * Calculadora simples usada para demonstrar teste de mutação.
 * Cada método contém lógica suficiente (condições, operadores aritméticos
 * e retornos booleanos) para gerar mutantes interessantes no PITest.
 */
public class Calculadora {

    /** Soma dois inteiros. */
    public int somar(int primeiroValor, int segundoValor) {
        return primeiroValor + segundoValor;
    }

    /** Subtrai o segundo valor do primeiro. */
    public int subtrair(int primeiroValor, int segundoValor) {
        return primeiroValor - segundoValor;
    }

    /** Multiplica dois inteiros. */
    public int multiplicar(int primeiroValor, int segundoValor) {
        return primeiroValor * segundoValor;
    }

    /** Divide o primeiro valor pelo segundo, recusando divisão por zero. */
    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida");
        }
        return dividendo / divisor;
    }

    /** Retorna verdadeiro quando o número é par. */
    public boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    /** Retorna o maior entre dois inteiros. */
    public int maximo(int primeiroValor, int segundoValor) {
        if (primeiroValor >= segundoValor) {
            return primeiroValor;
        }
        return segundoValor;
    }
}
