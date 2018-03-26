package com.madeindjs.bruteforce4zip;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 *
 * @see
 * https://github.com/danielmiessler/SecLists/master/Passwords/openwall.net-all.txt
 */
public class Passwords {

    public static final String REMOTE_URL = "https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/openwall.net-all.txt";
    public static final String LOCAL_URL = "src/main/resources/passwords.txt";

    public Passwords() throws IOException {
        if (!cacheExists()) {
            downloadPasswords();
        }
    }

    public BufferedReader getBuffer() throws FileNotFoundException {
        return new BufferedReader(new FileReader(LOCAL_URL));
    }

    private boolean cacheExists() {
        return new File(LOCAL_URL).exists();
    }

    /**
     * Download all passwords from Github
     *
     * @throws IOException
     */
    private void downloadPasswords() throws IOException {
        File localFile = new File(LOCAL_URL);
        URL url = new URL(REMOTE_URL);

        if (!localFile.exists()) {
            localFile.getParentFile().mkdirs();
            localFile.createNewFile();
        }

        try (
                BufferedInputStream in = new BufferedInputStream(url.openStream());
                OutputStream out = new FileOutputStream(localFile);) {

            byte[] buff = new byte[1024];
            int length;
            while ((length = in.read(buff)) > 0) {
                out.write(buff, 0, length);
            }
        } catch (IOException ex) {
            throw ex;
        }
    }

}
