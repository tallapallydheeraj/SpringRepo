package com.dbs.ordermatching.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity(name="trade_history")
public class TradeHistory {
	@Id
	@Column(name="tradeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int tradeId;
	@ManyToOne
	@JoinColumn(name="buyerid")
	private Client buyer;
	@ManyToOne
	@JoinColumn(name="sellerid")
	private Client seller;
	@ManyToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private Double price;
	private int quantity;
	@Column(name="tradedate")
	private LocalDateTime tradeDate;
	public TradeHistory() {}
	public TradeHistory(int tradeId, Client buyer, Client seller, Instrument instrument, Double price, int quantity,
			LocalDateTime tradeDate) {
		super();
		this.tradeId = tradeId;
		this.buyer = buyer;
		this.seller = seller;
		this.instrument = instrument;
		this.price = price;
		this.quantity = quantity;
		this.tradeDate = tradeDate;
	}
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public Client getBuyer() {
		return buyer;
	}
	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}
	public Client getSeller() {
		return seller;
	}
	public void setSeller(Client seller) {
		this.seller = seller;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDateTime tradeDate) {
		this.tradeDate = tradeDate;
	}
	@Override
	public String toString() {
		return "TradeHistroy [tradeId=" + tradeId + ", buyer=" + buyer + ", seller=" + seller + ", instrument="
				+ instrument + ", price=" + price + ", quantity=" + quantity + ", tradeDate=" + tradeDate + "]";
	}
	
	
}
