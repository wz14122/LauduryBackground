package com.example.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.modle.MyException;
import com.example.demo.modle.Result;
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
		} else {
			logger.info("[系统异常]{}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
