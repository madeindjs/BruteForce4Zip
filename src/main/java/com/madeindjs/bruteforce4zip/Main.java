package com.madeindjs.bruteforce4zip;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ZipException, IOException {
        // verify argument
        if (args.length == 0) {
            System.err.println("You should specify a ZIP file");
            System.exit(0);
        }
        String source = args[0];
        String password = "test";

        BruteForcer forcer = new BruteForcer(source);
        forcer.run();
    }

}
