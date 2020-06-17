package banPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class BanPlayerGUI extends JFrame {
    private JButton confirmButton = new JButton("Confirm");
    private JLabel nameLabel = new JLabel(("USERNAME:"));
    private JLabel reasonLabel = new JLabel("BANNED FOR:");
    private JTextField nameField = new JTextField();
    private JTextArea reasonArea = new JTextArea();

    public void initPositions()
    {
        confirmButton.setBounds(125,190,120,37);
        nameField.setBounds(125,60,120,25);
        reasonArea.setBounds(280, 60,200,167);
        nameLabel.setBounds(125,30,120,25);
        reasonLabel.setBounds(280,30,200,25);
    }
    public void setProperties()
    {
        setTitle("Ban a player");
        setResizable(false);
        setSize(600,300);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nameField.setFont(new Font("arial",Font.PLAIN,15));
        reasonArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        reasonArea.setFont(new Font("arial",Font.PLAIN,15));
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);

        confirmButton.setFont(new Font("arial",Font.BOLD,15));
        addComponents();
        setVisible(true);
    }

    public void addComponents()
    {
        initPositions();
        add(confirmButton);
        add(nameField);
        add(reasonArea);
        add(nameLabel);
        add(reasonLabel);
    }
    public static void main(String[] args)
    {
        BanPlayerGUI bpg = new BanPlayerGUI();
        bpg.setProperties();
    }
}
