package com.virtusa.BankProcess;

public class Response {
	private String transactionId;
	private long accountNumber;
	private String status;
	private String description;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
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
	@Override
	public String toString() {
		return "Response [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", status=" + status
				+ ", description=" + description + "]";
	}

	
}
