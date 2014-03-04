JavaEE example application using Groovy
=======================================

An application written in Groovy using JavaEE 7 aspects:

- CDI for dependecy injection and events;
- EJB 3.1 Lite for transactions;
- JPA 2 for ORM;
- JSF 2.2 for MVC and;
- Primefaces 4 for visual components.

To run this example use a WildFly instalation or

1. Launch WildFly from the command line:

	mvn clean wildfly:run

2. Access the deployed webapp at 

	http://localhost:8080/remindme
