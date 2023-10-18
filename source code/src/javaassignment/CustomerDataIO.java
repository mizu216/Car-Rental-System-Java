package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDataIO {
    public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();

    public static void readFromFile(){
        try{
            Scanner s2 = new Scanner(new File("customers.txt"));
            while (s2.hasNext()) {
                String name = s2.nextLine();
                String password = s2.nextLine();
                String gender = s2.nextLine();
                String email = s2.nextLine();
                String homeAddress = s2.nextLine();
                String phone = s2.nextLine();
                int age = Integer.parseInt(s2.nextLine());
                String accStatus = s2.nextLine();
                String accType = s2.nextLine();
                s2.nextLine();
                if(accType.equals("Normal")){
                    allCustomers.add(new NormalCustomer(name,password,gender,email,homeAddress,phone,age,accStatus,accType));
                }
                else{
                    allCustomers.add(new VIPCustomer(name,password,gender,email,homeAddress,phone,age,accStatus,accType));

                }
            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter y = new PrintWriter("customers.txt");
            for(Customer c: allCustomers){
                 y.println(c.getUsername());
                 y.println(c.getPassword());
                 y.println(c.getGender());
                 y.println(c.getEmail());
                 y.println(c.getHomeAddress());
                 y.println(c.getPhone());
                 y.println(c.getAge());
                 y.println(c.getAccStatus());
                 y.println(c.getAccType());
                 y.println();
            }
            y.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }
    
    public static Customer checkUsername(String username){
        Customer found = null;
        for(Customer c : allCustomers){
            if(username.equals(c.getUsername())){
                found = c;
                break;
            }
        }
        return found;
    }
    
    public static String[][] allCustomerInfo(){
        String[][] s = new String[allCustomers.size()][6];
            int i = 0;
            for (Customer c:allCustomers){
                s[i][0] = c.getUsername();
                s[i][1] = c.getGender();
                s[i][2] = c.getEmail();
                s[i][3] = c.getHomeAddress();
                s[i][4] = c.getPhone();
                s[i][5] = Integer.toString(c.getAge());
                i += 1;
            }
        return s;
    }
    
}
