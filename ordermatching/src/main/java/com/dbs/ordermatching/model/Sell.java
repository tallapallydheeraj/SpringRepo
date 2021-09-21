package com.dbs.ordermatching.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name="sell")
public class Sell {
	@Id
	@Column(name="sellid")
	private int sellId;
	@JoinColumn(name="clientid")
	@OneToOne
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private double price;
	private int quantity;
	@Column(name="remainingqty")
	private int remainingQty;
	@Column(name="selldate")
	private LocalDateTime sellDate;
	private int flag;
	public Sell() {
		// TODO Auto-generated constructor stub
	}
	public Sell(int sellId, Client client, Instrument instrument, double price, int quantity, int remainingQty,
			LocalDateTime sellDate, int flag) {
		this.sellId = sellId;
		this.client = client;
		this.instrument = instrument;
		this.price = price;
		this.quantity = quantity;
		this.remainingQty = remainingQty;
		this.sellDate = sellDate;
		this.flag = flag;
	}
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRemainingQty() {
		return remainingQty;
	}
	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}
	public LocalDateTime getSellDate() {
		return sellDate;
	}
	public void setSellDate(LocalDateTime sellDate) {
		this.sellDate = sellDate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Sell [sellId=" + sellId + ", client=" + client + ", instrument=" + instrument + ", price=" + price
				+ ", quantity=" + quantity + ", remainingQty=" + remainingQty + ", sellDate=" + sellDate + ", flag="
				+ flag + "]";
	}
}
