package recruitTroops;

import javax.swing.*;

public class RecruitTroops {
       private RecruitTroopsGUI rtg=new RecruitTroopsGUI();
       private RecruitTroopsController rtc=new RecruitTroopsController(rtg);
       public RecruitTroops(String user)
       {
           rtc.updateGUIWithUser(user);
           rtg.setVisible(true);
           //JOptionPane.showMessageDialog(null,"Not enough gold!!!");
       }
}
