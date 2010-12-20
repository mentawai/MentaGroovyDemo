MentaGroovyDemo
==========================

Projeto de demonstração da integração do [Mentawai](http://www.mentaframework.org/) com o [Groovy](http://groovy.codehaus.org/)
A aplicação consiste em um controle de chamados/queixas, com um crud simples.


Principais recursos da Integração.
---------------------------------------------
- Actions desenvolvidas em Groovy, podem ser chamadas pelo Mentawai de forma trasparente.
- Inversão de Controle, injetando componentes escritos Groovy, como classes de Serviço e DAOs
- Atualização Automática do código groovy em tempo de execução (GroovyInterpreter.setReloadInterval(1000))


Principais recursos da Integração (pendentes)
---------------------------------------------
- Suporte ao AutoWiring (resolução das dependencias)
- Suporte ao Mapeamento do Hibernate em Classes Groovy.


> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
> consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
> Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.
> 
> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
> id sem consectetuer libero luctus adipiscing.