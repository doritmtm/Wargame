package playerState;

import model.Battle;
import model.Troop;

import javax.swing.*;
import java.util.ArrayList;

public class PlayerState {
    private PlayerStateGUI pgui=new PlayerStateGUI();
    private PlayerStateWriter pw=new PlayerStateWriter();
    private PlayerStateController pc;
    private static ArrayList<Troop> initTroops;
    public PlayerState(String user)
    {
        pc=new PlayerStateController(pgui,user);
        pc.updateGUIWithPlayer(user);
        pgui.setVisible(true);
    }
    public static ArrayList<Troop> getInitTroops()
    {
        return initTroops;
    }
    public static void setInitTroops(ArrayList<Troop> initTroops)
    {
        PlayerState.initTroops=initTroops;
    }
    public static void main(String argv[])
    {
        ArrayList<Troop> iniTroops=new ArrayList<Troop>();
        iniTroops.add(new Troop("Archer",12,8,20));
        iniTroops.add(new Troop("Spearman",8,15,25));
        iniTroops.add(new Troop("Soldier",10,10,15));
        iniTroops.add(new Troop("Axeman",10,15,30));
        iniTroops.add(new Troop("Knight",20,30,60));
        PlayerState.setInitTroops(iniTroops);
        PlayerState ps1=new PlayerState("doritmtm");
    }

    public PlayerStateGUI getPgui() {
        return pgui;
    }

    public void setPgui(PlayerStateGUI pgui) {
        this.pgui = pgui;
    }
}
