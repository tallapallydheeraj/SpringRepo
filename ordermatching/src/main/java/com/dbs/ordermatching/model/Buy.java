package com.dbs.ordermatching.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity(name="buy")
@NamedStoredProcedureQuery(name="INTO_BUY", procedureName = "INTO_BUY",
		parameters = {@StoredProcedureParameter(mode=ParameterMode.IN, name="cid",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="iid",type=String.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="p",type=Double.class),
				@StoredProcedureParameter(mode=ParameterMode.IN, name="q",type=Integer.class)})
public class Buy {
	@Id
	@Column(name="buyid")
	private int buyId;
	@OneToOne
	@JoinColumn(name="clientid")
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private double price;
	private int quantity;
	@Column(name="remainingqty")
	private int remainingQty;
	@Column(name="buydate")
	private LocalDateTime buyDate;
	private int flag;
	public Buy() {
		// TODO Auto-generated constructor stub
	}
	public Buy(int buyId, Client client, Instrument instrument, double price, int quantity, int remainingQty,
			LocalDateTime buyDate, int flag) {
		
		this.buyId = buyId;
		this.client = client;
		this.instrument = instrument;
		this.price = price;
		this.quantity = quantity;
		this.remainingQty = remainingQty;
		this.buyDate = buyDate;
		this.flag = flag;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
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
	public LocalDateTime getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(LocalDateTime buyDate) {
		this.buyDate = buyDate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Buy [buyId=" + buyId + ", client=" + client + ", instrument=" + instrument + ", price=" + price
				+ ", quantity=" + quantity + ", remainingQty=" + remainingQty + ", buyDate=" + buyDate + ", flag="
				+ flag + "]";
	}
}
