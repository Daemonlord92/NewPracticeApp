package myclass;

public class Transaction {
    private int transactionId;
    private float transactionAmount;
    private String transactionFrom;
    private String transactionTo;

    public int getTransactionId() {
        return transactionId;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public String getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public void setTransactionFrom(String transactionFrom) {
        this.transactionFrom = transactionFrom;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "transactionId=" + transactionId +
                ", transactionAmount=" + transactionAmount +
                ", transactionFrom='" + transactionFrom + '\'' +
                ", transactionTo='" + transactionTo + '\'' +
                '}';
    }
}
