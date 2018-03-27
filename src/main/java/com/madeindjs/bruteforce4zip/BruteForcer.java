package com.madeindjs.bruteforce4zip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.FilerException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class BruteForcer {

    private String source;
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
        this.destination = new File(source).getParentFile().getPath();
        this.source = source;
        this.passwords = new Passwords();
    }

    public void run() {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            BufferedReader buffer = passwords.getBuffer();
            String line;
            while ((line = buffer.readLine()) != null) {
                Attempt attempt = new Attempt(source, line, destination);
                executor.execute(attempt);
            }

            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(BruteForcer.class.getName()).log(Level.SEVERE, null, ex);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.err.println("Can't find local passwords");
    }

}
