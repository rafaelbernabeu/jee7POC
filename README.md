# jee7POC
Projeto demonstra a utilização da tecnologia EJB 3.2

web.xml: The web application's deployment descriptor, which is used to configure certain aspects of a web application when it is installed.


Issues into the process of development:
1)  Changing the package of a class containing an @Schedule method does not remove previously scheduled method.
    If you have a class deployed in a war with a method annotated with @Schedule, if you change the package of the class and redeploy, the server attempts to execute the scheduled method in the previous version of the class.
    https://issues.jboss.org/browse/AS7-5635
    
    
https://docs.oracle.com/javaee/7/tutorial/