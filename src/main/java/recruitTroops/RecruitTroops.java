package recruitTroops;

import playerState.PlayerStateController;

import javax.swing.*;

public class RecruitTroops {
       private RecruitTroopsGUI rtg=new RecruitTroopsGUI();
       private PlayerStateController psc;
       private RecruitTroopsController rtc;
       public RecruitTroops(String user,PlayerStateController psc)
       {
           this.psc=psc;
           rtc=new RecruitTroopsController(rtg,psc);
           rtc.updateGUIWithUser(user);
           rtg.setVisible(true);
           //JOptionPane.showMessageDialog(null,"Not enough gold!!!");
       }
}
