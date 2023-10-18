package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDataIO {
    public static ArrayList<Admin> admins = new ArrayList<Admin>();

    public static void readFromFile(){
        try{
            Scanner s = new Scanner(new File("admin.txt"));
            while (s.hasNext()) {
                String username = s.nextLine();
                String password = s.nextLine();
                String name = s.nextLine();
                s.nextLine();
                Admin a = new Admin(username, password, name);
                admins.add(a);
            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter z = new PrintWriter("admin.txt");
            for(Admin b: admins){
               z.println(b.getUsername());
               z.println(b.getPassword());
               z.println(b.getName());
               z.println();
            }
            z.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }

    public static Admin checkUsername(String username){
        Admin found = null;
        for(Admin c : admins){
            if(username.equals(c.getUsername())){
                found = c;
                break;
            }
        }
        return found;
    }
}
