#/bin/bash

cd godfather-agent 
mvn clean install

cd ../godfather-application
mvn clean install

cd ../godfather-consumer
mvn clean install

cd ..
