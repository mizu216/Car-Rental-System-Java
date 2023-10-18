package javaassignment;
import java.util.ArrayList;

public class Customer extends User{
    private String gender,email,homeAddress,phone,accStatus,accType;
    private int age;
    private ArrayList<Book>myBook = new ArrayList<Book>();
    private ArrayList<Receipt>myReceipt = new ArrayList<Receipt>();

    public Customer(String username, String password, String gender, String email, String homeAddress, String phone, int age, String accStatus,String accType) {
        super(username,password);
        this.gender = gender;
        this.email = email;
        this.homeAddress = homeAddress;
        this.phone = phone;
        this.age = age;
        this.accStatus = accStatus;
        this.accType = accType;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Book> getMybook() {
        return myBook;
    }

    public void setMybook(ArrayList<Book> mybook) {
        this.myBook = mybook;
    }

    public ArrayList<Receipt> getMyReceipt() {
        return myReceipt;
    }

    public void setMyReceipt(ArrayList<Receipt> myReceipt) {
        this.myReceipt = myReceipt;
    }

    public ArrayList<Book> getMyBook() {
        return myBook;
    }

    public void setMyBook(ArrayList<Book> myBook) {
        this.myBook = myBook;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
    
    public Double PayAmount(Double amount){
        return amount;
    }
    
    public String Welcome(){
        return "Hi,Customer:"+ getUsername();
    }
        
     public String[] PersonalDetail(){
        String[] s = new String[6];
        s[0] = super.getUsername();
        s[1] = gender;
        s[2] = email;
        s[3] = homeAddress;
        s[4] = phone;
        s[5] = Integer.toString(age);
        return s;
    }
     
    public String[] BookingDetail(int x){
        String[][] s = new String[myBook.size()][6];
        int i= 0;
        for(Book b: myBook){
            s[i][0] = Integer.toString(b.getBookingID());
            s[i][1]= b.getBookDate();
            s[i][2] = b.getReturnDate();
            s[i][3] = Double.toString(b.getTotalPrice());
            s[i][4] = b.getBookStatus();
            s[i][5] = b.getPayStatus();
            i=i+1;
            
            
        }
        String[] detail = s[x];
        return detail;
    }
    
    public String[][] ReceiptDetail(){
        String[][] s = new String[myReceipt.size()][5];
        int i= 0;
        for(Receipt r: myReceipt){
            s[i][0] = Integer.toString(r.getReceiptNo());
            s[i][1]= r.getItem().getBookedCar().getColour()+ " " + r.getItem().getBookedCar().getModel();
            s[i][2] = r.getItem().getBookedCar().getCarPlate();
            s[i][3] = r.getPayMethod();
            s[i][4] = Double.toString(r.getFinalamount());
            i=i+1;
        }
        return s;
    }
     
     public Book checkMyBook(int bookingID){
        Book found = null;
        for(Book b : myBook){
            if(bookingID == b.getBookingID()){
                found = b;
                break;
            }
        }
        return found;
    }
     
    
}
    

   

    

   
