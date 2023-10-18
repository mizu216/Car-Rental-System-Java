package javaassignment;

import javax.swing.*;
import java.awt.*;

public class FeedbackPage {

    private JFrame feedback;

    private Panel p3;

    private Label title;

    public FeedbackPage(){
        String[][] s = new String[FeedbackDataIO.allFeedbacks.size()][2];
        String[] column = {"Customer", "Feedback"};
        int i = 0;
        for (Feedback f:FeedbackDataIO.allFeedbacks){
            s[i][0] = f.getFeedbackItem().getTenant().getUsername();
            s[i][1] = f.getFeedbackMessage();
            i += 1;
        }
        feedback = new JFrame();
        feedback.setSize(1000, 500);
        feedback.setLocation(700, 300);
        feedback.setLayout(new BorderLayout());
        JTable table = new JTable(s, column);
        table.setBackground(new Color(255,182,193));
        table.setEnabled(false);
        JScrollPane scroll = new JScrollPane(table);
        title = new Label("Customer Feedback", Label.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        feedback.getContentPane().setBackground(new Color(250, 218, 221));
        feedback.setTitle("Customer Feedback");
        feedback.add(title, BorderLayout.NORTH);
        feedback.add(scroll, BorderLayout.CENTER);
    }

    public JFrame getJFrame(){
        return feedback;
    }
}
