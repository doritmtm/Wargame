package login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import listPlayers.AdminGUI;
import login.exceptions.InvalidCredentialsException;
import java.lang.reflect.Type;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import login.exceptions.UserIsBanned;
import model.Troop;
import playerState.PlayerState;

import javax.swing.*;

public class LoginController {

        private LoginGUI lg = new LoginGUI();
        private Type t =  new TypeToken<List<User>>(){}.getType();
        private String fileName = System.getProperty("user.dir") + "\\" + "login.json";
        private Gson gs = new Gson();
        private ArrayList<User> users ;
        private ArrayList<User> usersToWrite = new ArrayList<>(100);
        private boolean isAdmin = false;

        public void WriteUsers()
        {
               User u1 = new User("admin", "admin", null, false);
               User u2 = new User("doritmtm", "pass1", null,false);
               User u3 = new User("dars","pass2","Ban reason 1", true);
               User u4 = new User("CosMar", "pass3", "Ban reason 2", true);
               User u5 = new User("Neuron","pass4", null, false);
               usersToWrite.add(u1);
               usersToWrite.add(u2);
               usersToWrite.add(u3);
               usersToWrite.add(u4);
               usersToWrite.add(u5);

               Gson gs = new GsonBuilder().setPrettyPrinting().create();

               try (FileWriter fw = new FileWriter(fileName))
               {
                       gs.toJson(usersToWrite, fw);
               }
               catch(IOException e)
               {
                       e.printStackTrace();
               }

        }
        public void ReadUsers() {
                WriteUsers();
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

        public void CheckCredentials() {
                ReadUsers();
                lg.getButtonLogin().setActionCommand("Login");
                lg.getButtonLogin().addActionListener(new ButtonClickListener());
        }

        private class ButtonClickListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        User foundUser = null;
                        if(command.equals("Login"))
                        {
                                try {
                                        boolean found = false;

                                        String userFieldValue = lg.getFieldUser().getText();
                                        String passFieldValue = lg.getFieldPass().getText();

                                        for (User u : users) {

                                                if (u.getUsername().equals(userFieldValue) && u.getPassword().equals(passFieldValue)) {
                                                        if(u.getUsername().equals("admin") && u.getPassword().equals("admin"))
                                                        {
                                                                isAdmin = true;
                                                                lg.setVisible(false);
                                                                AdminGUI lpg = new AdminGUI();
                                                        }
                                                        else isAdmin = false;
                                                        if(u.isBanned())
                                                                throw new UserIsBanned(u);
                                                       if(!isAdmin) JOptionPane.showMessageDialog(null, "Login Successful!", "Login Success",JOptionPane.INFORMATION_MESSAGE);
                                                        found = true;
                                                        foundUser = u;
                                                }
                                        }
                                        if(found && !isAdmin)
                                        {

                                                lg.setVisible(false);
                                                ArrayList<Troop> iniTroops=new ArrayList<Troop>();
                                                iniTroops.add(new Troop("Archer",12,8,20));
                                                iniTroops.add(new Troop("Spearman",8,15,25));
                                                iniTroops.add(new Troop("Soldier",10,10,15));
                                                iniTroops.add(new Troop("Axeman",10,15,30));
                                                iniTroops.add(new Troop("Knight",20,30,60));
                                                PlayerState.setInitTroops(iniTroops);
                                                PlayerState ps1=new PlayerState(foundUser.getUsername());
                                        }
                                        if (!found)
                                                throw new InvalidCredentialsException();
                                }
                                catch(InvalidCredentialsException | UserIsBanned excep)
                                {
                                        excep.printStackTrace();
                                        if(excep.getClass().equals(InvalidCredentialsException.class))
                                        JOptionPane.showMessageDialog(null,"Login failed!\nInvalid credentials!",
                                                "Login Failure",JOptionPane.ERROR_MESSAGE);
                                        else if(excep.getClass().equals((UserIsBanned.class)))
                                                JOptionPane.showMessageDialog(null,"You have been banned!\n"+((UserIsBanned) excep).getU().getBanReason(),"Login Failure",JOptionPane.ERROR_MESSAGE);
                                }
                        }
                }
        }
}
