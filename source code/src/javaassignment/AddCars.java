package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCars implements ActionListener {
    private JFrame x;
    private Panel p0,p1,p2,p4,p7,p8,p9,p11,p12,p14;
    private Label car,color,plate,price;
    private TextField carInput,colorInput,plateInput,priceInput;
    private Button confirm,back;
    public AddCars(){
        x = new JFrame("Register Page");
        x.getContentPane().setBackground(new Color(255, 236, 188));
        x.setSize(800,400);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel(new GridLayout(2,1));
        p4 = new Panel(new GridLayout(2,1));
        p7 = new Panel();
        p8 = new Panel();
        p9 = new Panel();
        p11 = new Panel();
        p12 = new Panel();
        p14 = new Panel();



        car = new Label("Car Model",Label.CENTER);
        carInput = new TextField(30);
        p7.add(carInput);
        p0.add(car);
        p0.add(p7);

        color = new Label("Color",Label.CENTER);
        colorInput = new TextField(30);
        p8.add(colorInput);
        p1.add(color);
        p1.add(p8);

        plate = new Label("Car Plate",Label.CENTER);
        plateInput = new TextField(30);
        p9.add(plateInput);
        p2.add(plate);
        p2.add(p9);

        price = new Label("Price",Label.CENTER);
        priceInput = new TextField(30);
        p11.add(priceInput);
        p4.add(price);
        p4.add(p11);

        confirm= new Button("Confirm");
        back = new Button("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        p14.add(confirm);
        p14.add(back);
        
        p12.setLayout(new GridLayout(3,2));
        p12.add(p0);
        p12.add(p1);
        p12.add(p2);
        p12.add(p4);
        x.setLayout(new BorderLayout());
        x.add(p12,BorderLayout.CENTER);
        x.add(p14,BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==confirm) {
                String car = carInput.getText();
                String color = colorInput.getText();
                String plate = plateInput.getText();
                float price = Float.parseFloat(priceInput.getText());
                if (!car.equals("")&&!color.equals("")&&!plate.equals("")){
                    int serialNo = CarDataIO.allCars.size();
                    CarDataIO.allCars.add(new Car(serialNo, car, color, plate, "Available", price));
                    CarDataIO.writeToFile();
                    carInput.setText("");
                    colorInput.setText("");
                    priceInput.setText("");
                    plateInput.setText("");
                    JOptionPane.showMessageDialog(x, "Car Added");
                }
                else{
                    throw new Exception();
                }
            } else if(e.getSource()== back){
                carInput.setText("");
                colorInput.setText("");
                priceInput.setText("");
                plateInput.setText("");
                x.setVisible(false);
                Main.adminpage.getJFrame().setVisible(true);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
        }

    }
    public JFrame getJFrame(){
        return x;
    }
}