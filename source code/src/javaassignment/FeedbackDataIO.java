package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FeedbackDataIO {
    public static ArrayList<Feedback> allFeedbacks = new ArrayList<Feedback>();

    public static void readFromFile(){
        try{
            Scanner s3 = new Scanner(new File("feedback.txt"));
            while (s3.hasNext()) {
                int feedbackID =Integer.parseInt(s3.nextLine());
                String feedbackMessage = s3.nextLine();
                Book feedbackItem = BookDataIO.checkBookNo(Integer.parseInt(s3.nextLine()));
                s3.nextLine();

                allFeedbacks.add(new Feedback(feedbackID,feedbackMessage,feedbackItem)); 
            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter z = new PrintWriter("feedback.txt");
            for(Feedback f: allFeedbacks){
                 z.println(f.getFeedbackID());
                 z.println(f.getFeedbackMessage());
                 z.println(f.getFeedbackItem().getBookingID());
                 z.println();
            }
            z.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }
    
    
    
}
