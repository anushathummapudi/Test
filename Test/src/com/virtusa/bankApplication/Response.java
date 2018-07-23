package com.virtusa.bankApplication;

import java.io.Serializable;

public class Response implements Serializable
{
	@Override
	public String toString() {
		return "Response [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", status=" + status
				+ ", description=" + description + "]";
	}
	private String transactionId;
	private String accountNumber;
	private String status;
	private String description;
	public Response(String transactionId, String accountNumber, String status, String description) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.status = status;
		this.description = description;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//private long credits;
	
	
}