/**
 * Calculadora simples usada para demonstrar teste de mutação.
 * Cada método contém lógica suficiente (condições, operadores aritméticos
 * e retornos booleanos) para gerar mutantes interessantes no StrykerJS.
 */
export class Calculadora {
  /** Soma dois números. */
  somar(primeiroValor: number, segundoValor: number): number {
    return primeiroValor + segundoValor;
  }

  /** Subtrai o segundo valor do primeiro. */
  subtrair(primeiroValor: number, segundoValor: number): number {
    return primeiroValor - segundoValor;
  }

  /** Multiplica dois números. */
  multiplicar(primeiroValor: number, segundoValor: number): number {
    return primeiroValor * segundoValor;
  }

  /** Divide o primeiro valor pelo segundo, recusando divisão por zero. */
  dividir(dividendo: number, divisor: number): number {
    if (divisor === 0) {
      throw new Error('Divisão por zero não é permitida');
    }
    return dividendo / divisor;
  }

  /** Retorna verdadeiro quando o número é par. */
  ehPar(numero: number): boolean {
    return numero % 2 === 0;
  }

  /** Retorna o maior entre dois números. */
  maximo(primeiroValor: number, segundoValor: number): number {
    if (primeiroValor >= segundoValor) {
      return primeiroValor;
    }
    return segundoValor;
  }
}
