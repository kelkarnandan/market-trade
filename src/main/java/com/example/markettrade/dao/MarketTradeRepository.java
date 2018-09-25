package com.example.markettrade.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.markettrade.entity.MarketTrade;

@Transactional
public interface MarketTradeRepository extends JpaRepository<MarketTrade, String> {


}
