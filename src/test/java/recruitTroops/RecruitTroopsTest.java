package recruitTroops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import playerState.PlayerStateLoader;
import playerState.PlayerStateWriter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecruitTroopsTest {
    private File f;
    private File f2;
    @Before
    public void initTest()
    {
        Path resourceDirectory= Paths.get("src", "test", "resources","recruitTroops");
        f=new File(resourceDirectory+"/"+"PlayerStates0.json");
        f2=new File(resourceDirectory+"/"+"PlayerStates0new.json");
        PlayerStateLoader.setF(f);
        PlayerStateWriter.setF(f);
        PlayerStateWriter.setF2(f2);
    }
    @Test
    public void makePurchaseActionTest()
    {

    }
    @After
    public void endTest()
    {

    }
}
