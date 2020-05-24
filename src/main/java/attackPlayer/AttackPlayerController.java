package attackPlayer;

import attackPlayer.actions.AttackAction;
import playerState.PlayerStateController;
import playerState.PlayerStateLoader;
import playerState.exceptions.PlayerNotLoadedException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class AttackPlayerController {
    private AttackPlayerGUI atpgui;
    private PlayerStateController psc;
    public AttackPlayerController(AttackPlayerGUI atpgui,PlayerStateController psc)
    {
        this.atpgui=atpgui;
        this.psc=psc;

    }
    public void calcConflict(String user1,String user2)
    {

    }
    public void updateGUIWithPlayer(String user) throws PlayerNotLoadedException {
        ArrayList<PlayerStateLoader> apl=PlayerStateLoader.loadAllUsers();
        ArrayList<String> opponents=new ArrayList<String>();
        ArrayList<Integer> opponentsDefense=new ArrayList<Integer>();
        PlayerStateLoader pl=new PlayerStateLoader(user);
        atpgui.getPower().setText("Your army attack power:"+pl.getTotalAttack());
        PlayerStateLoader pl2;
        int ta,td;
        int rand1=0,rand2=0,rand3=0,i;
        ta=pl.getTotalAttack();
        atpgui.getOpponentsChoose().removeAllItems();
        if(apl!=null)
        {
            Iterator<PlayerStateLoader> it=apl.iterator();
            while(it.hasNext())
            {
                pl2=it.next();
                td=pl2.getTotalDefense();
                if(ta-300<=td && td<=ta+300)
                {
                    if(!pl.getUsername().equals(pl2.getUsername()))
                    {
                        opponents.add(pl2.getUsername());
                        opponentsDefense.add(td);
                    }
                }
            }
            if(opponents.isEmpty())
            {
                it=apl.iterator();
                while(it.hasNext())
                {
                    pl2=it.next();
                    td=pl2.getTotalDefense();
                    if(!pl.getUsername().equals(pl2.getUsername()))
                    {
                        opponents.add(pl2.getUsername());
                        opponentsDefense.add(td);
                    }
                }


                if(opponents.size()>3)
                {


                    rand1=(int) Math.floor(Math.random()*opponents.size());
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand1));
                    atpgui.getOpponents().setValueAt(opponents.get(rand1),0,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand1),0,1);
                    while(rand1==rand2 || rand1==rand3 || rand2==rand3)
                    {
                        rand2=(int) Math.floor(Math.random()*opponents.size());
                        rand3=(int) Math.floor(Math.random()*opponents.size());
                    }
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand2));
                    atpgui.getOpponents().setValueAt(opponents.get(rand2),1,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand2),1,1);
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand3));
                    atpgui.getOpponents().setValueAt(opponents.get(rand3),2,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand3),2,1);
                }
                else
                {
                    for(i=0;i<opponents.size();i++)
                    {
                        atpgui.getOpponentsChoose().addItem(opponents.get(i));
                        atpgui.getOpponents().setValueAt(opponents.get(i),i,0);
                        atpgui.getOpponents().setValueAt(opponentsDefense.get(i),i,1);
                    }
                }
            }
            else
            {
                if(opponents.size()<=3)
                {
                    for(i=0;i<opponents.size();i++)
                    {
                        atpgui.getOpponentsChoose().addItem(opponents.get(i));
                        atpgui.getOpponents().setValueAt(opponents.get(i),i,0);
                        atpgui.getOpponents().setValueAt(opponentsDefense.get(i),i,1);
                    }
                }
                else
                {
                    rand1=(int) Math.floor(Math.random()*opponents.size());
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand1));
                    atpgui.getOpponents().setValueAt(opponents.get(rand1),0,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand1),0,1);
                    while(rand1==rand2 || rand1==rand3 || rand2==rand3)
                    {
                        rand2=(int) Math.floor(Math.random()*opponents.size());
                        rand3=(int) Math.floor(Math.random()*opponents.size());
                    }
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand2));
                    atpgui.getOpponents().setValueAt(opponents.get(rand2),1,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand2),1,1);
                    atpgui.getOpponentsChoose().addItem(opponents.get(rand3));
                    atpgui.getOpponents().setValueAt(opponents.get(rand3),2,0);
                    atpgui.getOpponents().setValueAt(opponentsDefense.get(rand3),2,1);
                }
            }
        }
        atpgui.getAttack().addActionListener(new AttackAction(user,this));
    }

    public AttackPlayerGUI getAtpgui() {
        return atpgui;
    }

    public PlayerStateController getPsc() {
        return psc;
    }
}
