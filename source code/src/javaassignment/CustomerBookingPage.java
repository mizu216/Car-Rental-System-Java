package javaassignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class CustomerBookingPage implements ActionListener{
    
    private JFrame x;
    private Panel p0,p1,p2,p3,p4;
    private JTable table;
    private DefaultTableModel tableModel;
    private Label CD,carSerialNo;
    private TextField carNoInput;
    private Button book,back;
    public CustomerBookingPage(){
        x = new JFrame("Customer Booking Page");
        x.setSize(1200,500);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        p1.setLayout(new GridLayout(3,1));
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        
        CD = new Label("__CAR DETAIL__",Label.CENTER);
        CD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        p0.add(CD,BorderLayout.NORTH);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CAR SERIAL NO");
        tableModel.addColumn("MODEL");
        tableModel.addColumn("COLOUR");
        tableModel.addColumn("PLATE NUMBER");
        tableModel.addColumn("STATUS");
        tableModel.addColumn("PRICE PER DAY");
        table = new JTable(tableModel);
        table.setBackground(Color.ORANGE);
        p0.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setEnabled(false);
        
        carSerialNo = new Label("ENTER CAR SERIAL NO");
        p2.add(carSerialNo);
        
        carNoInput = new TextField(30);
        p3.add(carNoInput);
        

        book = new Button("Book");
        back = new Button("Back");
        book.addActionListener(this);
        back.addActionListener(this);
        p4.add(book);
        p4.add(back);
        
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        
        x.add(p1,BorderLayout.NORTH);
        x.add(p0,BorderLayout.CENTER);
    }
    
    public JFrame getJFrame(){
        return x;
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public void clearAllRow(){
        int row = tableModel.getRowCount();
        for(int i = 0;i<row;i++){
            tableModel.removeRow(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==book){
                String input = carNoInput.getText();
                carNoInput.setText("");
                Car found = CarDataIO.checkCarNo(Integer.parseInt(input));
                if (found!=null&&found.getStatus().equals("Available")){
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String startDate = JOptionPane.showInputDialog("Enter Start Date(dd/MM/yyyy):");
                    String endDate = JOptionPane.showInputDialog("Enter End Date(dd/MM/yyyy):");
                    LocalDate date1= LocalDate.parse(startDate,f);
                    LocalDate date2= LocalDate.parse(endDate,f);
                    long dayDiff= ChronoUnit.DAYS.between(date1,date2);
                    
                    if (dayDiff<=0){
                        JOptionPane.showMessageDialog(x, "Return date must bigger than start date!!!");
                    }
                    else{
                        double totalPrice = dayDiff*found.getBookPrice();
                        Book b = new Book(BookDataIO.allBooks.size(),dayDiff,startDate,endDate,"Pending","Unpaid",totalPrice,found,Main.loginUser);
                        BookDataIO.allBooks.add(b);
                        Main.loginUser.getMybook().add(b);
                        found.setStatus("Not Available");
                        CarDataIO.writeToFile();
                        BookDataIO.writeToFile();
                        JOptionPane.showMessageDialog(x, "Finish booking,please wait for admin to approve.");
                        clearAllRow();
                        x.setVisible(false);
                        Main.customerpage.getJFrame().setVisible(true);
                    }
                }
            
                    
                else{
                    JOptionPane.showMessageDialog(x,"This car is not exist or currently cannot be booked.");
                }
            }
            else if(e.getSource()==back){
                String input = carNoInput.getText();
                carNoInput.setText("");
                clearAllRow();
                x.setVisible(false);
                Main.customerpage.getJFrame().setVisible(true);


            }
        }
        
        catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(x,"Invalid Input!!!");
        }
        
    }
    
    
    
}
