package com.example.markettrade.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.markettrade.dao.MarketTradeRepository;
import com.example.markettrade.entity.MarketTradeEntity;

/**
 *
 * @author nandan_kelkar
 */
@Service
public class MarketTradeService {

    @Autowired
    private MarketTradeRepository repository;

    public List<MarketTradeEntity> allMarketTrade() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(MarketTradeEntity::getId)
                        .thenComparing(MarketTradeEntity::getProcessedTime).reversed())
                .collect(Collectors.toList());
    }

    public Map<String, Long> fromCurrencyTrade() {

        Map<String, Long> fcMap = repository.findAll().stream()
                .collect(Collectors.groupingBy(MarketTradeEntity::getFromCurrency,
                        Collectors.summingLong(mt -> mt.getAmountSell().longValue())));

        return fcMap;

    }

    public void save(MarketTradeEntity marketTradeEntity) {

        repository.save(marketTradeEntity);
    }

}
