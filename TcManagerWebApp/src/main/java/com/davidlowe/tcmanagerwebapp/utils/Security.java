package com.davidlowe.tcmanagerwebapp.utils;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


public abstract class Security
{
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    //---------------------------------------------------------
    // DO NOT CHANGE THESE AFTER SYSTEM GOES LIVE!!
    // Changing will result in passwords essentially being lost
    // and all users having to reset their passwords.
    private static final String HASHING_ALGORITHM = "PBKDF2WithHmacSHA512";
    private static final int ITERATIONS = 20000;
    // Using SHA512, so hashed passwords will be 512 bits, or 64 bytes
    private static final int HASHED_PASSWORD_LENGTH = 64;
    // How many randomly created characters are generated for each salt.
    private static final int SALT_LENGTH = 32;
    // DO NOT CHANGE THESE AFTER SYSTEM GOES LIVE!!
    //---------------------------------------------------------


    /**
     * Returns the string value of a byte array.
     *
     * @param byteArray Byte array that's being converted.
     * @return String value of byte array.
     */
    public static String byteArrayToString(byte[] byteArray)
    {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray);
    }


    /**
     * Returns byte array value of a string that was encoded using byteArrayToString.
     *
     * @param string String to be decoded back into a byte array.
     * @return Byte array version of the string.
     */
    public static byte[] stringToByteArray(String string)
    {
        return org.apache.commons.codec.binary.Base64.decodeBase64(string);
    }


    /**
     * Generates a random Salt value.
     *
     * @return String salt value. Use stringToByteArray to decode it into a byte array.
     */
    public static String getSalt()
    {
        final byte[] salt = new byte[SALT_LENGTH];
        SECURE_RANDOM.nextBytes(salt);
        return Security.byteArrayToString(salt);
    }


    /**
     * Generates a password's one-way hash value.
     *
     * @param clearTextPassword Password the user typed in.
     * @param salt              Randomly generated salt to spice up the password prior to hashing it.
     * @return One-way hashed version of the password, using the salt.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static String getHashedPassword(String clearTextPassword, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        final byte[] saltBytes = org.apache.commons.codec.binary.Base64.decodeBase64(salt);

        final KeySpec spec = new PBEKeySpec(clearTextPassword.toCharArray(), saltBytes, ITERATIONS, HASHED_PASSWORD_LENGTH * 8);

        final SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(HASHING_ALGORITHM);

        byte[] encBytes = secretKeyFactory.generateSecret(spec).getEncoded();

        return Security.byteArrayToString(encBytes);
    }
}
