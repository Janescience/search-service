# Search Service

Microservice in Eureka Server (Spring Cloud)

## Prerequire

- Java 17++
- Maven
- Docker (Use for run with Docker)
- kubectl (Use for deploy kubernates)

## Run Local

Require Java 17++ and Maven installed on local

`mvn spring-boot:run`

## Run with Docker

If run with Docker not require Java & Maven

`docker build -t search-service .`

`docker run -d --name search-service -p 8086:8086 search-service`

## Path Active

- http://localhost:8086/search/individual?key= (GET)
- http://localhost:8086/search/enquiry/{cisNo} (GET)

## Build .jar

File .jar output to /target

`mvn clean package`

## Deploy Kubernetes

Require 
- Config `kubectl` connect to Kubernetes Engine Server 
- If use Kubernetes in local just install `minikube` on local and `minikube` need to run with Docker

`kubectl apply -f /k8s/deployment.yml`

`kubectl apply -f /k8s/service.yml`

