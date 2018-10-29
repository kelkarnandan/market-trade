package com.example.markettrade.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.markettrade.util.MarketTradeStringUtils;

@Entity
@Table(name = "market_trade", schema = "CURRENCYFAIR")
public class MarketTradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "fromCurrency")
    private String fromCurrency;
    @Column(name = "amountSell")
    private BigDecimal amountSell;
    @Column(name = "toCurrency")
    private String toCurrency;
    @Column(name = "amountBuy")
    private BigDecimal amountBuy;
    @Column(name = "processed_time")
    private Date processedTime;

    /**
     * @param userId
     * @param transactionId
     * @param fromCurrency
     * @param amountSell
     * @param toCurrency
     * @param amountBuy
     * @param processedTime
     */
    public MarketTradeEntity(String userId, String transactionId, String fromCurrency,
            BigDecimal amountSell, String toCurrency, BigDecimal amountBuy, Date processedTime) {
        super();
        this.userId = userId;
        this.transactionId = transactionId;
        this.fromCurrency = fromCurrency;
        this.amountSell = amountSell;
        this.toCurrency = toCurrency;
        this.amountBuy = amountBuy;
        this.processedTime = processedTime;
    }

    public MarketTradeEntity() {
        super();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId The transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return The fromCurrency
     */
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * @param fromCurrency The fromCurrency to set
     */
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    /**
     * @return The amountSell
     */
    public BigDecimal getAmountSell() {
        return amountSell;
    }

    /**
     * @param amountSell The amountSell to set
     */
    public void setAmountSell(BigDecimal amountSell) {
        this.amountSell = amountSell;
    }

    /**
     * @return The toCurrency
     */
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * @param toCurrency The toCurrency to set
     */
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    /**
     * @return The amountBuy
     */
    public BigDecimal getAmountBuy() {
        return amountBuy;
    }

    /**
     * @param amountBuy The amountBuy to set
     */
    public void setAmountBuy(BigDecimal amountBuy) {
        this.amountBuy = amountBuy;
    }

    /**
     * @return The processedTime
     */
    public Date getProcessedTime() {
        return processedTime;
    }

    /**
     * @param processedTime The processedTime to set
     */
    public void setProcessedTime(Date processedTime) {
        this.processedTime = processedTime;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MarketTradeStringUtils.toString(this);
    }
}
