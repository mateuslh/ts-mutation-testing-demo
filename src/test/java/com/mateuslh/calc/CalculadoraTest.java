package com.mateuslh.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculadora")
class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("soma dois valores")
    void deveSomar() {
        assertEquals(7, calculadora.somar(3, 4));
        assertEquals(-1, calculadora.somar(2, -3));
    }

    @Test
    @DisplayName("subtrai dois valores")
    void deveSubtrair() {
        assertEquals(1, calculadora.subtrair(4, 3));
        assertEquals(5, calculadora.subtrair(2, -3));
    }

    @Test
    @DisplayName("multiplica dois valores")
    void deveMultiplicar() {
        assertEquals(12, calculadora.multiplicar(3, 4));
        assertEquals(0, calculadora.multiplicar(0, 7));
    }

    @Test
    @DisplayName("divide dois valores")
    void deveDividir() {
        assertEquals(2, calculadora.dividir(8, 4));
        assertEquals(3, calculadora.dividir(9, 3));
    }

    @Test
    @DisplayName("recusa divisão por zero")
    void deveRecusarDivisaoPorZero() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(10, 0));
        assertEquals("Divisão por zero não é permitida", erro.getMessage());
    }

    @Test
    @DisplayName("identifica números pares e ímpares")
    void deveIdentificarPar() {
        assertTrue(calculadora.ehPar(4));
        assertTrue(calculadora.ehPar(0));
        assertFalse(calculadora.ehPar(3));
        assertFalse(calculadora.ehPar(-7));
    }

    @Test
    @DisplayName("retorna o maior valor")
    void deveRetornarMaximo() {
        assertEquals(5, calculadora.maximo(5, 3));
        assertEquals(5, calculadora.maximo(3, 5));
        assertEquals(5, calculadora.maximo(5, 5));
    }
}
