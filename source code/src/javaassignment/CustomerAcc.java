package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAcc implements ActionListener {

    private JFrame customer;

    private Panel p1, p2, p3;

    private Label title;

    private Button search, delete,promote;

    public CustomerAcc(){
        String[][] s = new String[CustomerDataIO.allCustomers.size()][9];
        String[] column = {"Username", "Password", "Gender", "Email", "Address", "Phone",
        "Acc Status", "Acc Type", "Age"};
        int i = 0;
        for (Customer c : CustomerDataIO.allCustomers) {
            s[i][0] = c.getUsername();
            s[i][1] = c.getPassword();
            s[i][2] = c.getGender();
            s[i][3] = c.getEmail();
            s[i][4] = c.getHomeAddress();
            s[i][5] = c.getPhone();
            s[i][6] = c.getAccStatus();
            s[i][7] = c.getAccType();
            s[i][8] = Integer.toString(c.getAge());
            i += 1;
        }
        customer = new JFrame();
        customer.setSize(1000, 500);
        customer.setLocation(700, 300);
        search = new Button("Search");
        delete = new Button("Delete");
        promote = new Button("Promote");
        search.addActionListener(this);
        delete.addActionListener(this);
        promote.addActionListener(this);
        customer.setLayout(new BorderLayout());
        JTable table = new JTable(s, column);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel(new FlowLayout());
        p3.add(search);
        p3.add(delete);
        p3.add(promote);
        title = new Label("Customer Account");
        customer.add(title, BorderLayout.NORTH);
        customer.add(scroll, BorderLayout.CENTER);
        customer.add(p3, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==search){
                String input = JOptionPane.showInputDialog("Enter the username you want to search");
                Customer found = CustomerDataIO.checkUsername(input);
                if(found != null){
                    FoundPage f = new FoundPage(found);
                    f.getJFrame().setVisible(true);
                }


            } else if (e.getSource()==delete) {
                String input = JOptionPane.showInputDialog("Enter the username you want to delete");
                Customer found = CustomerDataIO.checkUsername(input);
                if (found != null){
                    CustomerDataIO.allCustomers.remove(found);
                    CustomerDataIO.writeToFile();
                    customer.setVisible(false);
                    Main.adminpage.getJFrame().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(customer, "Incorrect Username");
                }
            }else if (e.getSource()==promote) {
                String input = JOptionPane.showInputDialog("Enter the username you want to promote");
                Customer found = CustomerDataIO.checkUsername(input);
                if (found != null){
                    found.setAccType("VIP");
                    CustomerDataIO.writeToFile();
                    customer.setVisible(false);
                    Main.adminpage.getJFrame().setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(customer, "Incorrect Username");
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(customer, "Invalid Input");
        }
    }

    public JFrame getJFrame(){
        return customer;
    }
}