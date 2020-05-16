package playerState;

import javax.swing.*;

public class PlayerState {
    private JFrame window=new JFrame("Player State"); //to put player name in title
    public static void main(String argv[])
    {
        PlayerStateGUI pgui=new PlayerStateGUI();
        PlayerStateWriter pw=new PlayerStateWriter();
        pw.writeToUser("doritmtm");
        pw.writeToUser("Neuron");
        pw.writeToUser("dars");
        pw.writeToUser("CosMar");
        pw.writeToUser("Th3BArBarIAN");
    }
}
