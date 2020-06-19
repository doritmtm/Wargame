package attackPlayer;

import attackPlayer.actions.AttackAction;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;
import playerState.exceptions.PlayerNotLoadedException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AttackPlayerTest {
    private AttackPlayerController apc;
    private Path resourceDirectory= Paths.get("src","test","resources","attackPlayer");
    private File f;
    private File f2;
    @Before
    public void initTest()
    {
        f=new File(resourceDirectory+"/PlayerStates2.json");
        f2=new File(resourceDirectory+"/PlayerStates3.json");
        apc=new AttackPlayerController(null,null);
    }
    @Test
    public void findOpponents1Test() {
        PlayerStateLoader.setF(f);
        try {
            apc.findOpponents("doritmtm");
        } catch (PlayerNotLoadedException e) {
            Assert.fail();
        }
        ArrayList<String> expectedOpponents=new ArrayList<String>();
        expectedOpponents.add("Neuron");
        Assert.assertEquals(expectedOpponents,apc.getOpponents());
        int i;
        for(i=0;i<apc.getNR_OF_OPPONENTS();i++)
        {
            Assert.assertTrue(apc.getRand()[i] < expectedOpponents.size());
        }
    }
    @Test
    public void findOpponents2Test() {
        PlayerStateLoader.setF(f);
        try {
            apc.findOpponents("Neuron");
        } catch (PlayerNotLoadedException e) {
            Assert.fail();
        }
        ArrayList<String> expectedOpponents=new ArrayList<String>();
        expectedOpponents.add("doritmtm");
        expectedOpponents.add("dars");
        expectedOpponents.add("CosMar");
        expectedOpponents.add("Th3BArBarIAN");
        Assert.assertEquals(expectedOpponents,apc.getOpponents());
        int i;
        for(i=0;i<apc.getNR_OF_OPPONENTS();i++)
        {
            Assert.assertTrue(apc.getRand()[i] < expectedOpponents.size());
        }
    }
    @Test
    public void findOpponents3Test() {
        PlayerStateLoader.setF(f2);
        try {
            apc.findOpponents("doritmtm");
        } catch (PlayerNotLoadedException e) {
            Assert.fail();
        }
        ArrayList<String> expectedOpponents=new ArrayList<String>();
        expectedOpponents.add("Neuron");
        expectedOpponents.add("dars");
        expectedOpponents.add("CosMar");
        expectedOpponents.add("Th3BArBarIAN");
        Assert.assertEquals(expectedOpponents,apc.getOpponents());
        int i;
        for(i=0;i<apc.getNR_OF_OPPONENTS();i++)
        {
            Assert.assertTrue(apc.getRand()[i] < expectedOpponents.size());
        }
    }
    @After
    public void endTest()
    {
        apc=null;
        f=null;
        f2=null;
    }
}
