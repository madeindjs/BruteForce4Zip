
import com.madeindjs.bruteforce4zip.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainUnitTest {

    public static final String ZIP_FILE = "src/test/assets/toto.txt.zip";

    @Test
    public void testUnvalidPassword() {
        System.out.println(Main.tryPassword(ZIP_FILE, "no"));
        Assert.assertFalse(Main.tryPassword(ZIP_FILE, "no"));
    }

    @Test
    public void testValidPassword() {
        Assert.assertTrue(Main.tryPassword(ZIP_FILE, "toto"));
    }

}
