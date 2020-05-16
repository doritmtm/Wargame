package playerState;

import com.google.gson.Gson;
import model.Battle;
import model.Troop;
import playerState.exceptions.UsernameNotFoundException;

import java.io.*;
import java.util.ArrayList;

public class PlayerStateWriter {
    private File f=new File(System.getProperty("user.dir")+"\\"+"PlayerStates.json");
    private String username;
    private ArrayList<Troop> troops;
    private ArrayList<Battle> battles;
    public PlayerStateWriter()
    {
        /*username=new String("doritmtm");

        battles.add(new Battle(true,"Neuron"));
        battles.add(new Battle(false,"dars"));
        battles.add(new Battle(false,"CosMar"));
        battles.add(new Battle(true,"Th3BArBarIAN"));*/
    }
    public void initUser(String user)
    {
        try {
            FileWriter fw=new FileWriter(f,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            troops=new ArrayList<Troop>();
            battles=new ArrayList<Battle>();
            troops.add(new Troop("Archers",10,5));
            troops.add(new Troop("Spearman",8,15));
            troops.add(new Troop("Maceman",15,10));
            Gson gson=new Gson();
            pw.println(gson.toJson(user));
            pw.println(gson.toJson(troops));
            pw.println(gson.toJson(battles));
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeToUser(String user)
    {
        username=user;
        PlayerStateLoader pl=new PlayerStateLoader();
        try {
            pl.loadUser(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
    }
}
