
import com.madeindjs.bruteforce4zip.BruteForcer;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;
import org.junit.Assert;
import org.junit.Test;

public class BruteForcerUnitTest {

    public static final String ZIP_FILE = "src/test/resources/toto.txt.zip";

    @Test
    public void testUnvalidPassword() throws FileNotFoundException, ZipException, IOException {
        BruteForcer forcer = new BruteForcer(ZIP_FILE);
        Assert.assertFalse(forcer.tryPassword("no"));
    }

    @Test
    public void testValidPassword() throws FileNotFoundException, ZipException, IOException {
        BruteForcer forcer = new BruteForcer(ZIP_FILE);
        Assert.assertTrue(forcer.tryPassword("toto"));
    }

}
