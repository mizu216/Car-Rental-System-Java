package javaassignment;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarDataIO {
    public static ArrayList<Car> allCars = new ArrayList<Car>();

    public static void readFromFile(){
        try{
            Scanner s1 = new Scanner(new File("cars.txt"));
            while (s1.hasNext()) {
                int carNo = Integer.parseInt(s1.nextLine());
                String model = s1.nextLine();
                String colour = s1.nextLine();
                String carplate = s1.nextLine();
                String status = s1.nextLine();
                float bookPrice = Float.parseFloat(s1.nextLine());
                s1.nextLine();
                allCars.add(new Car(carNo,model,colour,carplate,status,bookPrice));

            }
        }
        catch (Exception e){
            System.out.println("Error in read");
        }

    }

    public static void writeToFile(){
        try{
            PrintWriter x = new PrintWriter("cars.txt");
            for(Car c: allCars){
                 x.println(c.getSerialNo());
                 x.println(c.getModel());
                 x.println(c.getColour());
                 x.println(c.getCarPlate());
                 x.println(c.getStatus());
                 x.println(c.getBookPrice());
                 x.println();
            }
            x.close();
        }catch (Exception e){
            System.out.println("Error in write");
        }
    }
    
    public static Car checkCarNo(int carNo){
        Car found = null;
        for(Car c : allCars){
            if (carNo == c.getSerialNo()){
                found = c;
                break;
            }
        }
        return found;
    }
    
    public static String[] allCarDetail(int x){
        String[][] s = new String[allCars.size()][6];
        int i= 0;
        for(Car c: allCars){
            s[i][0] = Integer.toString(c.getSerialNo());
            s[i][1] = c.getModel();
            s[i][2] = c.getColour();
            s[i][3] = c.getCarPlate();
            s[i][4] = c.getStatus();
            s[i][5] = Double.toString(c.getBookPrice());
            i=i+1;
        }
        String[] detail = s[x];
        return detail;
    }
    
}
