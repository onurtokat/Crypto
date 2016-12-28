package com.optiim.aesconverter;

import com.optiim.aesconverter.util.AdvancedDecryptionStandard;

/**
 * @author Onur Tokat Optiim
 * @param App
 *            class
 * @param args[0]
 *            AES 128 Encryption Key
 * @param args[1]
 *            Encrypted password
 */
public class App {
	private static String encryptionKey = null;
	private static String plainText = null;
	private static String cipherText = null;
	private static AdvancedDecryptionStandard advancedDecryptionStandard;

	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0] != null) {
				encryptionKey = args[0];
				advancedDecryptionStandard = new AdvancedDecryptionStandard(encryptionKey);
			}
			if (args[1] != null) {
				cipherText = args[1];
				try {
					plainText = advancedDecryptionStandard.decrypt(cipherText);
					System.out.println("Decrypted Şifre: " + plainText);
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Girmiş olduğunuz key AES 128 formatına uygun değil!");
					System.exit(-1);
				}

			}
		} else if (args.length == 0) {
			System.out.println(
					"Parametreleri istenen şekilde giriniz! Birinci parametre AES key, ikinci parametre encrypted şifredir...");
		}
	}
}
