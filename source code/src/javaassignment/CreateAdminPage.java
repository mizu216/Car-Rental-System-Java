package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAdminPage implements ActionListener {
    private JFrame caPage;

    private Label title, un, pw, n;

    private Panel buttonP, unP, pwP, cP, np;
    private TextField username, password, name;

    private Button create;

    public CreateAdminPage(){
        caPage = new JFrame();
        caPage.setSize(700, 200);
        caPage.setLocation(700, 300);
        username = new TextField(30);
        password = new TextField(30);
        name = new TextField(30);
        caPage.setLayout(new GridLayout(4, 1));
        unP = new Panel();
        pwP = new Panel();
        np = new Panel();
        cP = new Panel();
        un = new Label("Enter username", Label.CENTER);
        pw = new Label("Enter password", Label.CENTER);
        n = new Label("Enter name", Label.CENTER);
        unP.add(un);
        unP.add(username);
        pwP.add(pw);
        pwP.add(password);
        np.add(n);
        np.add(name);
        create = new Button("Create");
        cP.add(create);
        create.addActionListener(this);
        caPage.add(unP);
        caPage.add(pwP);
        caPage.add(np);
        caPage.add(cP);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==create){
            String u = username.getText();
            String p = password.getText();
            String n = name.getText();
            Admin found2 = AdminDataIO.checkUsername(u);
            Customer found = CustomerDataIO.checkUsername(u);
            
            if(found != null||found2!=null||u.equals(Main.sa.getUsername())){
                JOptionPane.showMessageDialog(caPage, "Username already exists");
                clear();
            }else{
                Admin a = new Admin(u, p, n);
                AdminDataIO.admins.add(a);
                AdminDataIO.writeToFile();
                JOptionPane.showMessageDialog(caPage, "Admin Created!");
                clear();
            }
        }
    }

    public JFrame getJFrame(){
        return caPage;
    }

    public void clear(){
        username.setText("");
        password.setText("");
        name.setText("");
    }
}