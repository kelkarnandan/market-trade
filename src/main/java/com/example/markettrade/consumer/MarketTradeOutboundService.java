package com.example.markettrade.consumer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.markettrade.model.MarketTradeModel;
import com.google.gson.Gson;

@Component
public class MarketTradeOutboundService {
	
//	@Autowired
//	private MarketTradeRepository repository;

	@JmsListener(destination = "outbound.queue", concurrency = "10-5000")
	public void receiveMessage(final Message jsonMessage) throws JMSException {
		String messageData = null;
		MarketTradeModel marketTradeModel = null;
		if (jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessage;
			messageData = textMessage.getText();
			marketTradeModel = new Gson().fromJson(messageData, MarketTradeModel.class);
			LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(marketTradeModel.getProcessedTime()), ZoneId.systemDefault());
			Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
//			MarketTrade saved = repository.save(new MarketTrade(marketTradeModel.getUserId(), date));
			System.out.println(String.format("Transaction ID : %s processed at : %s ", marketTradeModel.getTransactionId(), date.toString()));

		}
	}
}
