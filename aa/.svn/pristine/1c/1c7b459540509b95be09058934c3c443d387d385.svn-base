package net.emisia.svn2git.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public final class EncodingUtils {

    public static String encryptPassword(String password) {
	try {
	    return DatatypeConverter.printHexBinary(encryptText(password, getSecretEncryptionKey()));
	} catch (Exception e) {
	    throw new RuntimeException(Messages.getString("Utils.runtimeError"));
	}
    }

    private static byte[] encryptText(String plainText, SecretKey secKey) throws Exception {
	Cipher aesCipher = Cipher.getInstance("AES");
	aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
	byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
	return byteCipherText;
    }

    private static SecretKey getSecretEncryptionKey() throws Exception {
	KeyGenerator generator = KeyGenerator.getInstance("AES");
	generator.init(128);
	SecretKey secKey = generator.generateKey();
	return secKey;
    }

    private EncodingUtils() {
    }
}
