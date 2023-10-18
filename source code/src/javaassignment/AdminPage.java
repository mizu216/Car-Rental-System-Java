package javaassignment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminPage implements ActionListener {
    private JFrame aPage, car;
    private Button customerAcc, viewCars, viewBookings, addCars, gr, accAppr, logout, feedback;

    private JLabel title;

    private Label greeting;

    private Panel p1, p2, p3;

    public AdminPage() {
        aPage = new JFrame("Admin");
        aPage.setSize(500, 300);
        aPage.setLocation(700, 300);
        logout = new Button("Logout");
        accAppr = new Button("Approve Account");
        customerAcc = new Button("View Customer");
        viewCars = new Button("View Cars");
        viewBookings = new Button("View Bookings");
        addCars = new Button("Add Cars");
        gr = new Button("Generate Report");
        feedback = new Button("Review Feedback");

        logout.setBackground(Color.LIGHT_GRAY);
        gr.setBackground(Color.LIGHT_GRAY);
        addCars.setBackground(Color.LIGHT_GRAY);
        viewBookings.setBackground(Color.LIGHT_GRAY);
        viewCars.setBackground(Color.LIGHT_GRAY);
        customerAcc.setBackground(Color.LIGHT_GRAY);
        accAppr.setBackground(Color.LIGHT_GRAY);
        feedback.setBackground(Color.LIGHT_GRAY);

        logout.addActionListener(this);
        accAppr.addActionListener(this);
        gr.addActionListener(this);
        customerAcc.addActionListener(this);
        viewCars.addActionListener(this);
        viewBookings.addActionListener(this);
        addCars.addActionListener(this);
        feedback.addActionListener(this);

        aPage.setLayout(new GridLayout(3, 1));
        title = new JLabel("Admin Page", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 14));
        greeting = new Label("Welcome back to Admin Page, what would you like to do?");
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p1.add(title);
        p1.setBackground(Color.WHITE);
        p2.add(accAppr);
        p2.add(customerAcc);
        p2.add(viewCars);
        p2.add(viewBookings);
        p2.add(addCars);
        p2.add(logout);
        p2.add(gr);
        p2.add(feedback);
        p3.add(greeting);
        aPage.add(p1);
        aPage.add(p3);
        aPage.add(p2);
        aPage.getContentPane().setBackground(Color.GRAY);
    }

    public JFrame getJFrame() {
        return aPage;
    }

    public void exit() {
        aPage.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerAcc) {
            aPage.setVisible(false);
            CustomerAcc ca = new CustomerAcc();
            ca.getJFrame().setVisible(true);
            close(ca.getJFrame());

        } else if (e.getSource() == viewCars) {
            //read cars.txt
            aPage.setVisible(false);
            viewCarsPage vc = new viewCarsPage();
            vc.getJFrame().setVisible(true);
            close(vc.getJFrame());


        } else if (e.getSource() == viewBookings) {
            aPage.setVisible(false);
            ViewBookingPage v = new ViewBookingPage();
            v.getJFrame().setVisible(true);
            close(v.getJFrame());

        } else if (e.getSource() == addCars) {
            aPage.setVisible(false);
            AddCars a = new AddCars();
            a.getJFrame().setVisible(true);
            close(a.getJFrame());


        }else if (e.getSource() == gr) {
            aPage.setVisible(false);
            ReportPage r = new ReportPage();
            r.getJFrame().setVisible(true);
            close(r.getJFrame());

        } else if (e.getSource() == accAppr) {
            aPage.setVisible(false);
            ApproveAcc a = new ApproveAcc();
            a.getJFrame().setVisible(true);
            close(a.getJFrame());

        } else if (e.getSource()==logout) {
            aPage.setVisible(false);
            Main.homepage.getJFrame().setVisible(true);

        } else if (e.getSource()==feedback) {
            aPage.setVisible(false);
            FeedbackPage fp = new FeedbackPage();
            fp.getJFrame().setVisible(true);
            close(fp.getJFrame());

        }
    }

    public void close(JFrame f){
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
                exit();
            }
        });
    }
}