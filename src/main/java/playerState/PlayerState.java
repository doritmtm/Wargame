package playerState;

import model.Battle;
import model.Troop;

import javax.swing.*;

public class PlayerState {
    public static void main(String argv[])
    {
        PlayerStateGUI pgui=new PlayerStateGUI();
        PlayerStateWriter pw=new PlayerStateWriter();
        pw.updatePlayerState("dars",new Battle(false,"CosMar"));
        pw.updatePlayerState("dars",new Troop("Archers",10,5,200));
        pw.updatePlayerState("doritmtm",new Battle(false,"CosMar"));
        pw.updatePlayerState("doritmtm",new Battle(true,"Th3BArBarIAN"));

        pw.updatePlayerState("doritmtm",new Troop("Archers",10,5,200));
        PlayerStateController pc=new PlayerStateController(pgui);
        pgui.setVisible(true);
        pc.updateGUIWithPlayer("doritmtm");
    }
}
