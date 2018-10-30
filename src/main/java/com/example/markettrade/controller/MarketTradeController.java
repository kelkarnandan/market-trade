package com.example.markettrade.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.markettrade.entity.MarketTradeEntity;
import com.example.markettrade.model.MarketTradeLabelValue;
import com.example.markettrade.model.MarketTradeModel;
import com.example.markettrade.service.MarketTradeService;
import com.example.markettrade.util.MarketTradeStringUtils;

@RestController
@RequestMapping("/marketTrade")
public class MarketTradeController {

    private static List<String> currencyList;
    static {
        currencyList = Arrays.asList("GBP", "EUR", "DOLLAR", "INR", "AUD", "JPY", "CHF", "BHD",
                "CAD");
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MarketTradeService service;

    @PostMapping("/transfer")
    public String transfer(@Valid @RequestBody MarketTradeModel marketTradeModel) {
        List<MarketTradeModel> listOfMarketTradeModel = new ArrayList<>();
        int tradeCount = 10;
        for (int i = 0; i < tradeCount; i++) {
            Random random = new Random();
            BigDecimal randomSellAmount = BigDecimal
                    .valueOf(random.nextInt(tradeCount) + tradeCount);
            BigDecimal randomBuyAmount = randomSellAmount.multiply(marketTradeModel.getRate());
            marketTradeModel.setAmountBuy(randomBuyAmount);
            marketTradeModel.setAmountSell(randomSellAmount);
            marketTradeModel.setTransactionId(UUID.randomUUID().toString());
            int randomIndex = random.nextInt(currencyList.size());
            int nextRandomIndex = 0;
            do {
                nextRandomIndex = random.nextInt(currencyList.size());
            } while (randomIndex == nextRandomIndex);
            String currencyFrom = currencyList.get(randomIndex);
            String currencyTo = currencyList.get(nextRandomIndex);
            marketTradeModel.setCurrencyFrom(currencyFrom);
            marketTradeModel.setCurrencyTo(currencyTo);
            jmsTemplate.convertAndSend("inbound.queue", marketTradeModel);
            listOfMarketTradeModel.add(marketTradeModel);
        }
        return "Message Sent : " + MarketTradeStringUtils.toString(listOfMarketTradeModel);
    }

    @GetMapping("/allMarketTrade")
    public List<MarketTradeEntity> allMarketTrade() {
        return service.allMarketTrade();
    }

    @GetMapping("/getByCurrencyAndTotal")
    public List<MarketTradeLabelValue> getByCurrencyAndTotal() {
        return service.getByCurrencyAndTotal();
    }
}
