package com.example.markettrade.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.markettrade.model.MarketTradeModel;
import com.example.markettrade.util.MarketTradeStringUtils;

@RestController
@RequestMapping("/marketTrade")
public class MarketTradeController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("/transfer")
	public String transfer(@RequestBody MarketTradeModel marketTradeModel) {
		List<MarketTradeModel> listOfMarketTradeModel = new ArrayList<>();
		int tradeCount = 10000;
		for (int i = 0 ; i < tradeCount; i++) {
			Random random = new Random();
			BigDecimal randomBuyAmount = BigDecimal.valueOf(random.nextInt(tradeCount));
			BigDecimal randomSellAmount = BigDecimal.valueOf(random.nextInt(tradeCount));
			marketTradeModel.setAmountBuy(randomBuyAmount);
			marketTradeModel.setAmountSell(randomSellAmount);
			marketTradeModel.setTransactionId(UUID.randomUUID().toString());
			jmsTemplate.convertAndSend("inbound.queue", marketTradeModel);
			listOfMarketTradeModel.add(marketTradeModel);
		}
		return "Message Sent : " + MarketTradeStringUtils.toString(listOfMarketTradeModel);
	}

}
