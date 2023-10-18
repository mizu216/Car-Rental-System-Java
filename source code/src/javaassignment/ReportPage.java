package javaassignment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReportPage {
    private JFrame report;

    private Panel rp1, rp2, rp3, rp4 ,rp5;

    private Label title, age, gender;

    public ReportPage(){
        ArrayList<Integer> allAge = new ArrayList<Integer>();
        int male = 0;
        int female = 0;
        int avg_age, min_age, max_age;
        for (Customer c : CustomerDataIO.allCustomers) {
            if (c.getGender().equals("Male")) {
                male += 1;
            } else if (c.getGender().equals("Female")) {
                female += 1;
            }
            allAge.add(c.getAge());
        }
        avg_age = find_mean(allAge);
        min_age = find_min(allAge);
        max_age = find_max(allAge);
        report = new JFrame();

        report.setSize(850, 450);
        report.setLocation(700, 300);
        report.setLayout(new GridLayout(5, 1));
        title = new Label("Statistical Report", Label.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        age = new Label("Age", Label.CENTER);
        gender = new Label("Gender", Label.CENTER);
        age.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        gender.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        rp1 = new Panel();
        rp2 = new Panel();
        rp3 = new Panel();
        rp4 = new Panel();
        rp5 = new Panel();
        rp1.add(title);
        rp2.add(age);
        rp3.add(gender);
        Label age_label = new Label("Average Age: " + avg_age + " minimum age: " + min_age + " maximum age: " + max_age);
        rp4.add(age_label);
        Label gender_label = new Label("Male: " + male + " Female: " + female);
        rp5.add(gender_label);
        report.getContentPane().setBackground(new Color(206, 172, 145));
        report.setTitle("Report");
        report.add(rp1);
        report.add(rp2);
        report.add(rp4);
        report.add(rp3);
        report.add(rp5);
    }

    public int find_mean(ArrayList<Integer> age) {
        int num = age.size();
        int ans;
        ans = 0;
        for (int i : age) {
            ans = ans + i;
        }
        return ans / num;
    }

    public int find_max(ArrayList<Integer> age) {
        int max = age.get(0);
        int i = 1;
        while (i < age.size()) {
            if (age.get(i) > max) {
                max = age.get(i);
            }
            i += 1;
        }
        return max;
    }

    public int find_min(ArrayList<Integer> age) {
        int min = age.get(0);
        int i = 1;
        while (i < age.size()) {
            if (age.get(i) < min) {
                min = age.get(i);
            }
            i += 1;
        }
        return min;

    }

    public JFrame getJFrame(){
        return report;
    }
}
