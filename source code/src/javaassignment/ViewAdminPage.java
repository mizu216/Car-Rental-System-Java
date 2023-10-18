package javaassignment;

import javax.swing.*;
import java.awt.*;

public class ViewAdminPage {
    private JFrame vaPage;

    public ViewAdminPage(){
        vaPage = new JFrame();
        vaPage.setLayout(new FlowLayout());
        vaPage.setSize(1000, 500);
        vaPage.setLocation(700, 300);
        String[][] admin = new String[AdminDataIO.admins.size()][3];
        String[] column = {"Username", "Password", "Name"};
        int i = 0;
        for (Admin c: AdminDataIO.admins){
            admin[i][0] = c.getUsername();
            admin[i][1] = c.getPassword();
            admin[i][2] = c.getName();
            i += 1;
        }
        JTable table = new JTable(admin, column);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        vaPage.add(scroll);
    }

    public JFrame getJFrame(){
        return vaPage;
    }
}