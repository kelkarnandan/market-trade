DROP TABLE IF EXISTS market_trade;

CREATE TABLE market_trade (
    ID int NOT NULL AUTO_INCREMENT,
    user_id varchar(255) NOT NULL,
    processed_time DateTime,
    PRIMARY KEY (ID)
);