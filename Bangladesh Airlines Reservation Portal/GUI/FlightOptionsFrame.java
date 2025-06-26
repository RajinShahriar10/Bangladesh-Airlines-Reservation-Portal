package GUI;

import Classes.Flight;
import Util.FontLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FlightOptionsFrame extends JFrame implements ActionListener {
    JLabel fareLabel;
    JTextField nameField, passportField;
    JComboBox<Flight> flightCombo;
    JRadioButton economyRadio, businessRadio;
    JButton confirmBtn, addToCartBtn;

    Flight[] selectedFlights;
    String type;
    private static final ArrayList<ConfirmFrame.Booking> allBookings = new ArrayList<>();

    Flight[] domesticFlights = {
        new Flight("Dhaka", "Chittagong", "08:00 AM", 3500),
        new Flight("Dhaka", "Sylhet", "10:00 AM", 3000),
        new Flight("Dhaka", "Rajshahi", "01:00 PM", 3200),
        new Flight("Dhaka", "Cox's Bazar", "06:30 AM", 4500),
        new Flight("Dhaka", "Jessore", "07:15 AM", 2800),
        new Flight("Dhaka", "Barisal", "09:00 AM", 2700),
        new Flight("Dhaka", "Saidpur", "11:30 AM", 3100),
        new Flight("Dhaka", "Chittagong", "04:00 PM", 3700),
        new Flight("Dhaka", "Sylhet", "05:45 PM", 3100),
        new Flight("Dhaka", "Rajshahi", "07:00 PM", 3300)
    };

    Flight[] internationalFlights = {
        new Flight("Dhaka", "New York", "11:00 PM", 95000),
        new Flight("Dhaka", "Los Angeles", "03:00 AM", 98000),
        new Flight("Dhaka", "London", "10:00 AM", 85000),
        new Flight("Dhaka", "Paris", "01:00 PM", 87000),
        new Flight("Dhaka", "Toronto", "07:00 AM", 92000),
        new Flight("Dhaka", "Dubai", "05:00 PM", 40000),
        new Flight("Dhaka", "Doha", "08:00 AM", 35000),
        new Flight("Dhaka", "Istanbul", "06:30 PM", 70000),
        new Flight("Dhaka", "Tokyo", "04:00 AM", 90000),
        new Flight("Dhaka", "Sydney", "12:00 AM", 105000),
        new Flight("Dhaka", "Kolkata", "09:00 AM", 8000),
        new Flight("Dhaka", "Bangkok", "02:00 PM", 18000),
        new Flight("Dhaka", "Singapore", "06:00 PM", 25000)
    };

    public FlightOptionsFrame(String type) {
        this.type = type;
        if (type.equalsIgnoreCase("Domestic")) {
            this.selectedFlights = domesticFlights;
        } else {
            this.selectedFlights = internationalFlights;
        }

        setTitle("Flight Options - " + type);
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel("Bangladesh Airlines Reservation Portal", SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 500, 30);
        titleLabel.setFont(FontLoader.montserratBold);
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        nameLabel.setFont(FontLoader.montserratPlain);
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 300, 25);
        nameField.setFont(FontLoader.montserratPlain);
        add(nameField);

        JLabel passportLabel = new JLabel("Passport ID:");
        passportLabel.setBounds(50, 95, 100, 25);
        passportLabel.setFont(FontLoader.montserratPlain);
        passportLabel.setForeground(Color.WHITE);
        add(passportLabel);

        passportField = new JTextField();
        passportField.setBounds(150, 95, 300, 25);
        passportField.setFont(FontLoader.montserratPlain);
        add(passportField);

        JLabel classLabel = new JLabel("Class:");
        classLabel.setBounds(50, 130, 80, 25);
        classLabel.setFont(FontLoader.montserratPlain);
        classLabel.setForeground(Color.WHITE);
        add(classLabel);

        economyRadio = new JRadioButton("Economy", true);
        economyRadio.setBounds(130, 130, 100, 25);
        economyRadio.setFont(FontLoader.montserratPlain);
        economyRadio.setBackground(new Color(0x5b12a9));
        economyRadio.setForeground(Color.WHITE);
        add(economyRadio);

        businessRadio = new JRadioButton("Business", false);
        businessRadio.setBounds(300, 130, 100, 25);
        businessRadio.setFont(FontLoader.montserratPlain);
        businessRadio.setBackground(new Color(0x5b12a9));
        businessRadio.setForeground(Color.WHITE);
        add(businessRadio);
		
		ButtonGroup classGroup = new ButtonGroup();
		classGroup.add(economyRadio);
		classGroup.add(businessRadio);

        JLabel economyLabel = new JLabel(new ImageIcon("Pic/economy.jpg"));
        economyLabel.setBounds(130, 160, 80, 60);
        add(economyLabel);

        JLabel businessLabel = new JLabel(new ImageIcon("Pic/business.jpg"));
        businessLabel.setBounds(300, 160, 80, 60);
        add(businessLabel);

        flightCombo = new JComboBox<>();
        flightCombo.setBounds(50, 230, 380, 25);
        flightCombo.setFont(FontLoader.montserratPlain);
        add(flightCombo);

        fareLabel = new JLabel("Fare: ");
        fareLabel.setBounds(50, 270, 300, 25);
        fareLabel.setFont(FontLoader.montserratPlain);
        fareLabel.setForeground(Color.WHITE);
        add(fareLabel);

        addToCartBtn = new JButton("Add to Cart");
        addToCartBtn.setBounds(90, 320, 140, 30);
        addToCartBtn.setFont(FontLoader.montserratPlain);
        addToCartBtn.setBackground(new Color(0x5b12a9));
        addToCartBtn.setForeground(Color.WHITE);
        addToCartBtn.addActionListener(this);
        add(addToCartBtn);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(260, 320, 140, 30);
        confirmBtn.setFont(FontLoader.montserratPlain);
        confirmBtn.setBackground(new Color(0x5b12a9));
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.addActionListener(this);
        add(confirmBtn);

        economyRadio.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        updateFlightList();
		}});
		businessRadio.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        updateFlightList();
		}});
		flightCombo.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
        updateFare();
		}});


        updateFlightList();
        setVisible(true);
    }

    private void updateFare() {
        Flight selected = (Flight) flightCombo.getSelectedItem();
        if (selected != null) {
            fareLabel.setText("Fare: " + (int) selected.getFare() + " BDT");
        }
    }

    private void updateFlightList() {
    flightCombo.removeAllItems();
    boolean isBusiness = businessRadio.isSelected();

    for (Flight f : selectedFlights) {
        double fare;
        if (isBusiness) {
            fare = f.getFare() * 1.5;
        } else {
            fare = f.getFare();
        }

        String text = f.getFrom() + " → " + f.getTo() + " | " + f.getTime() + " | " + (int) fare + " BDT";

        Flight newFlight = new Flight(f.getFrom(), f.getTo(), f.getTime(), fare) {
            public String toString() {
                return text;
            }
        };

        flightCombo.addItem(newFlight);
    }

    updateFare();
}


    @Override
    public void actionPerformed(ActionEvent e){
    Object clicked = e.getSource();

    if (clicked == confirmBtn || clicked == addToCartBtn){
        String name = nameField.getText().trim();
        String passport = passportField.getText().trim();

        if (name.equals("") || passport.equals("")){
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        Flight selected = (Flight) flightCombo.getSelectedItem();
        if (selected == null) return;

        String flightClass;
        if (economyRadio.isSelected()){
            flightClass = "Economy";
        } else {
            flightClass = "Business";
        }

        ArrayList<Flight> flightList = new ArrayList<>();
        flightList.add(selected);

        ConfirmFrame.Booking booking = new ConfirmFrame.Booking(name, passport, flightClass, flightList);
        allBookings.add(booking);

        if (clicked == addToCartBtn){
            int choice = JOptionPane.showConfirmDialog(this, "Added to cart. Add another ticket?", "Cart", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION){
                new SelectionFrame();
            } else {
                new ConfirmFrame(allBookings);
            }
        } else {
            new ConfirmFrame(allBookings);
        }

        dispose();
    }
}

}
