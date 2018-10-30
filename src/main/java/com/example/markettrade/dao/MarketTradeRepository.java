package com.example.markettrade.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.markettrade.entity.MarketTradeEntity;

@Transactional
public interface MarketTradeRepository extends JpaRepository<MarketTradeEntity, String> {

    @Query("SELECT  mt.fromCurrency, mt.toCurrency, mt.processedTime, sum(mt.amountSell) "
            + "as amountSell  FROM MarketTradeEntity mt "
            + "group by mt.fromCurrency, mt.toCurrency, mt.processedTime order by mt.fromCurrency")
    public List<MarketTradeEntity> getByCurrencyAndTotal();

}
