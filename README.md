MentaGroovyDemo
==========================

Projeto de demonstração e testes da integração do [Mentawai](http://www.mentaframework.org/) com o [Groovy](http://groovy.codehaus.org/)
A aplicação consiste em um controle de chamados/queixas, com um crud simples.


#### Principais recursos da Integração.
- Actions desenvolvidas em Groovy, podem ser chamadas pelo Mentawai de forma trasparente.
- Inversão de Controle, injetando componentes escritos Groovy, como classes de Serviço e DAOs
- Atualização Automática do código groovy em tempo de execução (GroovyInterpreter.setReloadInterval(1000))
- Todos os demais recursos do mentawai, com exceção dos listados abaixo.

#### Principais recursos da Integração (pendentes)
- Suporte ao AutoWiring (resolução das dependencias)
- Suporte ao Mapeamento do Hibernate em Classes Groovy.


### Instalação
Para rodar o projeto você deve ter o Eclipse e o Maven instalado na sua maquina. Depois basta efetuar o download do projeto, e da biblioteca: [mentawai-X.X.X-groovy.jar] , um fork do mentawai com suporte ao groovy.


### Considerações sobre o Projeto.
- O mapeamento do hibernate teve que ser feitos em classes java, pois o hibernate não reconhece as classes nativa
        em groovy (durante a configuração), pois a engine de configuração do hibernate usa reflection em cima do ClassLoader do java não do Groovy, mas as operações (save/update/delete) em tempo de execução funcionam tranquilamente.


Arquitetura da Aplicação
=========================
![Arquitetura](https://github.com/mentawai/MentaGroovyDemo/raw/master/artefatos/Arquitetura.jpg) 