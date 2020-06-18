package recruitTroops.actions;

import model.Troop;
import playerState.PlayerStateController;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import recruitTroops.RecruitTroopsGUI;
import recruitTroops.exceptions.NotEnoughGoldException;
import recruitTroops.guiAddons.TroopTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakePurchaseAction implements ActionListener {
    private RecruitTroopsGUI gui;
    private PlayerStateController psc;
    private TroopTable tt;
    private String user;
    private int troopPos;
    private int remain;

    public MakePurchaseAction(RecruitTroopsGUI gui, TroopTable tt, String user, int troopPos,PlayerStateController psc) {
        this.gui = gui;
        this.tt = tt;
        this.user = user;
        this.troopPos = troopPos;
        this.psc=psc;
    }
    public MakePurchaseAction(String user,int troopPos)
    {
        this.user=user;
        this.troopPos=troopPos;
    }
    public void makePurchase(String user,int count) throws NotEnoughGoldException {
        PlayerStateLoader pl=new PlayerStateLoader(user);
        PlayerStateWriter pw=new PlayerStateWriter();
        int value;
        value=pl.getTroops().get(troopPos).getCost()*count;
        if(value<=pl.getGold())
        {
            remain=pl.getGold()-value;
            pw.updatePlayerStateGold(user,remain);
            Troop t=pl.getTroops().get(troopPos);
            t.setCount(t.getCount()+count);
            pw.updatePlayerState(user,t);
        }
        else
        {
            throw new NotEnoughGoldException();
        }
    }
    public void makePurchaseGUIUpdate(String user)
    {
        gui.getGold().setText("Gold:"+remain);
        psc.updateGUIWithPlayer(user);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int count;
        try
        {
            count=Integer.parseInt(tt.getBuyTextField().getText());
        }
        catch (NumberFormatException ef)
        {
            count=0;
        }
        try {
            makePurchase(user,count);
        } catch (NotEnoughGoldException notEnoughGoldException) {
            JOptionPane.showMessageDialog(null,"Not enough gold!!!");
        }
        makePurchaseGUIUpdate(user);
    }
}
