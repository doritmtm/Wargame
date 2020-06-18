package playerState;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Battle;
import model.Troop;
import playerState.exceptions.PlayerNotLoadedException;
import playerState.exceptions.UsernameNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class PlayerStateLoader {
    private static File f=new File(System.getProperty("user.dir")+"\\"+"PlayerStates.json");
    private int gold;
    private int position;
    private String username;
    private ArrayList<Troop> troops;
    private ArrayList<Battle> battles;
    public PlayerStateLoader()
    {

    }
    public PlayerStateLoader(String user)
    {
        try {
            loadUser(user);
        } catch (UsernameNotFoundException e) {
            PlayerStateWriter pw=new PlayerStateWriter();
            pw.initUser(user);
            gold=pw.getGold();
            username=pw.getUsername();
            troops=pw.getTroops();
            battles=pw.getBattles();
        }
    }
    public static ArrayList<PlayerStateLoader> loadAllUsers()
    {
        File f=new File(System.getProperty("user.dir")+"\\"+"PlayerStates.json");
        ArrayList<PlayerStateLoader> apl=new ArrayList<PlayerStateLoader>();
        PlayerStateLoader pl;
        try {
            Scanner sf=new Scanner(f);
            Gson gson=new Gson();
            int position=0;
            while(sf.hasNextLine())
            {
                pl=new PlayerStateLoader();
                String str1,str2,str3,str4;
                str1=sf.nextLine();
                str2=sf.nextLine();
                str3=sf.nextLine();
                str4=sf.nextLine();
                pl.username=gson.fromJson(str1,String.class);
                pl.troops=gson.fromJson(str2,new TypeToken<ArrayList<Troop>>() {}.getType());
                pl.battles=gson.fromJson(str3,new TypeToken<ArrayList<Battle>>() {}.getType());
                pl.gold=gson.fromJson(str4,int.class);
                pl.position=position;
                apl.add(pl);
                position++;
            }
            sf.close();
            position--;
            return apl;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<PlayerStateLoader> loadAllUsers(File f)
    {
        ArrayList<PlayerStateLoader> apl=new ArrayList<PlayerStateLoader>();
        PlayerStateLoader pl;
        try {
            Scanner sf=new Scanner(f);
            Gson gson=new Gson();
            int position=0;
            while(sf.hasNextLine())
            {
                pl=new PlayerStateLoader();
                String str1,str2,str3,str4;
                str1=sf.nextLine();
                str2=sf.nextLine();
                str3=sf.nextLine();
                str4=sf.nextLine();
                pl.username=gson.fromJson(str1,String.class);
                pl.troops=gson.fromJson(str2,new TypeToken<ArrayList<Troop>>() {}.getType());
                pl.battles=gson.fromJson(str3,new TypeToken<ArrayList<Battle>>() {}.getType());
                pl.gold=gson.fromJson(str4,int.class);
                pl.position=position;
                apl.add(pl);
                position++;
            }
            sf.close();
            position--;
            return apl;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void loadUser(String user) throws UsernameNotFoundException
    {
        try {
            Scanner sf=new Scanner(f);
            boolean ok=false;
            Gson gson=new Gson();
            position=0;
            while(sf.hasNextLine() && !ok)
            {
                String str1,str2,str3,str4;
                str1=sf.nextLine();
                str2=sf.nextLine();
                str3=sf.nextLine();
                str4=sf.nextLine();
                username=gson.fromJson(str1,String.class);
                troops=gson.fromJson(str2,new TypeToken<ArrayList<Troop>>() {}.getType());
                battles=gson.fromJson(str3,new TypeToken<ArrayList<Battle>>() {}.getType());
                gold=gson.fromJson(str4,int.class);
                if(username.equals(user))
                {
                    ok=true;
                }
                position++;
            }
            sf.close();
            position--;
            if(!ok)
            {
                throw new UsernameNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int getTotalDefense() throws PlayerNotLoadedException
    {
        if(troops!=null)
        {
            int td=0;
            Troop t;
            Iterator<Troop> it=troops.iterator();
            while(it.hasNext())
            {
                t=it.next();
                td+=t.getDefense()*t.getCount();
            }
            return td;
        }
        else
        {
            throw new PlayerNotLoadedException();
        }
    }
    public int getTotalAttack() throws PlayerNotLoadedException
    {
        if(troops!=null)
        {
            int ta=0;
            Troop t;
            Iterator<Troop> it=troops.iterator();
            while(it.hasNext())
            {
                t=it.next();
                ta+=t.getAttack()*t.getCount();
            }
            return ta;
        }
        else
        {
            throw new PlayerNotLoadedException();
        }
    }
    public int getGold() {
        return gold;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Troop> getTroops() {
        return troops;
    }

    public ArrayList<Battle> getBattles() {
        return battles;
    }

    public int getPosition() {
        return position;
    }

    public static void setF(File f) {
        PlayerStateLoader.f = f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStateLoader that = (PlayerStateLoader) o;
        return gold == that.gold &&
                position == that.position &&
                Objects.equals(username, that.username) &&
                Objects.equals(troops, that.troops) &&
                Objects.equals(battles, that.battles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gold, position, username, troops, battles);
    }
}
