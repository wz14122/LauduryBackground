package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class SHA256Util implements EnOrDecryption {

	@Override
	public String doDecryption(String context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doEncrytion(String context) {
		// TODO Auto-generated method stub
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(context.getBytes());
			String result = Hex.encodeHexString(hash);
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
