package javaassignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class HomePage implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==login){
                String username = usernameInput.getText();
                String password = passwordInput.getText();
                usernameInput.setText("");
                passwordInput.setText("");
                Customer found = CustomerDataIO.checkUsername(username);
                Admin found2 = AdminDataIO.checkUsername(username);
                if(found != null && found.getPassword().equals(password) && found.getAccStatus().equals("Approved")){
                    Main.loginUser=found;
                    Main.customerpage.getLabel().setText(Main.loginUser.Welcome());
                    x.setVisible(false);
                    Main.customerpage.getJFrame().setVisible(true);
                }
                else if(found2 != null && found2.getPassword().equals(password)){
                    x.setVisible(false);
                    Main.adminpage.getJFrame().setVisible(true);
                }
                else if(username.equals(Main.sa.getUsername()) && password.equals(Main.sa.getPassword())) {
                    x.setVisible(false);
                    Main.superAdminPage.getJFrame().setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(x, "Invalid account");
                }
            }
            
            else if(e.getSource() == register){
                x.setVisible(false);
                Main.registerpage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource() == exit){
                System.exit(0);
            }
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
            ex.printStackTrace();
        }
        
    }
    public JFrame getJFrame(){
        return x;
    }
    private JFrame x;
    private Panel p0,p1,p2,p3,p4, p5;
    private Label usernameText,passwordText, title;
    private TextField usernameInput,passwordInput;
    private Button login,register,exit;
    public HomePage(){
        x = new JFrame("Home Page");
        x.setSize(300,300);
        x.setLocation(700,300);
        p0 = new Panel(new GridLayout(2,1));
        p1 = new Panel(new GridLayout(2,1));
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        
        usernameText = new Label("USERNAME",Label.CENTER);
        usernameInput = new TextField(30);
        p2.add(usernameInput);
        p0.add(usernameText);
        p0.add(p2);
        
        passwordText = new Label("PASSWORD",Label.CENTER);
        passwordInput = new TextField(30);
        p3.add(passwordInput);
        p1.add(passwordText);
        p1.add(p3);
        
        login = new Button("Login");
        register= new Button("Register");
        exit = new Button("Exit");
        login.addActionListener(this);
        register.addActionListener(this);
        exit.addActionListener(this);
        p4.add(login);
        p4.add(register);
        p4.add(exit);

        title = new Label("Welcome to Car Rental");
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        p5.add(title);
        
        x.setLayout(new GridLayout(4,1));
        x.add(p5);
        x.add(p0);
        x.add(p1);
        x.add(p4);
        x.getContentPane().setBackground(Color.lightGray);
        x.setVisible(true);
    }
}