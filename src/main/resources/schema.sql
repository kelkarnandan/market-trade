create schema CURRENCYFAIR;

DROP TABLE IF EXISTS MARKET_TRADE;

CREATE TABLE MARKET_TRADE (
    ID int NOT NULL AUTO_INCREMENT,
    user_id varchar(255) NOT NULL,
    transaction_id varchar(255) NOT NULL,
    fromCurrency varchar(255) NOT NULL,
    toCurrency varchar(255) NOT NULL,
    processed_time DateTime,
    PRIMARY KEY (ID)
);