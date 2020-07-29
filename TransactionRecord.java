package proofchain;

public class TransactionRecord {
	
	//attributes declaration in the transaction record
    private String transactionID; 
    private String transactionType;
	private String transactionDate;
    private String transactionStatus;
    private String transactionAmount;
    
    // Getters and Setters
    public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getAccountNumber() {
		return transactionID;
	}

	public void setAccountNumber(String accountNumber) {
		this.transactionID = accountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
