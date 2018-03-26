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
        String password = "test";

        tryPassword(source, password);

    }

    public static boolean tryPassword(String source, String password) {
        // verify source
        File file = new File(source);
        if (!file.isFile()) {
            System.err.println("Given file is not a valid file");
            System.exit(0);
        }
        String destination = new File(source).getParentFile().getPath();

        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile = new ZipFile(source);
            zipFile.setPassword(password);
            // zipFile.setRunInThread(true);
            zipFile.extractAll(destination);
            System.out.println(String.format("Password %s seems working (archive deflated)", password));
            return true;
        } catch (ZipException ex) {
            // System.err.println(String.format("Password %s does not work", password));
            return false;
        }

    }

}
