package com.example.demo.modle;

public enum ResultEnum {
	ILLEGAL_ACCESS(-1, "非法入侵"),
	UNKONW_ERROR(0, "未知错误"),
	SUCCESS(200, "成功"),
	USER_REPEAT(500, "用户重复"),
	NO_USER(500, "用户不存在"),
	PASSWORD_ERROR(500, "密码错误"),
	FORM_INCOMPLETE(503, "表单不完整"),
	ENTITY_NOTFOUND(504, "实体不存在"),
	ILLEGAL_ARGUMENT(505, "参数异常"),
	SYSTEM_ERROR(0, "系统异常"),
	;

	private Integer code;

	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
