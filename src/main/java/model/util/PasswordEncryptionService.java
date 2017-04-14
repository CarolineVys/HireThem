package model.util;

import model.service.exception.ServiceException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import static model.service.exception.ServiceErrorMessage.ENCTYPTION_EXCEPTION;
import static model.service.exception.ServiceErrorMessage.WRONG_PASSWORD;

/**
 * http://blog.jerryorr.com/2012/05/secure-password-storage-lots-of-donts.html
 */

public class PasswordEncryptionService {

    public void tryAuthenticateUser(String attemptedPassword, byte[] encryptedPassword, byte[] salt) throws ServiceException {
        // Encrypt the clear-text password using the same salt that was used to
        // encrypt the original password
        byte[] encryptedAttemptedPassword = new byte[0];
        try {
            encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
        } catch (ServiceException e) {
            throw new ServiceException(e);
        }

        // Authentication succeeds if encrypted password that the user entered
        // is equal to the stored hash
        if (!Arrays.equals(encryptedPassword, encryptedAttemptedPassword)) {
            throw new ServiceException(WRONG_PASSWORD);
        }
    }

    public byte[] getEncryptedPassword(String password, byte[] salt) throws ServiceException {
        // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
        // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
        String algorithm = "PBKDF2WithHmacSHA1";
        // SHA-1 generates 160 bit hashes, so that's what makes sense here
        int derivedKeyLength = 160;
        // Pick an iteration count that works for you. The NIST recommends at
        // least 1,000 iterations:
        // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
        // iOS 4.x reportedly uses 10,000:
        // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
        int iterations = 20000;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ENCTYPTION_EXCEPTION);
        }

        try {
            return f.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            throw new ServiceException(ENCTYPTION_EXCEPTION);
        }
    }

    public byte[] generateSalt() throws ServiceException {
        // VERY important to use SecureRandom instead of just Random
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }

        // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
        byte[] salt = new byte[8];
        random.nextBytes(salt);

        return salt;
    }
}

