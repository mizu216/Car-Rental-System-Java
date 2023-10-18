package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceiptDataIO {
    public static ArrayList<Receipt> allReceipts = new ArrayList<Receipt>();

    public static void readFromFile(){
        try{
            Scanner s3 = new Scanner(new File("receipt.txt"));
            while (s3.hasNext()) {
                int receiptID =Integer.parseInt(s3.nextLine());
                Book item = BookDataIO.checkBookNo(Integer.parseInt(s3.nextLine()));
                Double finalpayment = Double.parseDouble(s3.nextLine());
                String payMethod = s3.nextLine();
                s3.nextLine();
                
                Receipt r = new Receipt(receiptID,item,finalpayment,payMethod);
                r.getItem().getTenant().getMyReceipt().add(r);
                allReceipts.add(r); 
            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter z = new PrintWriter("receipt.txt");
            for(Receipt r: allReceipts){
                 z.println(r.getReceiptNo());
                 z.println(r.getItem().getBookingID());
                 z.println(r.getFinalamount());
                 z.println(r.getPayMethod());
                 z.println();
            }
            z.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }
    
    
    
}
