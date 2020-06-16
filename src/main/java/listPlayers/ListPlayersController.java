package listPlayers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import login.User;

public class ListPlayersController {

    private AdminGUI ag = new AdminGUI();
    private ListPlayersGUI lpg = new ListPlayersGUI();
    private String fileName = System.getProperty("user.dir") + "\\" + "login.json";
    private ArrayList<User> users = new ArrayList<>(100);
    private Type t =  new TypeToken<List<User>>(){}.getType();
    private Gson gs = new Gson();

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
}
