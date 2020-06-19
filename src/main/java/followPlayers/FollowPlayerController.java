package followPlayers;

import banPlayer.BanPlayerController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import listPlayers.AdminGUI;
import login.User;

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

            }


        }
    }

}
