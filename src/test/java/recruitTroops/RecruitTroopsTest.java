package recruitTroops;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import recruitTroops.actions.MakePurchaseAction;
import recruitTroops.exceptions.NotEnoughGoldException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecruitTroopsTest {
    private MakePurchaseAction mpa;
    private Path resourceDirectory= Paths.get("src", "test", "resources","recruitTroops");
    private File f;
    private File f2;
    private File fcorr;
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
        f=new File(resourceDirectory+"/"+"PlayerStates1.json");
        forig=new File(resourceDirectory+"/"+"PlayerStates0.json");
        f2=new File(resourceDirectory+"/"+"PlayerStates1new.json");
        PlayerStateLoader.setF(f);
        PlayerStateWriter.setF(f);
        PlayerStateWriter.setF2(f2);
        resetTestFile();
    }
    @Test
    public void makePurchaseActionTest() throws IOException {
        mpa=new MakePurchaseAction("doritmtm",2);
        fcorr=new File(resourceDirectory+"/"+"makePurchase/PlayerStates1correct.json");
        try {
            mpa.makePurchase("doritmtm",100);
        } catch (NotEnoughGoldException e) {
            Assert.fail();
        }
        Assert.assertTrue(FileUtils.contentEquals(fcorr,f));
        resetTestFile();
    }
    @Test
    public void makePurchaseActionNoGoldTest() throws IOException {
        mpa=new MakePurchaseAction("Neuron",2);
        fcorr=new File(resourceDirectory+"/"+"makePurchaseNoGold/PlayerStates1correct.json");
        try {
            mpa.makePurchase("Neuron",100);
            Assert.fail();
        } catch (NotEnoughGoldException e) {
            Assert.assertTrue(true);
        }
        Assert.assertTrue(FileUtils.contentEquals(fcorr,f));
        resetTestFile();
    }
    @After
    public void endTest()
    {
        mpa=null;
        f=null;
        f2=null;
        fcorr=null;
        forig=null;
    }
}
