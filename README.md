# jee7POC
Projeto demonstra a utilização da tecnologia EJB 3.2

web.xml: The web application's deployment descriptor, which is used to configure certain aspects of a web application when it is installed.


Issues into the process of development:
1)  Changing the package of a class containing an @Schedule method does not remove previously scheduled method.
    If you have a class deployed in a war with a method annotated with @Schedule, if you change the package of the class and redeploy, the server attempts to execute the scheduled method in the previous version of the class.
    https://issues.jboss.org/browse/AS7-5635
    


Habilitar o CDI no projeto é muito simples. Se você já está usando um servidor Java EE 6, basta criar um arquivo vazio chamado beans.xml na pasta META-INF do seu projeto (ou WEB-INF num projeto web). Esse é um simples arquivo de marcação e apenas sua presença já faz com que o servidor habilite o suporte a CDI e escaneie suas classes automaticamente.
    
https://docs.oracle.com/javaee/7/tutorial/