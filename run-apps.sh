#/bin/bash

nohup java -jar godfather-application/target/godfather-application-0.0.1-SNAPSHOT.jar &
nohup java -jar godfather-consumer/target/godfather-consumer-0.0.1-SNAPSHOT.jar &
