package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Util.FontLoader;

public class SelectionFrame extends JFrame implements ActionListener{
    JButton domesticBtn, internationalBtn;
    JLabel mainTitle, label, domesticImg, internationalImg;

    public SelectionFrame(){
        setTitle("Bangladesh Airlines Reservation Portal");
        setSize(500, 350);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        mainTitle = new JLabel("Bangladesh Airlines Reservation Portal", SwingConstants.CENTER);
        mainTitle.setBounds(0, 10, 500, 30);
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setFont(FontLoader.montserratBold);
        add(mainTitle);

        label = new JLabel("Choose Flight Type:");
        label.setFont(FontLoader.montserratPlain);
        label.setForeground(Color.WHITE);
        label.setBounds(160, 50, 200, 30);
        add(label);

        domesticBtn = new JButton("Domestic");
        domesticBtn.setBounds(80, 240, 150, 30);
        domesticBtn.setBackground(new Color(0x5b12a9));
        domesticBtn.setForeground(Color.WHITE);
        domesticBtn.setFont(FontLoader.montserratPlain);
        domesticBtn.addActionListener(this);
        add(domesticBtn);

        internationalBtn = new JButton("International");
        internationalBtn.setBounds(260, 240, 150, 30);
        internationalBtn.setBackground(new Color(0x5b12a9));
        internationalBtn.setForeground(Color.WHITE);
        internationalBtn.setFont(FontLoader.montserratPlain);
        internationalBtn.addActionListener(this);
        add(internationalBtn);

        domesticImg = new JLabel(new ImageIcon("Pic/domestic.jpg"));
        domesticImg.setBounds(80, 90, 150, 140);
        add(domesticImg);

        internationalImg = new JLabel(new ImageIcon("Pic/international.jpg"));
        internationalImg.setBounds(260, 90, 150, 140);
        add(internationalImg);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == domesticBtn){
            new FlightOptionsFrame("Domestic");

        } else if (e.getSource() == internationalBtn){
            new FlightOptionsFrame("International");
        }
        dispose();
    }
}