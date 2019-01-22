# Godfather Byteman Agent

Customization agent for JVM applications

## Modules
 - godfather-agent: Manages the process of collecting and sending by instrumentation rules
 - godfaher-consumer: Application that consumes, prepare and persist the events collected by godfather-agent
 - godfather-application: Demo application for instrumentation purposes


## Getting Started

These instructions will get you running on your local machine for development and testing purposes. 


### Prerequisites

JDK 8+, maven 3.x+, curl, unzip, docker and docker-compose


### Getting Byteman

Execute the script
```bash
$ ./get-byteman.sh
```

Set and export the JAVA_HOME and BYTEMAN_HOME.
```bash
$ export JAVA_HOME={YOUR JAVA HOME PATH}
$ export BYTEMAN_HOME={YOUR BYTEMAN PATH}
$ export PATH=${PATH}:${BYTEMAN_HOME}/bin
```


### Building modules

Execute the script
```bash
$ ./mvn-build.sh
```


## Running

Starting the containers
```bash
$ docker-compose up -d
```

You can check the status of containers with
```bash
$ docker-compose ps
```
Good Output:

| Name                         | Command                       | State | Ports                                             |
| -----------------------------| ------------------------------| ------| --------------------------------------------------|
| godfatherbyteman_kafka_1     | start-kafka.sh                | Up    | 0.0.0.0:9092->9092/tcp                            |
| godfatherbyteman_metabase_1  | /app/run_metabase.sh          | Up    | 0.0.0.0:3000->3000/tcp                            |
| godfatherbyteman_mongodb_1   | /app-entrypoint.sh /run.sh    | Up    | 0.0.0.0:27017->27017/tcp                          |
| godfatherbyteman_zookeeper_1 | /bin/sh -c /usr/sbin/sshd  ...| Up    | 0.0.0.0:2181->2181/tcp, 22/tcp, 2888/tcp,3888/tcp |


### Metabase setup
Access http://localhost:3000 and set the user data. 
For the database choose MongoDB and set the props bellow:
 - Name: collector-db
 - Host: mongodb
 - Port: 27017
 - Database name: agent_collector_db
 - Username: agent
 - Password: pw123
 

### Starting the applications
```bash
$ ./run-apps.sh
```

### Send some requests to the application
```bash
$ curl -v -X POST http://localhost:8080/ \
-H "Content-Type: application/json" \
-d '{
  "intent": "sale",
  "payer": {
    "payment_method": "paypal"
  },
  "transactions": [
    {
      "amount": {
        "total": "30.11",
        "currency": "USD",
        "details": {
          "subtotal": "30.00",
          "tax": "0.07",
          "shipping": "0.03",
          "handling_fee": "1.00",
          "shipping_discount": "-1.00",
          "insurance": "0.01"
        }
      },
      "description": "The payment transaction description.",
      "custom": "EBAY_EMS_90048630024435",
      "invoice_number": "48787589673",
      "payment_options": {
        "allowed_payment_method": "INSTANT_FUNDING_SOURCE"
      },
      "soft_descriptor": "ECHI5786786",
      "item_list": {
        "items": [
          {
            "name": "hat",
            "description": "Brown hat.",
            "quantity": "5",
            "price": "3",
            "tax": "0.01",
            "sku": "1",
            "currency": "USD"
          },
          {
            "name": "handbag",
            "description": "Black handbag.",
            "quantity": "1",
            "price": "15",
            "tax": "0.02",
            "sku": "product34",
            "currency": "USD"
          }
        ],
        "shipping_address": {
          "recipient_name": "Brian Robinson",
          "line1": "4th Floor",
          "line2": "Unit #34",
          "city": "San Jose",
          "country_code": "US",
          "postal_code": "95131",
          "phone": "011862212345678",
          "state": "CA"
        }
      }
    }
  ]
}'
```

While the application is not be instrumented the events are not be collected and dispatched. 
You can check it on metabase.


### Instrumenting the target application
The application don`t need to be stopped or restarted for the instrumentation. 
You only need to get the PID of the process and then execute the instrumentation script.

Get the PID of the godfather-application
```bash
$ ps aux | grep godfather-application
```

Execute the script with PID value
```bash
$ ./install-agent.sh {PID}
```

Send more requests like previous step. Go to the metabase and check the "collector_events" table.
If the table do not appear on Metabase, you need to sync database on Admin page.

The instrumentation rules in the example intercepts inputs json data.

You can create your own instrumentation rules and support via Helpers.

### Logs
```bash
$ tail -f nohup.out
```
