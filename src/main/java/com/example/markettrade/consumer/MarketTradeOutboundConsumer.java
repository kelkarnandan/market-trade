package com.example.markettrade.consumer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.example.markettrade.entity.MarketTradeEntity;
import com.example.markettrade.model.MarketTradeModel;
import com.example.markettrade.service.MarketTradeService;
import com.google.gson.Gson;

@Service
public class MarketTradeOutboundConsumer {

    @Autowired
    private MarketTradeService service;

    @JmsListener(destination = "outbound.queue", concurrency = "10-5000")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        MarketTradeModel marketTradeModel = null;
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            marketTradeModel = new Gson().fromJson(messageData, MarketTradeModel.class);
            LocalDateTime ldt = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(marketTradeModel.getProcessedTime()),
                    ZoneId.systemDefault());
            Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            service.save(extractMarketTradeEntity(marketTradeModel, date));
        }
    }

    private MarketTradeEntity extractMarketTradeEntity(MarketTradeModel marketTradeModel,
            Date date) {
        return new MarketTradeEntity(marketTradeModel.getUserId(),
                marketTradeModel.getTransactionId(), marketTradeModel.getCurrencyFrom(),
                marketTradeModel.getAmountSell(), marketTradeModel.getCurrencyTo(),
                marketTradeModel.getAmountBuy(), date);
    }
}
