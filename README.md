# Exercício 1 de Semaforos - Sistemas Operacionais 1

<div align="center">
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

## Sobre o projeto
Este é o exercício 1, da lista de exercícios de Semaforos, da materia de Sistemas Operacionais 1 do curso de Análise e desenvolvimento de sistemas da FATEC Zona Leste.<br>

## Índice
=================
<!--ts-->
* [Título](#exercício-1-de-semaforos---sistemas-operacionais-1)
* [Sobre o Projeto](#sobre-o-projeto)
* [Índice](#índice)
* [Exercício 1](#exercício-1)
* [Status do projeto](#status-do-projeto)
* [Tecnologias](#tecnologias)
* [Agradecimentos](#agradecimentos)
* [Autor](#autor)
<!--te-->

## Exercício 1
1) Um servidor com multiprocessamento recebe requisições que envolve realizar cálculos
e fazer transações com bancos de dados. Por ter uma quantidade grande de núcleos de
processamentos e threads, além de um bom algoritmo de escalonamento de threads,
enquanto as threads fazem cálculos, estes podem ocorrer simultaneamente, mas
quando se faz a transação no banco de dados, esta deve ser apenas uma thread por
vez.<br>
Considere um conjunto de threads com IDs definidas na própria aplicação com
números iniciando em 1 e incrementando de um em um. As threads tem comportamento
como segue:

- a) Threads com ID dividido por 3 resultando em resto igual a um fazem as transações:
  - Cálculos de 0,2 a 1,0 segundos
  - Transação de BD por 1 segundo
  - Cálculos de 0,2 a 1,0 segundos
  - Transação de BD por 1 segundo
- b) Threads com ID dividido por 3 resultando em resto igual a dois fazem as transações:
  - Cálculos de 0,5 a 1,5 segundos
  - Transação de BD por 1,5 segundo
  - Cálculos de 0,5 a 1,5 segundos
  - Transação de BD por 1,5 segundo
  - Cálculos de 0,5 a 1,5 segundos
  - Transação de BD por 1,5 segundo
- c) Threads com ID dividido por 3 resultando em resto igual a zero fazem as transações:
  - Cálculos de 1 a 2 segundos
  - Transação de BD por 1,5 segundo
  - Cálculos de 1 a 2 segundos
  - Transação de BD por 1,5 segundo
  - Cálculos de 1 a 2 segundos
  - Transação de BD por 1,5 segundo
    
* Faça uma aplicação em Java que simule a situação de 21 Threads simultâneas, com
exibição em console de cada passo que a Thread está realizando.


## Status do projeto
  🚧 Em construção 🚧
    
* Na classe `ThreadSemaforoController`:
  
  * é criado o atributo static `id` que será incrementado toda vez que a classe é instânciada 
  * O metodo `calculando` simula a realização de calculos por threads imprimindo no console `Thread #{id} está calculando`
  * O metodo `transacaoBD` simula a transação de banco de dados por threads, com um semaforo para garantir que seja feita uma por vez, imprimindo no console `Thread #{id} está realizando uma transação no banco de dados`
    
* Na classe `Main`:
  
  * É criado um semaforo, com o número de permissões 1
  * Dentro de uma iteração `for` de 0 até 20 é criado uma instância da classe `ThreadSemaforoController` e é iniciada pelo metodo `start()`



## Tecnologias
- [Java](https://www.oracle.com/br/java/)
  - [Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)
  - [Semaphore](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html)

## Agradecimentos
Agradeço ao professor da disciplina de Sistemas Operacionais 1, [Leandro Colevati dos Santos](https://www.leandrocolevati.com.br/index.jsp), por todo o aprendizado passado.

## Autor

<div align="center">
<a href="https://www.linkedin.com/in/thiago-antenor/">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/99970279?v=4" width="100px;" alt="foto do autor"/>
 <br />
 <sub><b>Thiago Silva Antenor</b></sub></a> <a href="https://www.linkedin.com/in/thiago-antenor/" title="Linkedin"> 🧑🏾‍💻</a>


Feito por Thiago Silva Antenor 👨🏾‍💻 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/thiago-antenor/)](https://www.linkedin.com/in/thiago-antenor/) 
[![Gmail Badge](https://img.shields.io/badge/-thiagoantenor31@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:thiagoantenor31.com)](mailto:thiagoantenor31.com)
</div>
