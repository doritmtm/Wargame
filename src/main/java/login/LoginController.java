package login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import admin.AdminGUI;
import login.exceptions.InvalidCredentialsException;
import java.lang.reflect.Type;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

        public String toMD5(String pass)
        {
            String generatedPass = null;
            int i;
            try
            {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(pass.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();

                for(i = 0; i < bytes.length; i++)
                {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));

                }
                generatedPass = sb.toString();

            }
            catch(NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
            return generatedPass;
        }

        public boolean match(String hash, String orig)
        {
            String md5 = toMD5(orig);
            return md5.equals(hash);
        }

        public void WriteUsers()
        {

               User u1 = new User("doritmtm", toMD5("pass1"), null,false);
               User u2 = new User("dars",toMD5("pass2"),null, false);
               User u3 = new User("CosMar", toMD5("pass3"), null, false);
               User u4 = new User("Neuron",toMD5("pass4"), null, false);
               User u5 = new User("Th3BArBarIAN",toMD5("pass5"), null, false);

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
                //WriteUsers(); //not needed anymore, left for examination purposes
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
                                        if(userFieldValue.equals("admin") && passFieldValue.equals("admin"))
                                        {
                                            isAdmin = true;
                                            lg.setVisible(false);
                                            AdminGUI lpg = new AdminGUI();
                                        }
                                        else {
                                            isAdmin = false;

                                            for (User u : users) {

                                                if (u.getUsername().equals(userFieldValue) && match(u.getPassword(),passFieldValue) && !isAdmin) {
                                                    foundUser = u;
                                                    if (u.isBanned())
                                                        throw new UserIsBanned(u);
                                                    JOptionPane.showMessageDialog(null, "Login Successful!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                                                    found = true;

                                                }
                                            }
                                            if (found) {

                                                lg.setVisible(false);
                                                ArrayList<Troop> iniTroops = new ArrayList<Troop>();
                                                iniTroops.add(new Troop("Archer", 12, 8, 20));
                                                iniTroops.add(new Troop("Spearman", 8, 15, 25));
                                                iniTroops.add(new Troop("Soldier", 10, 10, 15));
                                                iniTroops.add(new Troop("Axeman", 10, 15, 30));
                                                iniTroops.add(new Troop("Knight", 20, 30, 60));
                                                PlayerState.setInitTroops(iniTroops);
                                                PlayerState ps1 = new PlayerState(foundUser.getUsername());
                                                ps1.getPgui().addWindowListener(new WindowAdapter() {
                                                    @Override
                                                    public void windowClosing(WindowEvent e) {
                                                        LoginController lc=new LoginController();
                                                        lc.CheckCredentials();
                                                    }
                                                });
                                            }
                                            if (!found)
                                                throw new InvalidCredentialsException();
                                        }
                                }
                                catch(InvalidCredentialsException | UserIsBanned excep)
                                {
                                        excep.printStackTrace();

                                        if(excep.getClass().equals(InvalidCredentialsException.class))
                                        JOptionPane.showMessageDialog(null,"Login failed!\nInvalid credentials!",
                                                "Login Failure",JOptionPane.ERROR_MESSAGE);
                                        else if(excep.getClass().equals((UserIsBanned.class)))
                                        {
                                            IsBannedGUI ibg = new IsBannedGUI();
                                            ibg.getReason().setText(foundUser.getBanReason());

                                            ibg.setVisible(true);
                                            ibg.getCancel().addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    ibg.dispose();
                                                }
                                            });

                                        }

                                }
                        }
                }
        }
}
