package attackPlayer;

import javax.swing.*;
import java.awt.*;

public class AttackPlayerGUI extends JFrame {
    private JLabel power=new JLabel("Your army attack power:256");
    private JLabel choose=new JLabel("Choose opponent:");
    private JTable opponents=new JTable(3,2);
    private JScrollPane opponentsScroll=new JScrollPane(opponents);
    private JButton attack=new JButton("Attack");
    private JComboBox opponentsChoose=new JComboBox();
    public AttackPlayerGUI()
    {
        setTitle("Attack Player");
        setLayout(null);
        setSize(600,450);
        initPositions();
        initGUIElements();
        addToWindow();
    }
    public void initPositions()
    {
        choose.setBounds(170,100,150,50);
        opponentsScroll.setBounds(150,150,250,80);
        attack.setBounds(300,250,100,50);
        opponentsChoose.setBounds(150,250,130,30);
        power.setBounds(20,20,200,50);
    }
    public void initGUIElements()
    {
        opponents.setEnabled(false);
        opponents.getColumnModel().getColumn(0).setHeaderValue("Player name");
        opponents.getColumnModel().getColumn(1).setHeaderValue("Army defense power");
        opponentsScroll.setBorder(BorderFactory.createEmptyBorder());
        opponents.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
        opponentsChoose.addItem("A");
        opponentsChoose.addItem("B");
        opponentsChoose.addItem("C");
    }
    public void addToWindow()
    {
        add(choose);
        add(opponentsScroll);
        add(attack);
        add(opponentsChoose);
        add(power);
    }

    public JLabel getPower() {
        return power;
    }

    public JLabel getChoose() {
        return choose;
    }

    public JTable getOpponents() {
        return opponents;
    }

    public JScrollPane getOpponentsScroll() {
        return opponentsScroll;
    }

    public JButton getAttack() {
        return attack;
    }

    public JComboBox getOpponentsChoose() {
        return opponentsChoose;
    }
}
