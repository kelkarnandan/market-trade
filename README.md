# market-trade
Features

    Consumes incoming trades and persists them in an [in-memory] database
    Provides a stream of CurrencyFrom/To updates to a frontend UI
    Provides random generation of currency trades ie 10 per each request send. 
    Active MQ to manage the inbound outbound queues. 
	
Requirements

    Java 8
    Maven
    ActiveMQ
    Angular JS - NVD3 (charts)

Prerequsite

    Install Active MQ and provide path in Arguments like "C:\CodeBase\apache\apache-activemq-5.11.1\bin\activemq.bat"

Installation
	
    Clone the application (or Download zip) 
    OR
    $ git clone https://github.com/kelkarnandan/market-trade.git market-trade
    $ cd market-trade

Building and Running the application

    Run Spring Boot project with above active mq installation path in arguments. 

Endpoints

    Web UI - http://localhost:8080/market-trade/index.html
    Trade API - POST localhost:8080/marketTrade/transfer
    Stats API - GET localhost:8080/marketTrade/getByCurrencyAndTotal
    InMemory Database : http://localhost:8080/h2-console/
    
Notes

For speed of development + time constraints, 

    This application was developed with a single service three tier architecture and no security features
    like Basic Authentication:: username/password
	
    With more time and investment, this could be broken down into a micro-services architecture 
    that would communicate through seperately deployed message brokers as well as RESTful 
    communication with the use of circuit breakers. The services may include some of the following:

    API Gateway for allowing public facing access to an API.
    Authentication service for ensuring the authorization of users
    The ForeignExchange service to maintain current prices and send out onto stream
    An in-memory cluster/Redis that each cluster would process incoming trades for a set of userId's
    Statistics service that would process UI requests for statistics.
    Active MQ can be replaced with Azure Queue service.

	Also, one current test exists to ensure the application context can be loaded and the application can serve requests.
	BDD tests could be incorporated in to allowed for comprehensible test scenarios.
