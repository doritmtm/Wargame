package playerState;

import com.google.gson.Gson;
import model.Battle;
import model.Troop;
import playerState.exceptions.UsernameNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PlayerStateWriter {
    private File f=new File(System.getProperty("user.dir")+"\\"+"PlayerStates.json");
    private File f2=new File(System.getProperty("user.dir")+"\\"+"PlayerStatesNew.json");
    private int gold;
    private int position;
    private String username;
    private ArrayList<Troop> troops;
    private ArrayList<Battle> battles;
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
            gold=0;
            Gson gson=new Gson();
            pw.println(gson.toJson(user));
            pw.println(gson.toJson(troops));
            pw.println(gson.toJson(battles));
            pw.println(gson.toJson(gold));
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void loadPlayerState(String user) throws UsernameNotFoundException
    {
        username=user;
        PlayerStateLoader pl=new PlayerStateLoader();
        pl.loadUser(user);
        gold=pl.getGold();
        troops=pl.getTroops();
        battles=pl.getBattles();
        position=pl.getPosition();
    }
    public void updatePlayerStateDatabase()
    {
        try {
            FileWriter fw=new FileWriter(f2);
            Scanner fs=new Scanner(f);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            String str1,str2,str3,str4;
            Gson gson=new Gson();
            int i=0;
            while(fs.hasNextLine())
            {
                str1=fs.nextLine();
                str2=fs.nextLine();
                str3=fs.nextLine();
                str4=fs.nextLine();
                if(i!=position)
                {
                    pw.println(str1);
                    pw.println(str2);
                    pw.println(str3);
                    pw.println(str4);
                }
                else
                {
                    pw.println(gson.toJson(username));
                    pw.println(gson.toJson(troops));
                    pw.println(gson.toJson(battles));
                    pw.println(gson.toJson(gold));
                }
                i++;
            }
            pw.close();
            bw.close();
            fw.close();
            fs.close();
            f.delete();
            Files.move(f2.toPath(),f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updatePlayerState(String user,Battle b)
    {
        try {
            loadPlayerState(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
        battles.add(b);
        updatePlayerStateDatabase();
    }
    public void updatePlayerStateBattles(String user,ArrayList<Battle> ab)
    {
        try {
            loadPlayerState(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
        battles=ab;
        updatePlayerStateDatabase();
    }
    public void updatePlayerStateGold(String user,int gold)
    {
        try {
            loadPlayerState(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
        this.gold=gold;
        updatePlayerStateDatabase();
    }
    public void updatePlayerState(String user,Troop t)
    {
        try {
            loadPlayerState(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
        Iterator<Troop> it;
        it=troops.iterator();
        boolean ok=false;
        Troop ti;
        int i=0;
        while(it.hasNext() && !ok)
        {
            ti=it.next();
            if(ti.getType().equals(t.getType()))
            {
                troops.set(i,t);
                ok=true;
            }
            i++;
        }
        updatePlayerStateDatabase();
    }
    public void updatePlayerStateTroops(String user,ArrayList<Troop> at)
    {
        try {
            loadPlayerState(user);
        } catch (UsernameNotFoundException e) {
            initUser(user);
        }
        troops=at;
        updatePlayerStateDatabase();
    }
}
