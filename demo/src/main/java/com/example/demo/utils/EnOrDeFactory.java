package com.example.demo.utils;

import com.example.demo.modle.MyException;
import com.example.demo.modle.ResultEnum;

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
			enOrDecryption = new Base64Util();
			break;
			
		default:
			throw new MyException(ResultEnum.ILLEGAL_ARGUMENT);
		}

		return enOrDecryption;
	}
}
