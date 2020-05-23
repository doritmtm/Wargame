package login;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame{
    private JButton buttonLogin = new JButton("Login");
    private JLabel labelUser = new JLabel("Username");
    private JLabel labelPass = new JLabel("Password");
    private JLabel labelTitle = new JLabel(("Wargame"));
    private JTextField fieldUser = new JTextField();
    private JPasswordField fieldPass = new JPasswordField();

    public LoginGUI()
    {
        addToWindow();
        setProperties();
    }

    public void initPositions()
    {
        buttonLogin.setBounds(187,245,120,30);
        labelUser.setBounds(110,60,100,100);
        labelPass.setBounds(110,115,100,100);
        labelTitle.setBounds(180,8,180,60);
        fieldUser.setBounds(187,95,200,30);
        fieldPass.setBounds(187, 150, 200, 30);
    }

    public void setProperties()
    {
        setTitle("Login");
        setSize(500,400);
        setResizable(false);
        setBackground(Color.GRAY);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonLogin.setBackground(Color.LIGHT_GRAY);
        buttonLogin.setFont(new Font("arial", Font.BOLD, 13));

        labelPass.setFont(new Font("arial", Font.BOLD, 15));
        labelUser.setFont(new Font("arial", Font.BOLD, 15));
        labelTitle.setFont(new Font("calibri",Font.BOLD, 35));

        fieldUser.setFont(new Font("arial", Font.PLAIN, 18));
        fieldUser.setForeground(new Color(0,120,0,255));
        fieldUser.setHorizontalAlignment(SwingConstants.CENTER);
        
        fieldPass.setFont(new Font("arial", Font.PLAIN, 18));
        fieldPass.setHorizontalAlignment(SwingConstants.CENTER);
        fieldPass.setForeground(new Color(0,120,0,255));
        fieldPass.setEchoChar('*');

        setVisible(true);
    }

    public void addToWindow()
    {
        initPositions();
        add(buttonLogin);
        add(labelPass);
        add(labelUser);
        add(labelTitle);
        add(fieldPass);
        add(fieldUser);
    }

    public static void main(String[] args)
    {
        LoginGUI l = new LoginGUI();

    }
}
