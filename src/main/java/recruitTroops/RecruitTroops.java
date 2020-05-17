package recruitTroops;

import javax.swing.*;

public class RecruitTroops {
    public static void main(String argv[])
    {
        RecruitTroopsGUI rtg=new RecruitTroopsGUI();
        RecruitTroopsController rtc=new RecruitTroopsController(rtg);
        rtc.updateGUIWithUser("doritmtm");
        rtg.setVisible(true);
        //JOptionPane.showMessageDialog(null,"Not enough gold!!!");
    }
}
