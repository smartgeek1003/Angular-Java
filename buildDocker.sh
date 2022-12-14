#!/bin/sh
#./mvnw clean install -Ddocker=true -Dnpm.test.script=test-chromium
./mvnw clean install -Ddocker=true
docker build -t angular2guy/angularandspring:latest --build-arg JAR_FILE=angularandspring-backend-0.0.1-SNAPSHOT.jar --no-cache .
docker run -p 8080:8080 --memory="512m" --cpus=1.0 --network="host" angular2guy/angularandspring:latest