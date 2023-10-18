package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDataIO {
    public static ArrayList<Book> allBooks = new ArrayList<Book>();

    public static void readFromFile(){
        try{
            Scanner s3 = new Scanner(new File("bookings.txt"));
            while (s3.hasNext()) {
                int bookingID =Integer.parseInt(s3.nextLine());
                int bookingDuration = Integer.parseInt(s3.nextLine());
                String startDate = s3.nextLine();
                String returnDate = s3.nextLine();
                String bookstatus = s3.nextLine();
                String paystatus = s3.nextLine();
                Double totalPrice = Double.parseDouble(s3.nextLine());
                Car car = CarDataIO.checkCarNo(Integer.parseInt(s3.nextLine()));
                Customer customer = CustomerDataIO.checkUsername(s3.nextLine());
                s3.nextLine();
                Book p = new Book(bookingID,bookingDuration,startDate,returnDate,bookstatus,paystatus,totalPrice,car,customer);
                allBooks.add(p);
                customer.getMybook().add(p);
                
            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter z = new PrintWriter("bookings.txt");
            for(Book b: allBooks){
                 z.println(b.getBookingID());
                 z.println(b.getBookDuration());
                 z.println(b.getBookDate());
                 z.println(b.getReturnDate());
                 z.println(b.getBookStatus());
                 z.println(b.getPayStatus());
                 z.println(b.getTotalPrice());
                 z.println(b.getBookedCar().getSerialNo());
                 z.println(b.getTenant().getUsername());
                 z.println();
            }
            z.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }
    
     public static Book checkBookNo(int BookNo){
        Book found = null;
        for(Book b : allBooks){
            if (BookNo == b.getBookingID()){
                found = b;
                break;
            }
        }
        return found;
    }
    
    
    
}
