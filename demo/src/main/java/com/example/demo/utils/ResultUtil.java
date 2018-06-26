package com.example.demo.utils;

import com.example.demo.modle.Result;

public class ResultUtil {

	public static Result success(Object data) {
		return new Result(200, "OK", data);
	}

	public static Result success() {
		return success(null);
	}

	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

}
