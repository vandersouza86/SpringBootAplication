package com.poc.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poc.demo.exception.AESException;

public class AES {
	private static Logger LOGGER = LoggerFactory.getLogger(AES.class);
	private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	private static final String KEY = "pockeytes1";

	private AES() {
	}

	public static SecretKeySpec getSecretKey() throws UnsupportedEncodingException {
		SecretKeySpec genKey = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");
		return genKey;
	}

	public static String encrypt(final String strToEncrypt) throws AESException {
		LOGGER.info("Iniciando Criptografia...");
		try {
			final Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (final Exception ex) {
			LOGGER.error("Error while crypting: ", ex);
			throw new AESException(ex);
		}
	}

	public static String decrypt(final String strToDecrypt) throws AESException {
		LOGGER.info("Iniciando Decriptografia...");
		try {
			final Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (final Exception ex) {
			ex.printStackTrace();
			LOGGER.error("Error while decrypting: ", ex);
			throw new AESException(ex);
		}
	}

}