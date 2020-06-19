package attackPlayer.actions;

import attackPlayer.AttackPlayerController;
import model.Battle;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import playerState.exceptions.PlayerNotLoadedException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AttackAction implements ActionListener {
    private String user1;
    private String user2;
    private AttackPlayerController apc;

    public AttackAction(String user1, AttackPlayerController apc) {
        this.user1 = user1;
        this.apc = apc;
    }
    public void computeAttack(String user1,String user2)
    {
        PlayerStateLoader pl1=new PlayerStateLoader(user1);
        PlayerStateLoader pl2=new PlayerStateLoader(user2);
        PlayerStateWriter pw=new PlayerStateWriter();

        try {
            double chanceToWin=(((double)pl1.getTotalAttack()-(double)pl2.getTotalDefense())/(double)pl1.getTotalAttack())*500+50.0;
            if(chanceToWin>100.0)
            {
                chanceToWin = 100.0;
            }
            if(chanceToWin<0.0)
            {
                chanceToWin=0.0;
            }
            double rand;
            rand=Math.random()*100;
            if(rand<=chanceToWin)
            {
                pw.updatePlayerStateGold(user1,pl1.getGold()+1000);
                pw.updatePlayerStateGold(user2,pl2.getGold()+500);
                pw.updatePlayerState(user1,new Battle(true,user2));
                pw.updatePlayerState(user2,new Battle(false,user1));
            }
            else
            {
                pw.updatePlayerStateGold(user1,pl1.getGold()+500);
                pw.updatePlayerStateGold(user2,pl2.getGold()+1000);
                pw.updatePlayerState(user1,new Battle(false,user2));
                pw.updatePlayerState(user2,new Battle(true,user1));
            }
        } catch (PlayerNotLoadedException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        user2=(String)apc.getAtpgui().getOpponentsChoose().getSelectedItem();
        computeAttack(user1,user2);
        apc.getAtpgui().dispatchEvent(new WindowEvent(apc.getAtpgui(),WindowEvent.WINDOW_CLOSING));
        apc.getPsc().updateGUIWithPlayer(user1);
    }
}
