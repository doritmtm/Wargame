package banPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.*;

import banPlayer.exceptions.UserNotFound;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;
import listPlayers.AdminGUI;
import login.User;

import javax.swing.*;

public class BanPlayerController {
    private AdminGUI ag;
    private String fileName = System.getProperty("user.dir") + "\\" + "login.json";
    private ArrayList<User> users = new ArrayList<>(100);
    private Type t =  new TypeToken<List<User>>(){}.getType();
    private Gson gs = new Gson();
    private BanPlayerGUI bpg;


    public BanPlayerController(AdminGUI ag)
    {
        this.ag = ag;
        openGUI();

    }

    public void openGUI()
    {
        ag.getBanButton().setActionCommand("GUI");
        ag.getBanButton().addActionListener(new ButtonClickListener());


    }

    public void ban()
    {
        ReadUsers();
        bpg.getConfirmButton().setActionCommand("BAN");
        bpg.getConfirmButton().addActionListener(new ButtonClickListener());
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

    public void WriteUsers()
    {
        Gson gs = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fw = new FileWriter(fileName))
        {
            gs.toJson(users, fw);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private class ButtonClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if(command.equals("GUI"))
            {
                bpg = new BanPlayerGUI();
                ban();
            }
            else if(command.equals("BAN"))
            {
                boolean found = false;
                try
                {
                    for(User u:users)
                    {
                        if(u.getUsername().equals(bpg.getNameField().getText())) {
                            found = true;
                            u.setBanned(true);
                            u.setBanReason(bpg.getReasonArea().getText());
                            WriteUsers();
                            JOptionPane.showMessageDialog(null,"User banned successfully",
                                    "Success!",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(!found)
                        throw new UserNotFound();
                }
                catch(UserNotFound except)
                {
                    JOptionPane.showMessageDialog(null,"User not found!",
                            "Failed!",JOptionPane.ERROR_MESSAGE);
                    except.printStackTrace();
                }
            }
        }
    }

}
