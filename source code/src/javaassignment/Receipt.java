package javaassignment;

public class Receipt {
    private int receiptNo;
    private Book item;
    private double finalamount;
    private String payMethod;

    public Receipt(int receiptNo, Book item, double finalamount, String payMethod) {
        this.receiptNo = receiptNo;
        this.item = item;
        this.finalamount = finalamount;
        this.payMethod = payMethod;
    }

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Book getItem() {
        return item;
    }

    public void setItem(Book item) {
        this.item = item;
    }

    public double getFinalamount() {
        return finalamount;
    }

    public void setFinalamount(double finalamount) {
        this.finalamount = finalamount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    

    
    
    
}
