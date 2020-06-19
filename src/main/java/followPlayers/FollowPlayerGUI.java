package followPlayers;
import javax.swing.*;



public class FollowPlayerGUI extends JFrame{

    private JButton seekButton = new JButton("Follow");
    private JLabel nameLabel = new JLabel("Player:");
    private JTextField nameField = new JTextField();


    public FollowPlayerGUI()
    {
        addComponents();
        setProperties();
    }

    public void initPositions()
    {
        seekButton.setBounds(100,150,100,20);
        nameField.setBounds(75, 80, 150,20);
        nameLabel.setBounds(75,50,100,20);
    }

    public void setProperties()
    {
        setSize(300, 300);
        setLayout(null);
        setResizable(false);
        setTitle("Seek");
        addComponents();
        setVisible(true);
    }

    public void addComponents()
    {
        initPositions();
        add(seekButton);
        add(nameField);
        add(nameLabel);
    }

    public JButton getSeekButton() {
        return seekButton;
    }

    public void setSeekButton(JButton seekButton) {
        this.seekButton = seekButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }
}
