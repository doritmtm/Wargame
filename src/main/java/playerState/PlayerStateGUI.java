package playerState;



import javax.swing.*;
import java.awt.*;

public class PlayerStateGUI extends JFrame {
    private JLabel username=new JLabel("Welcome doritmtm!");
    private JLabel gold=new JLabel("Gold:256");
    private JLabel totalAttack=new JLabel("Total attack points:256");
    private JLabel totalDefense=new JLabel("Total defense points:256");
    private JLabel totalArmy=new JLabel("Number of troops:256");
    private JLabel reports=new JLabel("Reports:");
    private JTable army=new JTable(3,3);
    private JTable reportsTable=new JTable(20,2);
    private JScrollPane armyScroll=new JScrollPane(army);
    private JScrollPane reportsScroll=new JScrollPane(reportsTable);
    private JButton attack=new JButton("Attack Player");
    private JButton recruit=new JButton("Recruit Troops");
    public PlayerStateGUI()
    {
        setTitle("Player State"); //to add player name in title
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024,700);
        initPositions();
        initGUIElements();;
        addToWindow();
        setVisible(true);

    }

    public void initPositions()
    {
        username.setBounds(20,10,200,50);
        gold.setBounds(35,25,200,50);
        totalAttack.setBounds(50,60,200,50);
        totalDefense.setBounds(250,60,200,50);
        totalArmy.setBounds(450,60,200,50);
        reports.setBounds(700,60,200,50);
        armyScroll.setBounds(50,100,500,100);
        reportsScroll.setBounds(700,100,200,700);
        attack.setBounds(150,200,300,70);
        recruit.setBounds(150,300,300,70);
    }
    public void initGUIElements()
    {
        army.setEnabled(false);
        army.getColumnModel().getColumn(0).setHeaderValue("BYSBSU");
        army.setValueAt("AVVSV",1,1);
        reportsTable.setEnabled(false);
        army.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        armyScroll.setBorder(BorderFactory.createEmptyBorder());
        reportsTable.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        reportsScroll.setBorder(BorderFactory.createEmptyBorder());
        attack.setFont(new Font("arial",Font.PLAIN,20));
        recruit.setFont(new Font("arial",Font.PLAIN,20));
    }
    public void addToWindow()
    {
        add(username);
        add(gold);
        add(totalAttack);
        add(totalDefense);
        add(totalArmy);
        add(reports);
        add(reportsScroll);
        add(armyScroll);
        add(attack);
        add(recruit);
    }
    public static void main(String argv[])
    {
        PlayerStateGUI p=new PlayerStateGUI();

    }
}
