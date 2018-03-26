package com.madeindjs.bruteforce4zip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.FilerException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class BruteForcer {

    private ZipFile zipFile;
    private String destination;
    private Passwords passwords;

    /**
     * @param source
     * @throws FilerException
     * @throws FileNotFoundException
     */
    public BruteForcer(String source) throws FileNotFoundException, ZipException, IOException {
        File file = new File(source);
        if (!file.isFile()) {
            throw new FileNotFoundException("Given file is not a valid file");
        }
        destination = new File(source).getParentFile().getPath();
        zipFile = new ZipFile(source);
        passwords = new Passwords();
    }

    public void run() {

        try {
            BufferedReader buffer = passwords.getBuffer();
            String line;
            while ((line = buffer.readLine()) != null) {
                if (tryPassword(line)) {
                    System.out.println(String.format("Found this password: %s", line));
                    buffer.close();
                    return;
                } else {
                    System.out.println(String.format("Try this password: %s", line));
                }
            }

            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(BruteForcer.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println("Can't find local passwords");
    }

    /**
     * Try to delate given archive with the given password
     *
     * @param password
     * @return `true` if success
     */
    public boolean tryPassword(String password) {
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
