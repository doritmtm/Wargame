package recruitTroops.guiAddons;

import javax.swing.*;
import java.awt.*;

public class TroopTable extends JPanel {
    private JLabel type=new JLabel("Archer");
    private JLabel attack=new JLabel("Attack points:256");
    private JLabel defense=new JLabel("Defense points:256");
    private JLabel cost=new JLabel("Gold cost per troop:50");
    private JLabel buyLabel=new JLabel("Buy:");
    private JTextField buyTextField=new JTextField();
    private JButton buyButton=new JButton("Buy");

    public TroopTable()
    {
        setLayout(null);
        initPositions();
        initGUIElements();;
        addToPanel();
    }
    public void initPositions()
    {
        type.setBounds(0,0,300,200);
        attack.setBounds(300-3,0,150,50);
        defense.setBounds(450-6,0,150+6,50);
        cost.setBounds(300-3,50-3,300+3,50);
        buyLabel.setBounds(350,100,50,100);
        buyTextField.setBounds(410,135,50,30);
        buyButton.setBounds(480,135,80,30);
    }
    public void initGUIElements()
    {
        setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
        type.setFont(new Font("arial",Font.BOLD,25));
        type.setHorizontalAlignment(SwingConstants.CENTER);
        type.setVerticalAlignment(SwingConstants.CENTER);
        type.setBorder(BorderFactory.createLineBorder(Color.GRAY,5));
        attack.setHorizontalAlignment(SwingConstants.CENTER);
        attack.setVerticalAlignment(SwingConstants.CENTER);
        attack.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
        defense.setHorizontalAlignment(SwingConstants.CENTER);
        defense.setVerticalAlignment(SwingConstants.CENTER);
        defense.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
        cost.setHorizontalAlignment(SwingConstants.CENTER);
        cost.setVerticalAlignment(SwingConstants.CENTER);
        cost.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
        buyLabel.setFont(new Font("arial",Font.BOLD,20));
        buyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buyLabel.setVerticalAlignment(SwingConstants.CENTER);

    }
    public void addToPanel()
    {
        add(type);
        add(attack);
        add(defense);
        add(cost);
        add(buyLabel);
        add(buyTextField);
        add(buyButton);
    }

    public JLabel getType() {
        return type;
    }

    public JLabel getAttack() {
        return attack;
    }

    public JLabel getDefense() {
        return defense;
    }

    public JLabel getCost() {
        return cost;
    }

    public JLabel getBuyLabel() {
        return buyLabel;
    }

    public JTextField getBuyTextField() {
        return buyTextField;
    }

    public JButton getBuyButton() {
        return buyButton;
    }
}
