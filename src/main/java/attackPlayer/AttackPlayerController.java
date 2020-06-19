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
    private final int NR_OF_OPPONENTS=3;
    private AttackPlayerGUI atpgui;
    private PlayerStateController psc;
    private ArrayList<String> opponents=new ArrayList<String>();
    private ArrayList<Integer> opponentsDefense=new ArrayList<Integer>();
    private int[] rand=new int[NR_OF_OPPONENTS];
    public AttackPlayerController(AttackPlayerGUI atpgui,PlayerStateController psc)
    {
        this.atpgui=atpgui;
        this.psc=psc;

    }
    public void findOpponents(String user) throws PlayerNotLoadedException {
        ArrayList<PlayerStateLoader> apl=PlayerStateLoader.loadAllUsers();
        PlayerStateLoader pl=new PlayerStateLoader(user);
        PlayerStateLoader pl2;
        int ta,td;
        int i,j;
        boolean ok=false;
        ta=pl.getTotalAttack();
        if(apl!=null) {
            Iterator<PlayerStateLoader> it = apl.iterator();
            while (it.hasNext()) {
                pl2 = it.next();
                td = pl2.getTotalDefense();
                if (ta - 300 <= td && td <= ta + 300) {
                    if (!pl.getUsername().equals(pl2.getUsername())) {
                        opponents.add(pl2.getUsername());
                        opponentsDefense.add(td);
                    }
                }
            }
            if (opponents.isEmpty()) {
                it = apl.iterator();
                while (it.hasNext()) {
                    pl2 = it.next();
                    td = pl2.getTotalDefense();
                    if (!pl.getUsername().equals(pl2.getUsername())) {
                        opponents.add(pl2.getUsername());
                        opponentsDefense.add(td);
                    }
                }
            }
            if(opponents.size()>NR_OF_OPPONENTS)
            {
                for (i = 0; i < NR_OF_OPPONENTS ; i++)
                {
                    ok=false;
                    while(!ok)
                    {
                        ok=true;
                        rand[i]=(int) Math.floor(Math.random()*opponents.size());
                        for(j=0;j<i;j++)
                        {
                            if(rand[j]==rand[i])
                            {
                                ok=false;
                            }
                        }
                    }
                }
            }
            else
            {
                for(i=0;i<opponents.size();i++)
                {
                    rand[i]=i;
                }
            }
        }
    }

    public void updateGUIWithPlayer(String user) throws PlayerNotLoadedException
    {
        PlayerStateLoader pl=new PlayerStateLoader(user);
        atpgui.getPower().setText("Your army attack power:"+pl.getTotalAttack());
        atpgui.getOpponentsChoose().removeAllItems();
        atpgui.getAttack().addActionListener(new AttackAction(user,this));
        findOpponents(user);
        int i;
        for(i=0;i<opponents.size() && i<NR_OF_OPPONENTS;i++)
        {
            atpgui.getOpponentsChoose().addItem(opponents.get(i));
            atpgui.getOpponents().setValueAt(opponents.get(i),i,0);
            atpgui.getOpponents().setValueAt(opponentsDefense.get(i),i,1);
        }
    }

    public AttackPlayerGUI getAtpgui() {
        return atpgui;
    }

    public PlayerStateController getPsc() {
        return psc;
    }
}
