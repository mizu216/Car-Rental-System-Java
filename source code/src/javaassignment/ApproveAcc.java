package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ApproveAcc implements ActionListener {

    private JFrame accApproval;

    private Button approve_all, reject, approve;

    private Panel p;

    public ApproveAcc(){
        String[] column = {"Username", "Account Status"};
        ArrayList<Customer> cus = new ArrayList<Customer>();
        int i = 0;
        for (Customer c: CustomerDataIO.allCustomers){
            if (c.getAccStatus().equals("Pending")){
                cus.add(c);
            }
        }
        String[][] s = new String[cus.size()][2];
        for (Customer c1: cus){
            s[i][0] = c1.getUsername();
            s[i][1] = c1.getAccStatus();
            i += 1;
        }
        accApproval = new JFrame();
        accApproval.setLayout(new BorderLayout());
        accApproval.setSize(1000, 500);
        accApproval.setLocation(700, 300);
        approve_all = new Button("Approve All");
        approve = new Button("Approve");
        reject = new Button("Reject");
        approve_all.addActionListener(this);
        approve.addActionListener(this);
        reject.addActionListener(this);
        JTable table = new JTable(s, column);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(Color.LIGHT_GRAY);
        table.setGridColor(Color.BLACK.brighter());
        table.setBackground(Color.ORANGE.brighter());
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        p = new Panel();
        p.add(approve);
        p.add(approve_all);
        p.add(reject);
        accApproval.setTitle("Approve Account");
        accApproval.add(scroll, BorderLayout.CENTER);
        accApproval.add(p, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==approve_all){
            accApproval.setVisible(false);
            approve_acc();
        } else if (e.getSource()==approve) {
            String input = JOptionPane.showInputDialog("Enter the customer username");
            approve_acc(input);

        } else if (e.getSource()==reject) {
            String input = JOptionPane.showInputDialog("Enter the customer username");
            reject_acc(input);
            accApproval.setVisible(false);
        }
    }

    public JFrame getJFrame(){
        return accApproval;
    }

    public void approve_acc(){
        for (Customer c: CustomerDataIO.allCustomers){
            if (c.getAccStatus().equals("Pending")){
                c.setAccStatus("Approved");
            }
        }
        CustomerDataIO.writeToFile();
        JOptionPane.showMessageDialog(accApproval, "Account Approved!");
        Main.adminpage.getJFrame().setVisible(true);

    }

    public void approve_acc(String u){
        Customer found = CustomerDataIO.checkUsername(u);
        if (found != null && found.getAccStatus().equals("Pending")){
            found.setAccStatus("Approved");
            JOptionPane.showMessageDialog(accApproval, "Account Approved!");
            accApproval.setVisible(false);
            Main.adminpage.getJFrame().setVisible(true);
            CustomerDataIO.writeToFile();
        }else{
            JOptionPane.showMessageDialog(accApproval, "Invalid Input");
        }

    }

    public void reject_acc(String u){
        Customer found = CustomerDataIO.checkUsername(u);
        if (found != null && found.getAccStatus().equals("Pending")){
            found.setAccStatus("Reject");
            JOptionPane.showMessageDialog(accApproval, "Account Rejected!");
            accApproval.setVisible(false);
            Main.adminpage.getJFrame().setVisible(true);
            CustomerDataIO.allCustomers.remove(found);
            CustomerDataIO.writeToFile();
        }else{
            JOptionPane.showMessageDialog(accApproval, "Invalid Input");
        }
    }
}
