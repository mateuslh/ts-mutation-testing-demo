# ts-mutation-testing-demo

Projeto de exemplo demonstrando **teste de mutação** em TypeScript usando
[StrykerJS](https://stryker-mutator.io/) com [Vitest](https://vitest.dev/).

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
src/calculadora.ts        # código sob teste
src/calculadora.test.ts   # testes Vitest
stryker.config.json       # configuração do StrykerJS
vitest.config.ts          # configuração do Vitest
```

A `Calculadora` implementa operações aritméticas, verificação de paridade e
máximo entre dois valores — lógica suficiente para gerar mutantes variados
(aritméticos, condicionais e de retorno).

## Pré-requisitos

- Node.js 20+

## Como rodar

Instale as dependências:

```bash
npm install
```

### Testes unitários

```bash
npm test
```

### Análise de mutação

```bash
npm run mutation
```

O relatório HTML é gerado em `reports/mutation/mutation.html`.

## Resultado atual

```
----------------|------------------|----------|-----------|------------|
File            | % Mutation score | # killed | # survived | # no cov  |
----------------|------------------|----------|-----------|------------|
All files       |      95.83       |    23    |     1      |     0     |
----------------|------------------|----------|-----------|------------|
```

O `stryker.config.json` define um `break` threshold de **90%**, então o comando
falha caso o score caia abaixo desse valor — garantindo que a qualidade dos
testes não regrida.

> ℹ️ O único mutante sobrevivente (`>=` → `>` no método `maximo`) é um **mutante
> equivalente**: quando os dois valores são iguais, o resultado numérico é o
> mesmo independentemente do operador, então nenhum teste consegue distingui-lo.
> É um exemplo clássico do limite teórico do teste de mutação.

## Tecnologias

- TypeScript 5
- Vitest
- StrykerJS (`@stryker-mutator/core` + `@stryker-mutator/vitest-runner`)
