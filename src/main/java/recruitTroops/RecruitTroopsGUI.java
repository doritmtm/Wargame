package recruitTroops;

import recruitTroops.troopTable.TroopTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class RecruitTroopsGUI extends JFrame {
    private JLabel gold=new JLabel("Gold:256");
    private ArrayList<TroopTable> troopTableList=new ArrayList<TroopTable>();
    public RecruitTroopsGUI()
    {
        setTitle("Recruit Troops");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //not ok
        setSize(800,600);
        setLayout(null);
        initPositions();
        initGUIElements();;
        addToWindow();
        TroopTable tt=new TroopTable();
        tt.setBounds(100,200,600,200);
        add(tt);

    }
    public void initPositions()
    {
        gold.setBounds(35,25,200,50);
    }
    public void initGUIElements()
    {

    }
    public void addToWindow()
    {
        add(gold);
    }
}
