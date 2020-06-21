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
    File f0;
    File f1;
    File f2;


    @Before
    public void setUp() throws Exception {

        lc = new LoginController();
        Path resourceDirectory = Paths.get("src","test","resources","login");
        f0 = new File(resourceDirectory + "\\" + "Login0.json");
        f1 = new File(resourceDirectory + "\\" + "Login1.json");
        f2 = new File(resourceDirectory + "\\" + "Login2.json");


    }

    @After
    public void tearDown() throws Exception {
        lc = null;
        f0 = null;
        f1 = null;
        f2 = null;
    }

    @Test
    public void readUsersEmptyFile() {
        lc.setFileName(f0.getPath());
        ArrayList<User> aLogin = new ArrayList<>(1);
        lc.setUsers(aLogin);
        lc.ReadUsers();
        assertEquals(0,aLogin.size());
    }

    @Test
    public void readUsersOneUser(){
        lc.setFileName(f1.getPath());
        ArrayList<User> aLogin = new ArrayList<>(1);
        lc.setUsers(aLogin);
        lc.ReadUsers();

        assertEquals(1,lc.getUsers().size());
        assertEquals("test",lc.getUsers().get(0).getUsername());
        assertEquals("test",lc.getUsers().get(0).getPassword());
        assertFalse(lc.getUsers().get(0).isBanned());
        assertNull(lc.getUsers().get(0).getBanReason());
    }

    @Test
    public void readUsersTwoUsers(){
        lc.setFileName(f2.getPath());
        ArrayList<User> aLogin = new ArrayList<>(1);
        lc.setUsers(aLogin);
        lc.ReadUsers();

        assertEquals(2,lc.getUsers().size());
        assertEquals("test",lc.getUsers().get(0).getUsername());
        assertEquals("test",lc.getUsers().get(0).getPassword());
        assertFalse(lc.getUsers().get(0).isBanned());
        assertNull(lc.getUsers().get(0).getBanReason());

        assertEquals("test1",lc.getUsers().get(1).getUsername());
        assertEquals("test1",lc.getUsers().get(1).getPassword());
        assertTrue(lc.getUsers().get(1).isBanned());
        assertEquals("test1",lc.getUsers().get(1).getBanReason());

    }
}