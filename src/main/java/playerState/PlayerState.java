package playerState;

import model.Battle;
import model.Troop;

import javax.swing.*;

public class PlayerState {
    private JFrame window=new JFrame("Player State"); //to put player name in title
    public static void main(String argv[])
    {
        PlayerStateGUI pgui=new PlayerStateGUI();
        PlayerStateWriter pw=new PlayerStateWriter();
        pw.updatePlayerState("dars",new Battle(false,"CosMar"));
        pw.updatePlayerState("dars",new Troop("Archers",10,5,200));
    }
}
