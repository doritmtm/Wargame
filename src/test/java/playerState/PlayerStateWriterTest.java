package playerState;

import model.Battle;
import model.Troop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;
import playerState.PlayerState;
import playerState.PlayerStateWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlayerStateWriterTest {
    private PlayerStateWriter pw;
    private File f;
    private File f2;
    private File fsrc;
    private File fcorr,fcorr2,fcorr3;
    private Path resourceDirectory;
    private void resetTestFile()
    {
        try {
            FileUtils.copyFile(fsrc,f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void initTest()
    {
        ArrayList<Troop> iniTroops=new ArrayList<Troop>();
        iniTroops.add(new Troop("Archer",12,8,20));
        iniTroops.add(new Troop("Spearman",8,15,25));
        iniTroops.add(new Troop("Soldier",10,10,15));
        iniTroops.add(new Troop("Axeman",10,15,30));
        iniTroops.add(new Troop("Knight",20,30,60));
        PlayerState.setInitTroops(iniTroops);
        pw=new PlayerStateWriter();
        resourceDirectory = Paths.get("src","test","resources","playerState");
        f=new File(resourceDirectory+"\\"+"PlayerStates1.json");
        f2=new File(resourceDirectory+"\\"+"PlayerStates1new.json");
        fsrc=new File(resourceDirectory+"\\"+"PlayerStates0.json");
        fcorr=new File(resourceDirectory+"\\"+ "initUser/PlayerStates1correct.json");
        fcorr2=new File(resourceDirectory+"\\"+ "initUserExistent/PlayerStates1correct.json");
        pw.setF(f);
        pw.setF2(f2);
        resetTestFile();
    }
    @Test
    public void initUserTest()
    {
        pw.initUser("CosMar");
        try {
            Assert.assertTrue(FileUtils.contentEquals(f,fcorr));
        } catch (IOException e) {
            Assert.fail();
        }
        resetTestFile();
    }
    @Test
    public void initUserExistentTest()
    {
        pw.initUser("doritmtm");
        try {
            Assert.assertTrue(FileUtils.contentEquals(f,fcorr2));
        } catch (IOException e) {
            Assert.fail();
        }
        resetTestFile();
    }
    @Test
    public void updatePlayerStateTroopTest()
    {
        fcorr3=new File(resourceDirectory+"\\"+ "update/PlayerStates1correct1.json");
        pw.updatePlayerState("doritmtm",new Troop("Soldier",10,10,15,30));
        try {
            Assert.assertTrue(FileUtils.contentEquals(f,fcorr3));
        } catch (IOException e) {
            Assert.fail();
        }
        fcorr3=null;
        resetTestFile();
    }
    @Test
    public void updatePlayerStateBattleTest()
    {
        fcorr3=new File(resourceDirectory+"\\"+ "update/PlayerStates1correct2.json");
        pw.updatePlayerState("doritmtm",new Battle(false,"Neuron"));
        try {
            Assert.assertTrue(FileUtils.contentEquals(f,fcorr3));
        } catch (IOException e) {
            Assert.fail();
        }
        fcorr3=null;
        resetTestFile();
    }
    @Test
    public void updatePlayerStateGoldTest()
    {
        fcorr3=new File(resourceDirectory+"\\"+ "update/PlayerStates1correct3.json");
        pw.updatePlayerStateGold("doritmtm",150000);
        try {
            Assert.assertTrue(FileUtils.contentEquals(f,fcorr3));
        } catch (IOException e) {
            Assert.fail();
        }
        fcorr3=null;
        resetTestFile();
    }
    @After
    public void endTest()
    {

        pw=null;
        f=null;
        f2=null;
        fsrc=null;
        fcorr=null;
        fcorr2=null;
        fcorr3=null;
    }
}
