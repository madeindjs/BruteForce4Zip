package com.madeindjs.bruteforce4zip;

import java.io.File;
import java.io.FileNotFoundException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Main {

    public static final String MOST_PASS_URL = "https://github.com/danielmiessler/SecLists/raw/master/Passwords/openwall.net-all.txt";

    public static void main(String[] args) throws FileNotFoundException, ZipException {
        // verify argument
        if (args.length == 0) {
            System.err.println("You should specify a ZIP file");
            System.exit(0);
        }
        String source = args[0];
        String password = "test";

        BruteForcer forcer = new BruteForcer(source);
        forcer.tryPassword(source, password);
    }

}
