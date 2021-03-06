package com.example.demo.handler;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.moudle.MyException;
import com.example.demo.moudle.Result;
import com.example.demo.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(MyException.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result Handler(Exception e) {
		if (e instanceof MyException) {
			MyException myException = (MyException) e;
			return ResultUtil.error(myException.getCode(), myException.getMessage());
		} else if (e instanceof NoSuchAlgorithmException) {
			return ResultUtil.error(500, "参数异常");
		} else {
			logger.info("[系统异常]{}", e);
			//return ResultUtil.error(-1, "未知错误");
			return ResultUtil.error(-1, e.getMessage());
		}
	}
}
