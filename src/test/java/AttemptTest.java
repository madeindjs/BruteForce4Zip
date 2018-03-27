
import com.madeindjs.bruteforce4zip.Attempt;
import com.madeindjs.bruteforce4zip.BruteForcer;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.junit.Assert;
import org.junit.Test;

public class AttemptTest {

    public static final String ZIP_FILE = "src/test/resources/toto.txt.zip";

    @Test
    public void testUnvalidPassword() throws FileNotFoundException, ZipException, IOException {
        Attempt forcer = new Attempt(ZIP_FILE, "no", "src/test/resources/");
        Assert.assertFalse(forcer.tryPassword());
    }

    @Test
    public void testValidPassword() throws FileNotFoundException, ZipException, IOException {
        Attempt forcer = new Attempt(ZIP_FILE, "toto", "src/test/resources/");
        Assert.assertTrue(forcer.tryPassword());
    }

}
