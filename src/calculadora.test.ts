import { describe, expect, it } from 'vitest';
import { Calculadora } from './calculadora.js';

describe('Calculadora', () => {
  const calculadora = new Calculadora();

  it('soma dois valores', () => {
    expect(calculadora.somar(3, 4)).toBe(7);
    expect(calculadora.somar(2, -3)).toBe(-1);
  });

  it('subtrai dois valores', () => {
    expect(calculadora.subtrair(4, 3)).toBe(1);
    expect(calculadora.subtrair(2, -3)).toBe(5);
  });

  it('multiplica dois valores', () => {
    expect(calculadora.multiplicar(3, 4)).toBe(12);
    expect(calculadora.multiplicar(0, 7)).toBe(0);
  });

  it('divide dois valores', () => {
    expect(calculadora.dividir(8, 4)).toBe(2);
    expect(calculadora.dividir(9, 3)).toBe(3);
  });

  it('recusa divisão por zero', () => {
    expect(() => calculadora.dividir(10, 0)).toThrowError(
      'Divisão por zero não é permitida',
    );
  });

  it('identifica números pares e ímpares', () => {
    expect(calculadora.ehPar(4)).toBe(true);
    expect(calculadora.ehPar(0)).toBe(true);
    expect(calculadora.ehPar(3)).toBe(false);
    expect(calculadora.ehPar(-7)).toBe(false);
  });

  it('retorna o maior valor', () => {
    expect(calculadora.maximo(5, 3)).toBe(5);
    expect(calculadora.maximo(3, 5)).toBe(5);
    expect(calculadora.maximo(5, 5)).toBe(5);
  });
});
