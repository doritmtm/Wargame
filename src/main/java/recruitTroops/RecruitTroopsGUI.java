package recruitTroops;

import recruitTroops.guiAddons.TroopTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class RecruitTroopsGUI extends JFrame {
    private JLabel gold=new JLabel("Gold:256");
    private ArrayList<TroopTable> troopTableList=new ArrayList<TroopTable>();
    private JPanel troopScroll=new JPanel();
    private JScrollPane troopScrollAux=new JScrollPane(troopScroll);
    public RecruitTroopsGUI()
    {
        setTitle("Recruit Troops");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //not ok
        setSize(800,700);
        setLayout(null);
        initPositions();
        initGUIElements();;
        addToWindow();

    }
    public void initPositions()
    {
        gold.setBounds(35,25,200,50);
        troopScrollAux.setBounds(50,100,620,500);

    }
    public void initGUIElements()
    {
        troopScroll.setLayout(null);
        troopScrollAux.getVerticalScrollBar().setUnitIncrement(10);
    }
    public void addToWindow()
    {
        add(gold);
        add(troopScrollAux);
    }

    public JLabel getGold() {
        return gold;
    }

    public ArrayList<TroopTable> getTroopTableList() {
        return troopTableList;
    }

    public JPanel getTroopScroll() {
        return troopScroll;
    }

    public void setTroopTableList(ArrayList<TroopTable> troopTableList) {
        this.troopTableList = troopTableList;
    }
}
