package login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginControllerReadUsersTest {

    LoginController lc;
    File f;


    @Before
    public void setUp() throws Exception {

        lc = new LoginController();
        Path resourceDirectory = Paths.get("src","test","resources","playerState");
        f=new File(resourceDirectory+"\\"+"Login0.json");


    }

    @After
    public void tearDown() throws Exception {
        lc = null;
        f = null;
    }

    @Test
    public void readUsersEmptyFile() {

        ArrayList<User> aLogin = new ArrayList<>(1);


    }
}