package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoundPage implements ActionListener {
    private JFrame fp;

    private Button ok;

    private Panel p1, p2;

    public FoundPage(Customer found){
        String[][] s = new String[1][9];
        String[] column = {"Username", "Password", "Gender", "Email", "Address", "Phone",
                "Acc Status", "Acc Type", "Age"};
        s[0][0] = found.getUsername();
        s[0][1] = found.getPassword();
        s[0][2] = found.getGender();
        s[0][3] = found.getEmail();
        s[0][4] = found.getHomeAddress();
        s[0][5] = found.getPhone();
        s[0][6] = found.getAccStatus();
        s[0][7] = found.getAccType();
        s[0][8] = Integer.toString(found.getAge());
        JTable table = new JTable(s, column);
        table.setBackground(Color.GREEN);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        fp = new JFrame();
        fp.setSize(1000, 500);
        fp.setLocation(700, 300);
        fp.setLayout(new GridLayout(2, 1));
        ok = new Button("OK");
        ok.addActionListener(this);
        p1 = new Panel();
        p2 = new Panel();
        p1.add(ok);
        fp.setTitle("Search Result");
        fp.getContentPane().setBackground(Color.LIGHT_GRAY);
        fp.add(scroll);
        fp.add(p1);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ok){
            fp.setVisible(false);
        }
    }

    public JFrame getJFrame(){
        return fp;
    }
}

