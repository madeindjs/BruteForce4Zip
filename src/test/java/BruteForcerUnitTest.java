
import com.madeindjs.bruteforce4zip.BruteForcer;
import com.madeindjs.bruteforce4zip.Main;
import java.io.FileNotFoundException;
import net.lingala.zip4j.exception.ZipException;
import org.junit.Assert;
import org.junit.Test;

public class BruteForcerUnitTest {

    public static final String ZIP_FILE = "src/test/resources/toto.txt.zip";

    @Test
    public void testUnvalidPassword() throws FileNotFoundException, ZipException {
        BruteForcer forcer = new BruteForcer(ZIP_FILE);
        Assert.assertFalse(forcer.tryPassword(ZIP_FILE, "no"));
    }

    @Test
    public void testValidPassword() throws FileNotFoundException, ZipException {
        BruteForcer forcer = new BruteForcer(ZIP_FILE);
        Assert.assertTrue(forcer.tryPassword(ZIP_FILE, "toto"));
    }

}
