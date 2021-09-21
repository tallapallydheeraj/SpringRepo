package com.dbs.ordermatching.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="client_instrument")
public class ClientInstrument {
	@Id
	@Column(name="clientinstrumentid")
	private String clientInstrumentId;
	@JoinColumn(name="clientid")
	@ManyToOne
	private Client client;
	@JoinColumn(name="instrumentid")
	@ManyToOne
	private Instrument instrument;
	private int quantity;
	public ClientInstrument() {
		// TODO Auto-generated constructor stub
	}
	public ClientInstrument(String clientInstrumentId, Client client, Instrument instrument, int quantity) {
		this.clientInstrumentId = clientInstrumentId;
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
	}
	public String getClientInstrumentId() {
		return clientInstrumentId;
	}
	public void setClientInstrumentId(String clientInstrumentId) {
		this.clientInstrumentId = clientInstrumentId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ClientInstrument [clientInstrumentId=" + clientInstrumentId + ", client=" + client + ", instrument="
				+ instrument + ", quantity=" + quantity + "]";
	}
	
	
}
