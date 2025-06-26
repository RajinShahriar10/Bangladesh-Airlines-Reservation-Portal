package GUI;

import Classes.Flight;
import Util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import FileIO.FileHandler;


public class ConfirmFrame extends JFrame implements ActionListener{

    static class Booking{
        String name;
        String passport;
        String flightClass;
        ArrayList<Flight> flights;

        Booking(String name, String passport, String flightClass, ArrayList<Flight> flights){
            this.name = name;
            this.passport = passport;
            this.flightClass = flightClass;
            this.flights = flights;
        }
    }

    JButton confirmBtn;
    ArrayList<Booking> bookings;

    public ConfirmFrame(ArrayList<Booking> bookings){
        this.bookings = bookings;

        setTitle("Booking Confirmation");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout(10, 10));

        StringBuilder sb = new StringBuilder();
        sb.append("<html><div style='text-align:center;'><h2>Booking Confirmation</h2><br>");

        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            sb.append("<b>User ").append(i + 1).append("</b><br>");
            sb.append("Name: ").append(b.name).append("<br>");
            sb.append("Passport ID: ").append(b.passport).append("<br>");
            sb.append("Class: ").append(b.flightClass).append("<br>");

            for (int j = 0; j < b.flights.size(); j++) {
                Flight f = b.flights.get(j);
                sb.append("Flight ").append(j + 1).append(": ")
                        .append(f.getFrom()).append(" → ").append(f.getTo())
                        .append(" | ").append(f.getTime()).append("<br>");
                sb.append("Fare: ").append((int) f.getFare()).append(" BDT<br>");
            }
            sb.append("<br>");
        }

        sb.append("</div></html>");

        JLabel messageLabel = new JLabel(sb.toString());
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(FontLoader.montserratPlain);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.BLACK);
        contentPanel.add(messageLabel);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Color.BLACK);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBackground(new Color(0x5b12a9));
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setFont(FontLoader.montserratPlain);
        confirmBtn.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.BLACK);
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(confirmBtn);

        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
    if (e.getSource() == confirmBtn) {
        for (Booking b : bookings) {
            FileHandler.saveBooking(b.name, b.passport, b.flightClass, b.flights);
        }

        JOptionPane.showMessageDialog(this, "Thank you for your purchase! Booking saved.");
        dispose();
    }
}

}