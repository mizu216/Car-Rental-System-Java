package javaassignment;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class CustomerPage implements ActionListener{
    private JFrame x,y;
    private Panel p0,p1,p2;
    private Label RD,Welcome;
    private JTable table;
    private Button profile,booking,viewbook,receipt,logout;
    public CustomerPage(){
        x = new JFrame("Customer Page");
        x.getContentPane().setBackground(Color.MAGENTA);
        x.setSize(300,150);
        x.setLocation(700,300);
        //x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profile = new Button("My Profile");
        booking = new Button("Make Booking");
        viewbook = new Button("My Booking");
        receipt = new Button("My Receipt");
        logout = new Button("Logout");
        profile.addActionListener(this);
        booking.addActionListener(this);
        viewbook.addActionListener(this);
        receipt.addActionListener(this);
        logout.addActionListener(this);
        x.setLayout(new BorderLayout());
        p1 = new Panel();
        p2 = new Panel();
        Welcome = new Label("",Label.CENTER);
        p1.add(Welcome);
        
        p2.add(profile);
        p2.add(booking);
        p2.add(viewbook);
        p2.add(receipt);
        p2.add(logout);
        x.add(p1,BorderLayout.NORTH);
        x.add(p2,BorderLayout.CENTER);
    }
    
    public JFrame getJFrame(){
        return x;
    }
    
    public Label getLabel(){
        return Welcome;
    }
    

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==profile){
                Main.customerprofilepage.getTableModel().insertRow(0, Main.loginUser.PersonalDetail());
                x.setVisible(false);
                Main.customerprofilepage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource()==booking){
                for(int i = 0;i<CarDataIO.allCars.size();i++){
                    Main.customerbookingpage.getTableModel().insertRow(i,CarDataIO.allCarDetail(i));
                }
                x.setVisible(false);
                Main.customerbookingpage.getJFrame().setVisible(true);
                }
            
            else if(e.getSource()==viewbook){
                for(int i = 0;i<Main.loginUser.getMybook().size();i++){
                    Main.customerviewbookpage.getTableModel().insertRow(i, Main.loginUser.BookingDetail(i));
                }
                x.setVisible(false);
                Main.customerviewbookpage.getJFrame().setVisible(true);
            }
            
            else if(e.getSource()==receipt){
                y = new JFrame("My Receipt");
                y.getContentPane().setBackground(Color.yellow);
                y.setLayout(new BorderLayout());
                y.setSize(1000, 500);
                y.setLocation(700, 300);
                p0 = new Panel();
                p0.setLayout(new BorderLayout());
                RD = new Label("__My Receipt__",Label.CENTER);
                RD.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
                String[] column = {"ReceiptNo", "Book Car", "Car Plate", "Pay Method", "Price"};
                table = new JTable(Main.loginUser.ReceiptDetail(),column);
                table.setEnabled(false);
                p0.add(new JScrollPane(table),BorderLayout.CENTER);
                p0.add(RD,BorderLayout.NORTH);
                y.add(p0);
                y.setVisible(true);
            }
            
            else if(e.getSource()==logout){
                Main.loginUser = null;
                x.setVisible(false);
                Main.homepage.getJFrame().setVisible(true);
            }
                
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(x,"Invalid input!!!");
            ex.printStackTrace();
        }
    }
  
    
    
    
}

