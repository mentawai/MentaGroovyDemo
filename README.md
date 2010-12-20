MentaGroovyDemo
==========================

Projeto de demonstração e testes da integração do [Mentawai](http://www.mentaframework.org/) com o [Groovy](http://groovy.codehaus.org/), uma linguagem dinâmica baseada no java e que roda na JVM. <br/>


#### Principais recursos da Integração.
- Actions desenvolvidas em Groovy, que podem ser chamadas pelo Mentawai de forma transparente.
- Inversão de Controle, injetando componentes escritos Groovy, como classes de Serviço e DAOs (através do GroovyComponent)
- Atualização Automática do código groovy em tempo de execução (GroovyInterpreter.setReloadInterval(1000))
- Todos os demais recursos do mentawai, com exceção dos listados abaixo.

#### Principais recursos da Integração (pendentes)
- Suporte ao AutoWiring (resolução das dependencias)
- Suporte ao Mapeamento do Hibernate em Classes Groovy.
- ApplicationManager escrito em groovy.


Instalação
--------------------

Para rodar o projeto você deve ter o Eclipse e o Maven instalado na sua maquina. Depois basta efetuar o download do projeto, e da biblioteca: <b>mentawai-X.X.X-groovy.jar</b> (um fork do mentawai com suporte ao groovy)
E alterar a dependência do mentawai para a seguinte:

	<dependency>
		<groupId>org.mentaframework</groupId>
		<artifactId>mentawai</artifactId>
		<version>1.15.1-groovy</version>
		<scope>system</scope>
		<systemPath>${basedir}/src/main/webapp/WEB-INF/lib/mentawai-X.X.X-groovy.jar</systemPath>
	</dependency>

E finalmente executar no maven o goal <b>jetty:run</b>, para as coisas funcionarem.

### Considerações sobre o Projeto.
- A aplicação consiste em um controle de chamados/queixas, com um crud simples, usando uma arquitetura MVC básica com Service e Daos. <br/>
As classes em java estão em <b>src/main/java</b>, em groovy <b>src/main/groovy</b>, e as jsp's estão em <b>/src/main/webapp</b>

- O armazenamento dos dados pode ser feito em Memória (QueixaDaoList.groovy)[https://github.com/mentawai/MentaGroovyDemo/blob/master/src/main/groovy/dao/list/QueixaDaoList.groovy] ou no banco (QueixaDaoHbn.groovy)[https://github.com/mentawai/MentaGroovyDemo/blob/master/src/main/groovy/dao/hibernate/QueixaDaoHbn.groovy] , usando o hsqldb

- O mapeamento do hibernate teve que ser feitos em classes java, pois o hibernate não reconhece as classes nativa em groovy (durante a configuração), pois a engine de configuração do hibernate usa reflection em cima do ClassLoader do java não do Groovy, mas as operações (save/update/delete) em tempo de execução funcionam tranquilamente.



- Futuramente será integrado na versão oficial no mentawai, faltando apenas alguns ajustes.


Arquitetura da Aplicação
=========================
![Arquitetura](https://github.com/mentawai/MentaGroovyDemo/raw/master/artefatos/Arquitetura.jpg) 