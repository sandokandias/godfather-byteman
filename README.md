# Godfather Byteman Agent

Customization agent for JVM applications

## Modules
 - godfather-agent: Manages the collecting and sending events by instrumentation rules
 - godfaher-consumer: Application that consumes, prepare and persist the events collected by godfather-agent
 - godfather-application: Demo application for testing purposes


## Getting Started

These instructions will get you running on your local machine for development and testing purposes. 


### Prerequisites

JDK 8+, maven 3.x+, curl, unzip, docker and docker-compose


### Getting Byteman

Execute the script
```
./get-byteman.sh
```

Open the file "configure-byteman.sh" and set JAVA_HOME and BYTEMAN_HOME.

Execute the script
```
./configure-byteman.sh
```


### Building modules

Execute the script
```
./mvn-build.sh
```


## Running

Starting the containers
```
docker-compose up
```

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
```
./run-apps.sh
```

### Send some requests to the application
```
curl -v -X POST http://localhost:8080/ \
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
```
ps aux | grep java
```

Execute the script with PID value
```
./install-agent.sh {PID}
```

Send more requests like previous step. Go to the metabase and check the "collector_events" table
