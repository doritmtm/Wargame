package playerState;

import model.Battle;
import model.Troop;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerStateController {
    private PlayerStateGUI gui;
    public PlayerStateController(PlayerStateGUI gui) {
        this.gui = gui;
    }
    public void updateGUIWithPlayer(String user)
    {
        PlayerStateLoader pl=new PlayerStateLoader(user);
        gui.setTitle(user+"'s Player State");
        gui.getUsername().setText("Welcome "+user+"!");
        gui.getGold().setText("Gold:"+pl.getGold());
        ArrayList<Troop> troops=pl.getTroops();
        Iterator<Troop> it=troops.iterator();
        int tattack=0,tdefense=0,tcount=0;
        int i=0;
        Troop t;
        while(it.hasNext())
        {
            t=it.next();
            tattack+=t.getAttack()*t.getCount();
            tdefense+=t.getDefense()*t.getCount();
            tcount+=t.getCount();
            gui.getArmy().getColumnModel().getColumn(i).setHeaderValue(t.getType());
            gui.getArmy().setValueAt(t.getCount(),0,i);
            gui.getArmy().setValueAt(t.getAttack(),1,i);
            gui.getArmy().setValueAt(t.getDefense(),2,i);
            i++;
        }
        gui.getTotalAttack().setText("Total attack points:"+tattack);
        gui.getTotalDefense().setText("Total defense points:"+tdefense);
        gui.getTotalArmy().setText("Number of troops:"+tcount);
        Iterator<Battle> ib;
        ArrayList<Battle> battles=pl.getBattles();
        ib=battles.iterator();
        Battle b;
        i=0;
        while(ib.hasNext())
        {
            b=ib.next();
            if(b.isVictorious())
            {
                gui.getReportsTable().setValueAt("Victorious!",i,0);
            }
            else
            {
                gui.getReportsTable().setValueAt("Defeated!",i,0);
            }
            gui.getReportsTable().setValueAt(b.getOpponent(),i,1);
            i++;
        }
    }
}
