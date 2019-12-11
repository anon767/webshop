# webshop
Microservice "webshop"

## Setup
Create a DockerHub account

## Install

```
mvn -Ddocker.user=USERNAME -Ddocker.pwd=PASSWORD clean install
docker-compose up --build -d
```

## Known Issues

- mvn build throws an error for web-ui. 
That however can be ignored because it will be built with correct dependencies via docker