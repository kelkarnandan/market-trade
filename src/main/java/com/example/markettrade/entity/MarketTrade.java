package com.example.markettrade.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.markettrade.util.MarketTradeStringUtils;

@Entity
@Table(name = "market_trade")
public class MarketTrade implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="user_id")
	private String userId;
	@Column(name="processed_time")
	private Date processedTime;

	public MarketTrade() {
		super();
	}

	public MarketTrade(Long id, String userId, Date processedTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.processedTime = processedTime;
	}

	public MarketTrade(String userId, Date processedTime) {
		super();
		this.userId = userId;
		this.processedTime = processedTime;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the processedTime
	 */
	public Date getProcessedTime() {
		return processedTime;
	}

	/**
	 * @param processedTime
	 *            the processedTime to set
	 */
	public void setProcessedTime(Date processedTime) {
		this.processedTime = processedTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MarketTradeStringUtils.toString(this);
	}
}
