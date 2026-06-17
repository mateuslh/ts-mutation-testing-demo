# java-mutation-testing-demo

Projeto de exemplo demonstrando **teste de mutação** em Java usando
[PITest (PIT)](https://pitest.org/) com JUnit 5 e Maven.

## O que é teste de mutação?

Cobertura de testes tradicional mede quais linhas são *executadas*, mas não se
os testes realmente *verificam* o comportamento. O teste de mutação vai além:
ele introduz pequenas alterações no código (os **mutantes**) — por exemplo,
trocar `+` por `-`, `>=` por `>`, ou `return true` por `return false` — e roda
a suíte de testes contra cada mutante.

- Se algum teste **falha**, o mutante foi **morto** (killed) — ótimo, os testes
  detectaram a regressão.
- Se todos os testes **passam** mesmo com o código alterado, o mutante
  **sobreviveu** (survived) — sinal de que falta uma asserção.

O **mutation score** é a porcentagem de mutantes mortos. Quanto maior, mais
robusta é a suíte de testes.

## Estrutura

```
src/main/java/com/mateuslh/calc/Calculadora.java   # código sob teste
src/test/java/com/mateuslh/calc/CalculadoraTest.java # testes JUnit 5
pom.xml                                             # build + plugin PITest
```

A `Calculadora` implementa operações aritméticas, verificação de paridade e
máximo entre dois valores — lógica suficiente para gerar mutantes variados
(aritméticos, condicionais e de retorno).

## Pré-requisitos

- JDK 21+
- Maven 3.9+

## Como rodar

### Testes unitários

```bash
mvn clean test
```

### Análise de mutação

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

O relatório HTML é gerado em `target/pit-reports/index.html`.

## Resultado atual

```
>> Generated 16 mutations Killed 15 (94%)
>> Line Coverage (for mutated classes only): 11/11 (100%)
>> Test strength 94%
```

O `pom.xml` define um `mutationThreshold` de **90%**, então o build falha caso o
score caia abaixo desse valor — garantindo que a qualidade dos testes não
regrida.

## Tecnologias

- Java 21
- JUnit 5 (Jupiter)
- PITest 1.18.2 + `pitest-junit5-plugin`
- Maven
