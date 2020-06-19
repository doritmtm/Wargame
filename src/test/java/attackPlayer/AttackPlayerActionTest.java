package attackPlayer;

import attackPlayer.actions.AttackAction;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AttackPlayerActionTest {
    private AttackAction apa;
    private Path resourceDirectory= Paths.get("src","test","resources","attackPlayer");
    private File f;
    private File f2;
    private File fcorr,fcorr2;
    private File forig;
    private void resetTestFile()
    {
        try {
            FileUtils.copyFile(forig,f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void initTest()
    {
        forig=new File(resourceDirectory+"/PlayerStates0.json");
        f=new File(resourceDirectory+"/PlayerStates1.json");
        f2=new File(resourceDirectory+"/PlayerStates1new.json");
        PlayerStateLoader.setF(f);
        PlayerStateWriter.setF(f);
        PlayerStateWriter.setF2(f2);
        resetTestFile();
        apa=new AttackAction("doritmtm",null);
    }
    @Test
    public void attackPlayerActionTest() throws IOException {
        fcorr=new File(resourceDirectory+"/action/PlayerStates1correct1.json");
        fcorr2=new File(resourceDirectory+"/action/PlayerStates1correct2.json");
        apa.computeAttack("doritmtm","Neuron");
        Assert.assertTrue(FileUtils.contentEquals(fcorr,f)||FileUtils.contentEquals(fcorr2,f));
    }
    @After
    public void endTest()
    {
        resetTestFile();
        apa=null;
        f=null;
        f2=null;
        forig=null;
        fcorr=null;
    }
}
