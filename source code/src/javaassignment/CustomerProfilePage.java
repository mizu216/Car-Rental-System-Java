package javaassignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerProfilePage implements ActionListener{
    private JFrame x;
    private Panel p0,p1,p2;
    private Label PI;
    private DefaultTableModel tableModel;
    private JTable table;
    private Button changepassword,changephone,changeaddress,back;
    public CustomerProfilePage(){
        x = new JFrame("Customer Profile Page");
        x.setSize(1200,200);
        x.setLocation(700,300);
        x.setLayout(new BorderLayout());
        
        p0 = new Panel();
        p0.setLayout(new BorderLayout());
        p1 = new Panel();
        p1.setLayout(new BorderLayout());
        p2 = new Panel();
        
        PI = new Label("__Personal Information__",Label.CENTER);
        PI.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        p0.add(PI,BorderLayout.NORTH);
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("USERNAME");
        tableModel.addColumn("GENDER");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("HOME_ADDRESS");
        tableModel.addColumn("PHONE_NO");
        tableModel.addColumn("AGE");
        table = new JTable(tableModel);
        table.setBackground(Color.CYAN);
        p0.add(new JScrollPane(table),BorderLayout.CENTER);
        table.setEnabled(false);

        changepassword = new Button("Change Password");
        changephone= new Button("Change Phone");
        changeaddress = new Button("Change Address");
        back = new Button("Back");
        changepassword.addActionListener(this);
        changephone.addActionListener(this);
        changeaddress.addActionListener(this);
        back.addActionListener(this);
        p2.add(changepassword);
        p2.add(changephone);
        p2.add(changeaddress);
        p2.add(back);
        
        p1.add(p2,BorderLayout.SOUTH);

        x.add(p0,BorderLayout.CENTER);
        x.add(p1,BorderLayout.SOUTH);
    }
    
    public JFrame getJFrame(){
        return x;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()== changepassword){
                String oldPassword = JOptionPane.showInputDialog("Enter Your Old Password");
                if(oldPassword.equals(Main.loginUser.getPassword())){
                    String newPassword = JOptionPane.showInputDialog("Enter New Password");
                    if (newPassword==null){
                        JOptionPane.showMessageDialog(x,"Nothing is changed!!!");
                    }
                    else{
                        Main.loginUser.setPassword(newPassword);
                        CustomerDataIO.writeToFile();
                        JOptionPane.showMessageDialog(x,"Password has changed");
                        tableModel.removeRow(0);
                        x.setVisible(false);
                        Main.customerpage.getJFrame().setVisible(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(x,"Invalid old password");
                }
            }
            
            else if(e.getSource()== changephone){
                String newPhone = JOptionPane.showInputDialog("Enter Your New Phone No");
                if (newPhone==null){
                    JOptionPane.showMessageDialog(x,"Nothing is changed!!!");
                }
                else{
                    Main.loginUser.setPhone(newPhone);
                    CustomerDataIO.writeToFile();
                    JOptionPane.showMessageDialog(x,"Phone No has changed");
                    tableModel.removeRow(0);
                    x.setVisible(false);
                    Main.customerpage.getJFrame().setVisible(true);
                }
            }
           
            else if(e.getSource()== changeaddress){
                String newAddress = JOptionPane.showInputDialog("Enter Your Address");
                if (newAddress==null){
                    JOptionPane.showMessageDialog(x,"Nothing is changed!!!");
                }
                else{
                    Main.loginUser.setHomeAddress(newAddress);
                    CustomerDataIO.writeToFile();
                    JOptionPane.showMessageDialog(x,"Home Address has changed");
                    tableModel.removeRow(0);
                    x.setVisible(false);
                    Main.customerpage.getJFrame().setVisible(true);
                }
            }
            
            else if(e.getSource()==back){
                tableModel.removeRow(0);
                x.setVisible(false);
                Main.customerpage.getJFrame().setVisible(true);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid Input!!!");
        }
        
    }
}
