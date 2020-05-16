package playerState;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Battle;
import model.Troop;
import playerState.exceptions.UsernameNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStateLoader {
    private File f=new File(System.getProperty("user.dir")+"\\"+"PlayerStates.json");
    private String username;
    private ArrayList<Troop> troops;
    private ArrayList<Battle> battles;
    public void loadUser(String user) throws UsernameNotFoundException
    {
        try {
            Scanner sf=new Scanner(f);
            boolean ok=false;
            Gson gson=new Gson();
            while(sf.hasNextLine() && !ok)
            {
                String str1,str2,str3;
                str1=sf.nextLine();
                str2=sf.nextLine();
                str3=sf.nextLine();
                username=gson.fromJson(str1,String.class);
                troops=gson.fromJson(str2,new TypeToken<ArrayList<Troop>>() {}.getType());
                battles=gson.fromJson(str3,new TypeToken<ArrayList<Battle>>() {}.getType());
                if(username.equals(user))
                {
                    ok=true;
                }
            }
            sf.close();
            if(!ok)
            {
                throw new UsernameNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
}
