package followPlayers;

import banPlayer.BanPlayerController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import listPlayers.AdminGUI;
import login.User;
import model.Troop;
import playerState.PlayerState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FollowPlayerController {
    private AdminGUI ag;
    private String fileName = System.getProperty("user.dir") + "\\" + "login.json";
    private ArrayList<User> users = new ArrayList<>(100);
    private Type t =  new TypeToken<List<User>>(){}.getType();
    private Gson gs = new Gson();
    private FollowPlayerGUI fpg;

    public FollowPlayerController(AdminGUI ag)
    {
        this.ag = ag;
        seek();

    }

    public void openGUI()
    {
        ag.getSeekButton().setActionCommand("GUI");
        ag.getSeekButton().addActionListener(new ButtonClickListener());
    }

    public void seek()
    {
        fpg.getSeekButton().setActionCommand("SEEK");
        fpg.getSeekButton().addActionListener(new ButtonClickListener());
    }

    public void ReadUsers()
    {
        try
        {
            Reader reader = new FileReader(fileName);
            users = gs.fromJson(reader, t);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if(command.equals("GUI"))
            {
                fpg = new FollowPlayerGUI();
                seek();
            }

            if(command.equals("SEEK"))
            {
                ReadUsers();
                for(User u:users)
                {
                    if(u.getUsername().equals(fpg.getNameField().getText()))
                    {
                        ArrayList<Troop> iniTroops = new ArrayList<Troop>();
                        iniTroops.add(new Troop("Archer", 12, 8, 20));
                        iniTroops.add(new Troop("Spearman", 8, 15, 25));
                        iniTroops.add(new Troop("Soldier", 10, 10, 15));
                        iniTroops.add(new Troop("Axeman", 10, 15, 30));
                        iniTroops.add(new Troop("Knight", 20, 30, 60));
                        PlayerState.setInitTroops(iniTroops);
                        PlayerState ps1 = new PlayerState(u.getUsername());

                    }
                }
            }


        }
    }

}
