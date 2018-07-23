package com.virtusa.bankapp;

import java.io.Serializable;
import java.util.Date;

public class BankStatement implements Serializable {

	private String accountNumber;
	private Date statementDate;
	private long minimumAmountDue;
	private long credits;
	private long creditLimit;
	private long availableCredit;
	private long referenceNumber;
	private String transactionDetails;

	public BankStatement(String accountNumber, Date statementDate, long minimumAmountDue, long credits,
			long creditLimit, long availableCredit, long referenceNumber, String transactionDetails) {
		super();
		this.accountNumber = accountNumber;
		this.statementDate = statementDate;
		this.minimumAmountDue = minimumAmountDue;
		this.credits = credits;
		this.creditLimit = creditLimit;
		this.availableCredit = availableCredit;
		this.referenceNumber = referenceNumber;
		this.transactionDetails = transactionDetails;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getStatementDate() {
		return statementDate;
	}

	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}

	public long getMinimumAmountDue() {
		return minimumAmountDue;
	}

	public void setMinimumAmountDue(long minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public long getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(long creditLimit) {
		this.creditLimit = creditLimit;
	}

	public long getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(long availableCredit) {
		this.availableCredit = availableCredit;
	}

	public long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

}
