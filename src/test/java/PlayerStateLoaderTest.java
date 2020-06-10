import model.Battle;
import model.Troop;
import org.junit.*;
import playerState.PlayerStateLoader;
import playerState.exceptions.PlayerNotLoadedException;
import playerState.exceptions.UsernameNotFoundException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayerStateLoaderTest {
    private PlayerStateLoader pl;
    private File f;
    @Before
    public void initTest()
    {
        pl=new PlayerStateLoader();
        Path resourceDirectory = Paths.get("src","test","resources");
        f=new File(resourceDirectory+"\\"+"PlayerStates0.json");
        pl.setF(f);
    }
    @Test
    public void loadUserNotExistentTest()
    {
        try {
            pl.loadUser("doritmtm23");
            Assert.fail();
        } catch (UsernameNotFoundException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void loadUserNullTest()
    {
        try {
            pl.loadUser(null);
            Assert.fail();
        } catch (UsernameNotFoundException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void loadUserTest()
    {
        ArrayList<Troop> iniTroops=new ArrayList<Troop>();
        iniTroops.add(new Troop("Archer",12,8,20,100));
        iniTroops.add(new Troop("Spearman",8,15,25,50));
        iniTroops.add(new Troop("Soldier",10,10,15,50));
        iniTroops.add(new Troop("Axeman",10,15,30,0));
        iniTroops.add(new Troop("Knight",20,30,60,100));
        ArrayList<Troop> iniBattles=new ArrayList<Troop>();
        try {
            pl.loadUser("doritmtm");
            Assert.assertEquals("doritmtm",pl.getUsername());
            Assert.assertEquals(iniTroops,pl.getTroops());
            Assert.assertEquals(iniBattles,pl.getBattles());
            Assert.assertEquals(0,pl.getGold());
            Assert.assertEquals(0,pl.getPosition());
        } catch (UsernameNotFoundException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void totalDefenseTest()
    {
        try {
            Assert.assertEquals(5050,pl.getTotalDefense());
        } catch (PlayerNotLoadedException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void totalAttackTest()
    {
        try {
            Assert.assertEquals(4100,pl.getTotalAttack());
        } catch (PlayerNotLoadedException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void loadAllUsersTest()
    {
        ArrayList<PlayerStateLoader> apl1=new ArrayList<PlayerStateLoader>();
        PlayerStateLoader plt=new PlayerStateLoader();
        plt.setF(f);
        try {
            plt.loadUser("doritmtm");
        } catch (UsernameNotFoundException e) {
            Assert.fail();
        }
        apl1.add(plt);
        plt=new PlayerStateLoader();
        plt.setF(f);
        try {
            plt.loadUser("Neuron");
        } catch (UsernameNotFoundException e) {
            Assert.fail();
        }
        apl1.add(plt);
        ArrayList<PlayerStateLoader> apl2=PlayerStateLoader.loadAllUsers(f);
        Iterator<PlayerStateLoader> it1=apl1.iterator();
        Iterator<PlayerStateLoader> it2=apl2.iterator();
        while(it1.hasNext())
        {
            Assert.assertEquals(it1.next(),it2.next());
        }
    }
    @After
    public void delTest()
    {
        pl=null;
    }
}
