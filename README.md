# Openshift-Enovy-Istio Demo

This project contains 4 Springboot applications :

* SAP 
* E-Api 
* BFF 
* Webapp

The Webapp is showing the customer and bill data from SAP.


# Run local

Run projects locally. Got to the root of the project where the pom.xml is and :

```
mvn clean install
mvn spring-boot:run -Dspring-boot.run.profiles=local
```