package com.example.markettrade.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.markettrade.dao.MarketTradeRepository;
import com.example.markettrade.entity.MarketTradeEntity;
import com.example.markettrade.model.MarketTradeLabelValue;

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

    public void save(MarketTradeEntity marketTradeEntity) {

        repository.save(marketTradeEntity);
    }

    public List<MarketTradeLabelValue> getByCurrencyAndTotal() {
        List<MarketTradeEntity> fcMap = repository.getByCurrencyAndTotal();
        List<MarketTradeLabelValue> mtLableValueList = new ArrayList<>();
        for (Object o : fcMap) {
            Object[] objectArray = (Object[]) o;
            mtLableValueList.add(new MarketTradeLabelValue((String) objectArray[0],
                    (String) objectArray[1], (Date) objectArray[2], (BigDecimal) objectArray[3]));
        }
        return mtLableValueList;
    }

}
