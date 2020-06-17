package listPlayers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ListPlayersGUI extends JFrame{
    private JTable playersTable = new JTable(28, 2);
    private JScrollPane playersScroll = new JScrollPane(playersTable);
    private JLabel playersLabel = new JLabel("Players");

    public ListPlayersGUI()
    {
        setProperties();
        addComponents();
    }
    public void setProperties()
    {
        setSize(400, 640);
        setTitle("Players");
        setResizable(false);
        setBackground(Color.GRAY);
        setLayout(null);
        playersTable.setEnabled(false);
        playersTable.getColumnModel().getColumn(0).setHeaderValue("Username");
        playersTable.getColumnModel().getColumn(1).setHeaderValue("Banned?");
        playersTable.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        playersTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
        playersTable.setRowHeight(20);
        playersScroll.setBorder(BorderFactory.createEmptyBorder());
        playersLabel.setFont(new Font("calibri",Font.BOLD,35));

        setVisible(true);
    }

    public void initPositions()
    {
        playersScroll.setBounds(100, 80, 200, 500);
        playersLabel.setBounds(140, 20, 400 ,40);
    }

    public void addComponents()
    {
        initPositions();
        add(playersLabel);
        add(playersScroll);

    }

    public JTable getPlayersTable() {
        return playersTable;
    }

    public void setPlayersTable(JTable playersTable) {
        this.playersTable = playersTable;
    }

    public JScrollPane getPlayersScroll() {
        return playersScroll;
    }

    public void setPlayersScroll(JScrollPane playersScroll) {
        this.playersScroll = playersScroll;
    }

    public JLabel getPlayersLabel() {
        return playersLabel;
    }

    public void setPlayersLabel(JLabel playersLabel) {
        this.playersLabel = playersLabel;
    }
}
