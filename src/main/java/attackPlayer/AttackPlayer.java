package attackPlayer;

public class AttackPlayer {
    private AttackPlayerGUI atpgui;
    public AttackPlayer()
    {
        atpgui=new AttackPlayerGUI();
        atpgui.setVisible(true);
    }
    public static void main(String argv[])
    {
        AttackPlayer atp=new AttackPlayer();
    }
}
