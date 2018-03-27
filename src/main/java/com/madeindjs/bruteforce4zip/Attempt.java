package com.madeindjs.bruteforce4zip;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * A Threaded Worker to try to open a zip file
 */
public class Attempt implements Runnable {

    private final String source;
    private final String password;
    private final String destination;

    public Attempt(String source, String password, String destination) {
        this.source = source;
        this.password = password;
        this.destination = destination;
    }

    @Override
    public void run() {
        if (tryPassword()) {
            System.out.println(password);
            System.exit(0);
        }
    }

    public boolean tryPassword() {
        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile.setPassword(password);
            zipFile.extractAll(destination);
            System.out.println(password);
            return true;
        } catch (ZipException ex) {
            return false;
        }
    }

}
