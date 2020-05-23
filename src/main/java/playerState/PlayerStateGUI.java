package playerState;



import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PlayerStateGUI extends JFrame {
    private JLabel username=new JLabel("Welcome doritmtm!");
    private JLabel gold=new JLabel("Gold:256");
    private JLabel totalAttack=new JLabel("Total attack points:256");
    private JLabel totalDefense=new JLabel("Total defense points:256");
    private JLabel totalArmy=new JLabel("Number of troops:256");
    private JLabel reports=new JLabel("Reports:");
    private JLabel armyInfo1=new JLabel("Troop amount:");
    private JLabel armyInfo2=new JLabel("Troop attack:");
    private JLabel armyInfo3=new JLabel("Troop defense:");
    private JTable army=new JTable(3,PlayerState.getInitTroops().size());
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
        setSize(1024,600);
        initPositions();
        initGUIElements();;
        addToWindow();

    }

    public void initPositions()
    {
        username.setBounds(20,10,200,50);
        gold.setBounds(35,25,200,50);
        totalAttack.setBounds(150,60,200,50);
        totalDefense.setBounds(350,60,200,50);
        totalArmy.setBounds(550,60,200,50);
        reports.setBounds(780,60,200,50);
        armyScroll.setBounds(150,100,500,130);
        reportsScroll.setBounds(780,100,200,700);
        attack.setBounds(250,250,300,70);
        recruit.setBounds(250,350,300,70);
        armyInfo1.setBounds(52,110,100,50);
        armyInfo2.setBounds(55,140,100,50);
        armyInfo3.setBounds(50,170,100,50);
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
        reportsTable.getColumnModel().getColumn(0).setHeaderValue("Victorious?");
        reportsTable.getColumnModel().getColumn(1).setHeaderValue("Opponent");
        army.setRowHeight(30);
        reportsTable.setRowHeight(20);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        army.setDefaultRenderer(Object.class,centerRenderer);
        reportsTable.setDefaultRenderer(Object.class,centerRenderer);
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
        add(armyInfo1);
        add(armyInfo2);
        add(armyInfo3);
    }

    public JLabel getUsername() {
        return username;
    }

    public JLabel getGold() {
        return gold;
    }

    public JLabel getTotalAttack() {
        return totalAttack;
    }

    public JLabel getTotalDefense() {
        return totalDefense;
    }

    public JLabel getTotalArmy() {
        return totalArmy;
    }

    public JLabel getReports() {
        return reports;
    }

    public JTable getArmy() {
        return army;
    }

    public JTable getReportsTable() {
        return reportsTable;
    }

    public JScrollPane getArmyScroll() {
        return armyScroll;
    }

    public JScrollPane getReportsScroll() {
        return reportsScroll;
    }

    public JButton getAttack() {
        return attack;
    }

    public JButton getRecruit() {
        return recruit;
    }
}
