package com.example.markettrade.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.example.markettrade.model.MarketTradeModel;
import com.google.gson.Gson;

@Service
public class MarketTradeSenderService {

	@JmsListener(destination = "inbound.queue", concurrency= "10-5000")
	@SendTo("outbound.queue")
	public MarketTradeModel receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		MarketTradeModel trade = null;
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			trade = new Gson().fromJson(messageData, MarketTradeModel.class);
			trade.setProcessedTime(System.currentTimeMillis());
		}
		return trade ;
	}

}