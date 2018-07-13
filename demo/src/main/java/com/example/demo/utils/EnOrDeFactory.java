package com.example.demo.utils;

import com.example.demo.moudle.MyException;
import com.example.demo.moudle.ResultEnum;

/**
 * @author wz 加密解密工厂类
 */
public class EnOrDeFactory {

	private EnOrDecryption enOrDecryption;

	public EnOrDecryption getInstance(String str) {

		switch (str) {
		case "Base64":
			enOrDecryption = new Base64Util();
			break;
		case "SHA-256":
			enOrDecryption = new SHA256Util();
			break;
			
		default:
			throw new MyException(ResultEnum.ILLEGAL_ARGUMENT);
		}

		return enOrDecryption;
	}
}
