package com.example.demo.utils;

/**
 * @author adminn
 * 加密解密策略类
 */
public class EnOrDeContext {

	private EnOrDecryption strategy;
	
	public EnOrDeContext(EnOrDecryption strategy) {
		this.strategy = strategy;
	}
	
	public String encode(String context) {
		return strategy.doEncrytion(context);
	}
	
	public String decode(String context) {
		return strategy.doDecryption(context);
	}
}
