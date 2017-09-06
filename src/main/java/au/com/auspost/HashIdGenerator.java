package au.com.auspost;

import org.hashids.Hashids;

import java.security.SecureRandom;

/**
 * Generate an unique hashid (across instances)
 *
 * - Using long currenttime in ms
 * - A persisted long counter
 *
 * min 6 characters in hashid using ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890
 *
 */
public class HashIdGenerator {

    static long counter = 0L;
    static int MAX_RANDOM = 1000000;

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();


        Hashids hashids = new Hashids("application name as salt", 6, "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");

        for (long l = 1; l < 1000; l++) {

            counter++;

            long ts = System.currentTimeMillis()/1000;
            String hash = hashids.encode(random.nextInt(MAX_RANDOM));

            System.out.format("l=%d, hash=%s\n", ts, hash);
        }

    }
}
