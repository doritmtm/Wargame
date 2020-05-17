package recruitTroops;

import model.Troop;
import playerState.PlayerStateController;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import recruitTroops.actions.MakePurchaseAction;
import recruitTroops.guiAddons.TroopTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class RecruitTroopsController {
    private RecruitTroopsGUI gui;
    private PlayerStateController psc;
    public RecruitTroopsController(RecruitTroopsGUI gui, PlayerStateController psc)
    {
        this.gui=gui;
        this.psc=psc;
    }

    public void updateGUIWithUser(String user)
    {
        PlayerStateLoader pl=new PlayerStateLoader(user);
        ArrayList<TroopTable> troopTableList=new ArrayList<TroopTable>();
        ArrayList<Troop> troops=pl.getTroops();
        Iterator<Troop> it=troops.iterator();
        TroopTable tt;
        Troop t;
        int i=0;
        while(it.hasNext())
        {
            t=it.next();
            tt=new TroopTable();
            tt.getType().setText(t.getType());
            tt.getAttack().setText("Attack points:"+t.getAttack());
            tt.getDefense().setText("Defense points:"+t.getDefense());
            tt.getCost().setText("Gold cost per troop:"+t.getCost());
            tt.getBuyButton().addActionListener(new MakePurchaseAction(gui,tt,user,i,psc));
            tt.setBounds(0,i*250,600,200);
            gui.getTroopScroll().add(tt);
            troopTableList.add(tt);
            i++;
        }
        gui.setTroopTableList(troopTableList);
        gui.getTroopScroll().setPreferredSize(new Dimension(500,i*250));
        gui.getGold().setText("Gold:"+pl.getGold());
    }
}
