package com.madeindjs.bruteforce4zip;

import java.io.File;
import java.io.FileNotFoundException;
import javax.annotation.processing.FilerException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class BruteForcer {

    private ZipFile zipFile;
    private String destination;

    /**
     * @param source
     * @throws FilerException
     * @throws FileNotFoundException
     */
    public BruteForcer(String source) throws FileNotFoundException, ZipException {
        File file = new File(source);
        if (!file.isFile()) {
            throw new FileNotFoundException("Given file is not a valid file");
        }
        destination = new File(source).getParentFile().getPath();
        zipFile = new ZipFile(source);
    }

    /**
     * Try to delate given archive with the given password
     *
     * @param source
     * @param password
     * @return `true` if success
     */
    public boolean tryPassword(String source, String password) {
        try {
            zipFile.setPassword(password);
            // zipFile.setRunInThread(true);
            zipFile.extractAll(destination);
            return true;
        } catch (ZipException ex) {
            return false;
        }

    }

}
