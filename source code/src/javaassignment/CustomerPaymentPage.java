package javaassignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class CustomerPaymentPage implements ActionListener{
    private JFrame x;
    private Panel p0,p1,p2,p3;
    private Button creditcard,onlinebanking,back;
    private Label payment,method;
    private Book item;
    public CustomerPaymentPage(){
        x = new JFrame("Payment Page");
        x.getContentPane().setBackground(Color.lightGray);
        x.setSize(300,150);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        p0 = new Panel();
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel();
        p3 = new Panel();
        
        payment = new Label("The Total Payment is RM???",Label.CENTER);
        p2.add(payment);
        method = new Label("Please Choose Your Payment Method:");
        p3.add(method);
        p1.add(p2);
        p1.add(p3);
        
        creditcard = new Button("Credit Card");
        onlinebanking = new Button("Online Banking");
        back = new Button("Back");
        creditcard.addActionListener(this);
        onlinebanking.addActionListener(this);
        back.addActionListener(this);
        
        p0.add(creditcard);
        p0.add(onlinebanking);
        p0.add(back);
        
        x.add(p1,BorderLayout.CENTER);
        x.add(p0,BorderLayout.SOUTH);
    }
    
    public JFrame getJFrame(){
        return x;
    }

    public void setItem(Book item) {
        this.item = item;
    }
    
    public Label getLabel(){
        return payment;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==creditcard){
                String cardNoInput = JOptionPane.showInputDialog("Please Enter Your Credit Card Number:");
                Long.parseLong(cardNoInput);
                if (cardNoInput.length() == 16){
                    String expiryInput = JOptionPane.showInputDialog("Please Enter Expiry Date(MMYY):");
                    Integer.parseInt(expiryInput);
                    if (expiryInput.length() == 4){
                        String securityInput = JOptionPane.showInputDialog("Please Enter Security Code:");
                        Integer.parseInt(securityInput);
                        if (securityInput.length() == 3){
                            Book found = item;
                            Receipt r = new Receipt(ReceiptDataIO.allReceipts.size(),item,Main.loginUser.PayAmount(found.getTotalPrice()),"Credit Card");
                            ReceiptDataIO.allReceipts.add(r);
                            Main.loginUser.getMyReceipt().add(r);
                            found.setPayStatus("Paid");
                            ReceiptDataIO.writeToFile();
                            BookDataIO.writeToFile();
                            JOptionPane.showMessageDialog(x, "Thanks for the payment");
                            x.setVisible(false);
                            Main.customerpage.getJFrame().setVisible(true);

                        }
                        
                        else{
                            JOptionPane.showMessageDialog(x, "Security Code Must have 3 Numbers");
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(x, "Expiry Date Must Follow Format MMYY");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(x, "Credit Card No Must have 16 Numbers");
                }            
            }
            
            else if(e.getSource()==onlinebanking){
                String bankInput = JOptionPane.showInputDialog("Please Enter Your Bank Name:");
                if (bankInput != null){
                    String bankAccInput = JOptionPane.showInputDialog("Please Enter Your Bank Account Number:");
                    Integer.parseInt(bankAccInput);
                    String securityCodeInput = JOptionPane.showInputDialog("Please Enter 6 Scurity Code Send to Your Phone:");
                    Integer.parseInt(securityCodeInput);
                    if (securityCodeInput.length()==6){
                        Book found = item;
                        Receipt r = new Receipt(ReceiptDataIO.allReceipts.size(),item,Main.loginUser.PayAmount(found.getTotalPrice()),"Online Banking:"+ bankInput);
                        ReceiptDataIO.allReceipts.add(r);
                        Main.loginUser.getMyReceipt().add(r);
                        found.setPayStatus("Paid");
                        ReceiptDataIO.writeToFile();
                        BookDataIO.writeToFile();
                        JOptionPane.showMessageDialog(x, "Thanks for the payment");
                        x.setVisible(false);
                        Main.customerpage.getJFrame().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(x, "Invalid Security Code");
                    }
                }
            }
            
            
            else if(e.getSource()==back){
                x.setVisible(false);
                Main.customerpage.getJFrame().setVisible(true);
            }
                
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
        }
    }
  
    
    
    
}

