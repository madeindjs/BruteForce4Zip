package com.madeindjs.bruteforce4zip;

import java.io.File;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class Main {

    public static void main(String[] args) {
        // verify argument
        if (args.length == 0) {
            System.err.println("You should specify a ZIP file");
            System.exit(0);
        }
        String source = args[0];

        // verify source
        File file = new File(source);
        if (!file.isFile()) {
            System.err.println("Given file is not a valid file");
            System.exit(0);
        }

        String destination = file.getParentFile().getPath();
        String password = "test";

        ZipFile zipFile;
        try {
            zipFile = new ZipFile(source);
            zipFile.setPassword(password);
            // zipFile.setRunInThread(true);
            zipFile.extractAll(destination);
            System.out.println(String.format("Password %s seems working (archive deflated)", password));
        } catch (ZipException ex) {
            System.err.println(String.format("Password %s does not work", password));
        }

    }

}
