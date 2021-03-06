package com.example.demo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Util implements EnOrDecryption {

	@Override
	public String doDecryption(String context) {
		Decoder decoder = Base64.getDecoder();
		String result = "";
		try {
			result = new String(decoder.decode(context), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String doEncrytion(String context) {

		Encoder encoder = Base64.getEncoder();
		byte[] text;
		try {
			text = context.getBytes("UTF-8");
			String result = encoder.encodeToString(text);
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
