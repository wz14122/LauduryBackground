package com.example.demo.utils;

import com.example.demo.modle.Result;

public class ResultUtil {

	public static <T> Result<T> success(T data) {
		return new Result<T>("200", "OK", data);
	}

	public static <T> Result<T> success() {
		return success(null);
	}

	public static Result<?> error(String code, String msg) {
		Result<?> result = new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

}
