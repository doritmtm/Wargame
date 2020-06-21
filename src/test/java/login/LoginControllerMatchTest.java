package login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerMatchTest {

    LoginController lc;

    @Before
    public void setUp() throws Exception {
        lc = new LoginController();
    }

    @After
    public void tearDown() throws Exception {
        lc = null;
    }

    @Test
    public void matchTrue()
    {
        String tStr = "Test";
        boolean result = lc.match(lc.toMD5(tStr),tStr);
        assertEquals(true, result);
    }

    @Test
    public void matchFalse()
    {
        String tStr = "Test";
        boolean result = lc.match(lc.toMD5(tStr),tStr + "t");
        assertNotEquals(true, result);
    }
}