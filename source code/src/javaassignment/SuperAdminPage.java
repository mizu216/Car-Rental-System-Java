package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SuperAdminPage implements ActionListener {
    private JFrame sAPage, caPage, vaPage;
    private Button createAdmin, viewAdmin, create, logout;

    private Label title, title1;

    private Panel buttonP, p;
    private TextField username, password, name;

    public SuperAdminPage() {
        sAPage = new JFrame("Super Admin Page");

        sAPage.setSize(300, 150);

        sAPage.setLocation(700, 300);

        title1 = new Label("Super Admin Page", Label.CENTER);
        title1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        title = new Label("Welcome back, super admin", Label.CENTER);
        logout = new Button("Logout");
        createAdmin = new Button("Create Admin");
        viewAdmin = new Button("View Admin");
        createAdmin.addActionListener(this);
        viewAdmin.addActionListener(this);

        p = new Panel(new BorderLayout());
        buttonP = new Panel();
        buttonP.add(createAdmin);
        buttonP.add(viewAdmin);
        buttonP.add(logout);
        buttonP.setBackground(Color.GRAY);
        p.add(buttonP, BorderLayout.SOUTH);

        sAPage.add(title1);
        sAPage.add(title);
        sAPage.add(p);
        sAPage.getContentPane().setBackground(Color.lightGray);
        sAPage.setLayout(new GridLayout(3, 1));

        logout.addActionListener(this);

    }
    public JFrame getJFrame(){
        return sAPage;
    }

    public void exit(){
        sAPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createAdmin){
            sAPage.setVisible(false);
            CreateAdminPage ca = new CreateAdminPage();
            ca.getJFrame().setVisible(true);
            close(ca.getJFrame());

        } else if (e.getSource()==viewAdmin) {
            sAPage.setVisible(false);
            ViewAdminPage va = new ViewAdminPage();
            va.getJFrame().setVisible(true);
            close(va.getJFrame());



        } else if (e.getSource()==logout) {
            sAPage.setVisible(false);
            Main.homepage.getJFrame().setVisible(true);

        }
    }

    public void close(JFrame j){
        j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        j.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                j.dispose();
                exit();
            }
        });
    }

}
