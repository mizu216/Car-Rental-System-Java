package javaassignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class viewCarsPage implements ActionListener{
    
    private JFrame car;
    private Panel p0,p1,p2,p3,p4;
    private Label carSerialNo;
    private TextField carNoInput;
    private Button available,notAvailable,back;
    public viewCarsPage(){
        car = new JFrame();
        car.setTitle("View Car Page");
        car.setSize(1200,500);
        car.setLocation(700,300);
        car.setLayout(new BorderLayout());
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        p1.setLayout(new GridLayout(3,1));
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        String[][] s = new String[CarDataIO.allCars.size()][6];
            String[] column = {"SerialNo", "Model", "Colour", "CarPlate", "Status", "Price"};
            for(int i =0;i<CarDataIO.allCars.size();i++){
                s[i]=CarDataIO.allCarDetail(i);
            }
        JTable table = new JTable(s, column);
        table.setBackground(Color.ORANGE);
        JScrollPane scroll = new JScrollPane(table);
        table.setEnabled(false);
        p0.add(scroll,BorderLayout.CENTER);
        
        carSerialNo = new Label("ENTER CAR SERIAL NO");
        p2.add(carSerialNo);
        
        carNoInput = new TextField(30);
        p3.add(carNoInput);
        

        available = new Button("Set Available");
        notAvailable = new Button("Set Not Available");
        back = new Button("Back");
        available.addActionListener(this);
        notAvailable.addActionListener(this);
        back.addActionListener(this);
        p4.add(available);
        p4.add(notAvailable);
        p4.add(back);
        
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        
        car.add(p1,BorderLayout.NORTH);
        car.add(p0,BorderLayout.CENTER);
    }
    
    public JFrame getJFrame(){
        return car;
    }    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==available){
                String input = carNoInput.getText();
                carNoInput.setText("");
                Car found = CarDataIO.checkCarNo(Integer.parseInt(input));
                if (found!=null){
                    found.setStatus("Available");
                    CarDataIO.writeToFile();
                    JOptionPane.showMessageDialog(car, "Change Sucessfully");
                    car.setVisible(false);
                    Main.adminpage.getJFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(car,"This car is not exist");
                }
            }
            else if(e.getSource()==notAvailable){
                String input = carNoInput.getText();
                carNoInput.setText("");
                Car found = CarDataIO.checkCarNo(Integer.parseInt(input));
                if (found!=null){
                    found.setStatus("Not Available");
                    CarDataIO.writeToFile();
                    JOptionPane.showMessageDialog(car, "Change Sucessfully");
                    car.setVisible(false);
                    Main.adminpage.getJFrame().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(car,"This car is not exist");
                }
            }

            else if(e.getSource()==back){
                String input = carNoInput.getText();
                carNoInput.setText("");
                car.setVisible(false);
                Main.adminpage.getJFrame().setVisible(true);


            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(car,"Invalid Input!!!");
        }
        
    }
    
    
    
}
