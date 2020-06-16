package listPlayers;
import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame{
    private JButton listButton = new JButton("List players");
    private JButton banButton = new JButton("Ban a player");
    private JButton seekButton = new JButton("Follow a player");
    private JLabel titleLabel = new JLabel("Administration");

    public void initPositions()
    {
        listButton.setBounds(230, 170,180,40);
        seekButton.setBounds(230,230,180,40);
        banButton.setBounds(230,290,180,40);
        titleLabel.setBounds(210,62,400,60);
    }

    public void setProperties()
    {
        setTitle("Admin");

        setSize(640, 480);
        setResizable(false);
        setBackground(Color.GRAY);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        listButton.setBackground(Color.LIGHT_GRAY);
        listButton.setFont(new Font("arial",Font.BOLD,15));

        seekButton.setBackground(Color.LIGHT_GRAY);
        seekButton.setFont(new Font("arial",Font.BOLD,15));

        banButton.setBackground(Color.LIGHT_GRAY);
        banButton.setFont(new Font("arial",Font.BOLD,15));

        titleLabel.setFont(new Font("calibri",Font.BOLD,35));

        setVisible(true);
    }

    public void addComponents()
    {
        initPositions();
        add(listButton);
        add(seekButton);
        add(banButton);
        add(titleLabel);
    }

    public AdminGUI()
    {

        addComponents();
        setProperties();

    }
    public static void main (String[] args)
    {
        AdminGUI lpg = new AdminGUI();
    }

}
