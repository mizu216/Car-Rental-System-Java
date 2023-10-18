package javaassignment;

public class Book {
    private int bookingID;
    private long bookDuration;
    private String bookDate,returnDate,bookStatus,payStatus;
    private Double TotalPrice;
    private Car BookedCar;
    private Customer tenant;

    public Book(int bookingID, long bookDuration, String bookDate, String returnDate, String bookStatus, String payStatus, Double TotalPrice, Car BookedCar, Customer tenant) {
        this.bookingID = bookingID;
        this.bookDuration = bookDuration;
        this.bookDate = bookDate;
        this.returnDate = returnDate;
        this.bookStatus = bookStatus;
        this.payStatus = payStatus;
        this.TotalPrice = TotalPrice;
        this.BookedCar = BookedCar;
        this.tenant = tenant;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public long getBookDuration() {
        return bookDuration;
    }

    public void setBookDuration(long bookDuration) {
        this.bookDuration = bookDuration;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public Car getBookedCar() {
        return BookedCar;
    }

    public void setBookedCar(Car BookedCar) {
        this.BookedCar = BookedCar;
    }

    public Customer getTenant() {
        return tenant;
    }

    public void setTenant(Customer tenant) {
        this.tenant = tenant;
    }
}

    



