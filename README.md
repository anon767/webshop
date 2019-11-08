# webshop
Microservice "webshop"

## Setup
Create a DockerHub account

## Install

```
mvn -Ddocker.user=USERNAME -Ddocker.pwd=PASSWORD clean install
docker-compose up -d
```

## Known Bugs

The MySQL- and Config-Service have to be up before all the other services. 
