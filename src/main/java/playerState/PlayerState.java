package playerState;

import model.Battle;
import model.Troop;

import javax.swing.*;

public class PlayerState {
    private PlayerStateGUI pgui=new PlayerStateGUI();
    private PlayerStateWriter pw=new PlayerStateWriter();
    private PlayerStateController pc=new PlayerStateController(pgui);
    public PlayerState(String user)
    {
        pw.updatePlayerState("dars",new Battle(false,"CosMar"));
        pw.updatePlayerState("dars",new Troop("Archers",10,5,20,200));
        pw.updatePlayerState("doritmtm",new Battle(false,"CosMar"));
        pw.updatePlayerState("doritmtm",new Battle(true,"Th3BArBarIAN"));

        pw.updatePlayerState("doritmtm",new Troop("Archers",10,5,20,200));

        pgui.setVisible(true);
        pc.updateGUIWithPlayer(user);
    }
    public static void main(String argv[])
    {
        PlayerState ps=new PlayerState("doritmtm");

    }
}
