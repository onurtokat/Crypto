package com.optiim.aesconverter.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Onur Tokat Optiim
 * @param AdvancedDecryptionStandard
 *            provides to decrypt the encrypted password to plaintext
 */
public class AdvancedDecryptionStandard {

	private String encryptionKey;

	public AdvancedDecryptionStandard(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String decrypt(String encrypted) throws Exception {

		Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
		byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(encrypted));

		return new String(plainBytes);
	}

	private Cipher getCipher(int cipherMode) throws Exception {

		String encryptionAlgorithm = "AES";
		SecretKeySpec keySpecification = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), encryptionAlgorithm);
		Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
		cipher.init(cipherMode, keySpecification);

		return cipher;
	}
}
