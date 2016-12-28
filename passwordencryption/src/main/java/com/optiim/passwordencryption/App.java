package com.optiim.passwordencryption;

import com.optiim.passwordencryption.util.AdvancedEncryptionStandard;

/**
 * @author Onur Tokat Optiim
 * @param args[0]
 *            AES 128 Encryption Key
 * @param args[1]
 *            Password
 */
public class App {

	private static String encryptionKey = null;
	private static String plainText = null;
	private static String cipherText = null;
	private static AdvancedEncryptionStandard advancedEncryptionStandard;

	public static void main(String[] args) {

		if (args.length > 0) {
			if (args[0] != null) {
				encryptionKey = args[0];
				advancedEncryptionStandard = new AdvancedEncryptionStandard(encryptionKey);
			}
			if (args[1] != null) {
				plainText = args[1];
				try {
					cipherText = advancedEncryptionStandard.encrypt(plainText);
					System.out.println("Encrypted Şifre: " + cipherText);
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Girmiş olduğunuz key AES 128 formatına uygun değil!");
					System.exit(-1);
				}

			}
		} else if (args.length == 0) {
			System.out.println(
					"Parametreleri istenen şekilde giriniz! Birinci parametre AES key, ikinci parametre şifredir...");
		}
	}
}
