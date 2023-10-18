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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class CustomerViewBookPage implements ActionListener{
    private JFrame x;
    private Panel p0,p1,p2,p3,p4;
    private JTable table;
    private DefaultTableModel tableModel;
    private Label BD,bookingID;
    private TextField bookingIDInput;
    private Button pay,returncar,back;
    public CustomerViewBookPage(){
        x = new JFrame("Customer View Booking Page");
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
        
        BD = new Label("__MY BOOKING DETAIL__",Label.CENTER);
        BD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        p0.add(BD,BorderLayout.NORTH);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("BOOKING ID");
        tableModel.addColumn("START DATE");
        tableModel.addColumn("RETURN DATE");
        tableModel.addColumn("TOTAL PRICE");
        tableModel.addColumn("BOOK STATUS");
        tableModel.addColumn("PAYMENT STATUS");
        table = new JTable(tableModel);
        table.setBackground(Color.PINK);
        p0.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setEnabled(false);
        
        bookingID = new Label("ENTER BOOKING ID");
        p2.add(bookingID);
        
        bookingIDInput = new TextField(30);
        p3.add(bookingIDInput);
        

        pay = new Button("Make Payment");
        returncar = new Button("Return Car");
        back = new Button("Back");
        pay.addActionListener(this);
        returncar.addActionListener(this);
        back.addActionListener(this);
        p4.add(pay);
        p4.add(returncar);
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
            if(e.getSource()==pay){
                int input = Integer.parseInt(bookingIDInput.getText());
                bookingIDInput.setText("");
                Book found = Main.loginUser.checkMyBook(input);
                if (found!=null&&found.getPayStatus().equals("Unpaid")){
                    if (found.getBookStatus().equals("Approved")){
                        Main.customerpaymentpage.setItem(found);
                        Main.customerpaymentpage.getLabel().setText("You need to pay"+Main.loginUser.PayAmount(found.getTotalPrice()));
                        clearAllRow();
                        Main.customerpaymentpage.getJFrame().setVisible(true);
                        x.setVisible(false);
                        }
                    else{
                        JOptionPane.showMessageDialog(x,"Booking is not yet approved.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(x,"Invalid BookingID or you already paid it.");
                }
            }
            
            else if(e.getSource()==returncar){
                int input = Integer.parseInt(bookingIDInput.getText());
                bookingIDInput.setText("");
                Book found = Main.loginUser.checkMyBook(input);
                if (found!=null&&found.getPayStatus().equals("Paid")&&!found.getBookStatus().equals("Done")){
                    String feedbackInput = JOptionPane.showInputDialog("Please Enter Your Feedback");
                    if (feedbackInput !=null){
                        FeedbackDataIO.allFeedbacks.add(new Feedback(FeedbackDataIO.allFeedbacks.size(),feedbackInput,found));
                        found.getBookedCar().setStatus("Available");
                        found.setBookStatus("Done");
                        FeedbackDataIO.writeToFile();
                        CarDataIO.writeToFile();
                        BookDataIO.writeToFile();
                        JOptionPane.showMessageDialog(x,"Car returned successfully");
                        clearAllRow();
                        x.setVisible(false);
                        Main.customerpage.getJFrame().setVisible(true);
                    }
                }
                
                else{
                    JOptionPane.showMessageDialog(x,"Invalid book car return!!!.");

                }
            
            }
            
            else if(e.getSource()==back){
                String input = bookingIDInput.getText();
                bookingIDInput.setText("");
                clearAllRow();
                x.setVisible(false);
                Main.customerpage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid Input!!!");
        }
        
    }
    
   
}
