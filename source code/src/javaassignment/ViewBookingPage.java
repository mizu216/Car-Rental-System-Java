package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBookingPage implements ActionListener {
    private JFrame booking;

    private Button approve_all_booking, reject_booking, approve_booking;

    public ViewBookingPage(){
        approve_all_booking = new Button("Approve All");
        reject_booking = new Button("Reject");
        approve_booking = new Button("Approve");
        approve_all_booking.addActionListener(this);
        reject_booking.addActionListener(this);
        approve_booking.addActionListener(this);
        String[][] book = new String[BookDataIO.allBooks.size()][9];
        String[] column = {"bookingID", "bookDuration", "bookDate", "returnDate", "bookStatus",
                "payStatus", "TotalPrice", "tenant", "car"};
        int i = 0;
        for (Book c : BookDataIO.allBooks) {
            if (c.getBookStatus().equals("Pending")) {
                book[i][0] = Integer.toString(c.getBookingID());
                book[i][1] = Long.toString(c.getBookDuration());
                book[i][2] = c.getBookDate();
                book[i][3] = c.getReturnDate();
                book[i][4] = c.getBookStatus();
                book[i][5] = c.getPayStatus();
                book[i][6] = Double.toString(c.getTotalPrice());
                book[i][7] = c.getTenant().getUsername();
                book[i][8] = Integer.toString(c.getBookedCar().getSerialNo());
                i += 1;
            }

        }
        booking = new JFrame();
        booking.setTitle("Customer Bookings");
        booking.setSize(1000, 500);
        booking.setLocation(700, 300);
        booking.setLayout(new BorderLayout());
        Panel button = new Panel();
        button.add(approve_all_booking);
        button.add(approve_booking);
        button.add(reject_booking);
        JTable table = new JTable(book, column);
        table.setBackground(Color.LIGHT_GRAY);
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        booking.add(scroll, BorderLayout.CENTER);
        booking.add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        if (e.getSource() == approve_all_booking) {
            approve_all_bookings();
            booking.setVisible(false);
            Main.adminpage.getJFrame().setVisible(true);
            JOptionPane.showMessageDialog(booking, "Bookings Approved!");

        } else if (e.getSource() == reject_booking) {
            String input = JOptionPane.showInputDialog("Enter the Booking ID");
            int id = Integer.parseInt(input);
            reject_bookings(id);
            booking.setVisible(false);
            Main.adminpage.getJFrame().setVisible(true);
            JOptionPane.showMessageDialog(booking, "Booking Rejected!");

        } else if (e.getSource() == approve_booking) {
            String input = JOptionPane.showInputDialog("Enter the Booking ID");
            int id = Integer.parseInt(input);
            accept_booking(id);
            booking.setVisible(false);
            Main.adminpage.getJFrame().setVisible(true);
            JOptionPane.showMessageDialog(booking, "Booking Approved!");


        }
        }catch(Exception ex){
                        JOptionPane.showMessageDialog(booking, "Invalid Input!");
        }
    }
    public void approve_all_bookings(){
        for (Book b: BookDataIO.allBooks){
            if (b.getBookStatus().equals("Pending")){
                b.setBookStatus("Approved");
                b.getBookedCar().setStatus("Booked");
            }
        }
        CarDataIO.writeToFile();
        BookDataIO.writeToFile();
    }

    public void reject_bookings(int book_id){
        for (Book b: BookDataIO.allBooks){
            if (b.getBookingID() == book_id){
                b.setBookStatus("Rejected");
                b.getBookedCar().setStatus("Available");

            }
        }
        CarDataIO.writeToFile();
        BookDataIO.writeToFile();

    }

    public void accept_booking(int book_id){
        for (Book b: BookDataIO.allBooks){
            if (b.getBookingID() == book_id){
                b.setBookStatus("Approved");
                b.getBookedCar().setStatus("Booked");
            }
        }
        CarDataIO.writeToFile();
        BookDataIO.writeToFile();

    }

    public JFrame getJFrame(){
        return booking;
    }

}
