package attackPlayer;

import playerState.PlayerStateController;
import playerState.exceptions.PlayerNotLoadedException;

public class AttackPlayer {
    private AttackPlayerGUI atpgui;
    private AttackPlayerController atpc;
    private String user;
    private PlayerStateController psc;
    public AttackPlayer(String user,PlayerStateController psc)
    {
        this.user=user;
        this.psc=psc;
        atpgui=new AttackPlayerGUI();
        atpc=new AttackPlayerController(atpgui,psc);
        try {
            atpc.updateGUIWithPlayer(user);
        } catch (PlayerNotLoadedException e) {
            e.printStackTrace();
        }
        atpgui.setVisible(true);
    }
}
