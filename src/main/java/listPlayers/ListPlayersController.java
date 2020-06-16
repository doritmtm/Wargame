package listPlayers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;

import login.User;

public class ListPlayersController {

    private AdminGUI ag ;
    private String fileName = System.getProperty("user.dir") + "\\" + "login.json";
    private ArrayList<User> users = new ArrayList<>(100);
    private Type t =  new TypeToken<List<User>>(){}.getType();
    private Gson gs = new Gson();

    public ListPlayersController(AdminGUI ag)
    {
        this.ag = ag;
        fillTable();
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

    public void fillTable()
    {
        ag.getListButton().addActionListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = 0;
            ListPlayersGUI lpg= new ListPlayersGUI();
            ReadUsers();
            for (User u:
                 users) {

                lpg.getPlayersTable().setValueAt(u.getUsername(),index,0);
                if(u.isBanned())
                    lpg.getPlayersTable().setValueAt("Yes",index,1);
                else lpg.getPlayersTable().setValueAt("No",index,1);
                index++;
            }
        }
    }
}
