package com.example.markettrade.model;

import java.math.BigDecimal;
import java.util.Date;

public class MarketTradeLabelValue {

    private String currencyFrom;
    private String currencyTo;
    private Date processedTime;
    private BigDecimal total;

    /**
     * 
     */
    public MarketTradeLabelValue() {
        super();
    }

    /**
     * @param currencyFrom
     * @param currencyTo
     * @param processedTime
     * @param total
     */
    public MarketTradeLabelValue(String currencyFrom, String currencyTo, Date processedTime,
            BigDecimal total) {
        super();
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.processedTime = processedTime;
        this.total = total;
    }

    /**
     * @return The currencyFrom
     */
    public String getCurrencyFrom() {
        return currencyFrom;
    }

    /**
     * @param currencyFrom The currencyFrom to set
     */
    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    /**
     * @return The currencyTo
     */
    public String getCurrencyTo() {
        return currencyTo;
    }

    /**
     * @param currencyTo The currencyTo to set
     */
    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
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
     * @return The total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total The total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
