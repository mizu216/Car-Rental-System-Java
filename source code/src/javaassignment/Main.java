package javaassignment;

public class Main {
    public static HomePage homepage;
    public static RegisterPage registerpage;
    public static AdminPage adminpage;
    public static CustomerPage customerpage;
    public static CustomerProfilePage customerprofilepage;
    public static CustomerBookingPage customerbookingpage;
    public static CustomerViewBookPage customerviewbookpage;
    public static CustomerPaymentPage customerpaymentpage;
    public static Customer loginUser = null;

    public static SuperAdmin sa;

    public static SuperAdminPage superAdminPage;
    
    public static void main(String[] args) {
        CustomerDataIO.readFromFile();
        CarDataIO.readFromFile();
        BookDataIO.readFromFile();
        ReceiptDataIO.readFromFile();
        AdminDataIO.readFromFile();
        FeedbackDataIO.readFromFile();
        
        sa = new SuperAdmin("superadmin","sa123");
        homepage = new HomePage();
        registerpage = new RegisterPage();
        adminpage = new AdminPage();
        customerpage = new CustomerPage();
        customerprofilepage = new CustomerProfilePage();
        customerbookingpage = new CustomerBookingPage();
        customerviewbookpage = new CustomerViewBookPage();
        customerpaymentpage = new CustomerPaymentPage();
        superAdminPage = new SuperAdminPage();
    }
    
}
